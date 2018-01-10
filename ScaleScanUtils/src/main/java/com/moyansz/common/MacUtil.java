/**
 *
 * MacUtil.java
 *
 *  Copyright 2012 邦彦信息技术有限公司
 *  版权所有
 */

package com.moyansz.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * MAC地址工具类
 * 
 * @author lilong
 * 
 */
public class MacUtil {
	private static Logger logger = Logger.getLogger(MacUtil.class);
	public static final String MAC_PATTERN_FORWIN = "[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}";
	public static final String MAC_PATTERN_FORLIN = "[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}";

	public static List<String> getLocalMacs() throws SocketException {
		List<String> macsList = new ArrayList<String>();
		Map<String, String> macs = new HashMap<String, String>();
		getLocalMacByStandard(macs);
		Iterator<Entry<String, String>> iter = macs.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			macsList.add((String) entry.getValue());
		}

		return macsList;
	}

	public static List<String> getLocalMacsByCommand() throws SocketException {
		String os = System.getProperty("os.name");
		List<String> macsList = new ArrayList<String>();
		Map<String, String> macs = new HashMap<String, String>();

		if (os.startsWith("Windows"))
			getWinLocalMacByCommand(macs);
		else {
			getLinuxLocalMacByCommand(macs);
		}

		Iterator<Entry<String, String>> iter = macs.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			macsList.add((String) entry.getValue());
		}

		return macsList;
	}

	public static Map<String, String> getLocalMacMap() throws SocketException {
		Map<String, String> macs = new HashMap<String, String>();
		getLocalMacByStandard(macs);

		return macs;
	}

	public static Map<String, String> getLocalMacMapByCommand() throws SocketException {
		Map<String, String> macs = new HashMap<String, String>();
		String os = System.getProperty("os.name");
		if (os.startsWith("Windows"))
			getWinLocalMacByCommand(macs);
		else {
			getLinuxLocalMacByCommand(macs);
		}

		return macs;
	}

	private static void getWinLocalMacByCommand(Map<String, String> macs) {
		String ipConfigResponse = null;
		try {
			ipConfigResponse = runConsoleCommand("ipconfig /all");
		} catch (IOException localIOException) {
			logger.error("Excute ipconfig /all failed.");
			return;
		}

		StringTokenizer tokenizer = new StringTokenizer(ipConfigResponse, "\n");
		while (tokenizer.hasMoreTokens()) {
			String line = tokenizer.nextToken().trim();
			int macAddressPosition = line.indexOf(":");
			if (macAddressPosition == 0) {
				continue;
			}
			String mac = line.substring(macAddressPosition + 1).trim();
			if ((!mac.matches(
					"[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}-[0-9a-fA-F]{2}"))
					|| (!isMacAddOSX(mac))) {
				continue;
			}
			if (macs.containsValue(mac)) {
				continue;
			}

			macs.put(mac, mac);
		}
	}

	private static void getLocalMacByStandard(Map<String, String> macs) throws SocketException {
		Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
		while (networks.hasMoreElements()) {
			NetworkInterface ni = (NetworkInterface) networks.nextElement();
			if ((ni.isVirtual()) || (ni.isLoopback()) || (!ni.supportsMulticast()) || (ni.isPointToPoint())) {
				continue;
			}
			byte[] data = ni.getHardwareAddress();
			if ((data != null) && (data.length > 0)) {
				String mac = parseMac(data);
				if (macs.containsValue(mac)) {
					continue;
				}

				macs.put(mac, mac);
			}
		}
	}

	private static void getLinuxLocalMacByCommand(Map<String, String> macs) {
		String ipConfigResponse = null;
		try {
			ipConfigResponse = runConsoleCommand("/sbin/ifconfig");
		} catch (Exception e) {
			logger.error("Excute /sbin/ifconfig error.", e);
			try {
				ipConfigResponse = runConsoleCommand("ifconfig");
			} catch (Exception e1) {
				logger.error("Excute ifconfig error.", e1);
				return;
			}
		}

		StringTokenizer tokenizer = new StringTokenizer(ipConfigResponse, "\n");
		while (tokenizer.hasMoreTokens()) {
			String line = tokenizer.nextToken().trim();
			int macAddressPosition = line.lastIndexOf(" ");
			if (macAddressPosition == 0) {
				continue;
			}
			String mac = line.substring(macAddressPosition + 1).trim();

			if ((!mac.matches(
					"[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}"))
					|| (!isMacAddOSX(mac))) {
				continue;
			}
			mac = mac.replace(":", "-");
			if (macs.containsValue(mac)) {
				continue;
			}

			macs.put(mac, mac);
		}
	}

	private static String runConsoleCommand(String command) throws IOException {
		Process p = Runtime.getRuntime().exec(command);
		InputStream stdoutStream = new BufferedInputStream(p.getInputStream());
		StringBuffer buffer = new StringBuffer();
		while (true) {
			int c = stdoutStream.read();
			if (c == -1) {
				break;
			}
			buffer.append((char) c);
		}
		String outputText = buffer.toString();
		stdoutStream.close();
		return outputText;
	}

	private static boolean isMacAddOSX(String macAddressCandidate) {
		return macAddressCandidate.length() == 17;
	}

	public static String parseMac(byte[] data) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			sb.append(String.format("%02X%s", new Object[] { Byte.valueOf(data[i]), "-" }));
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}