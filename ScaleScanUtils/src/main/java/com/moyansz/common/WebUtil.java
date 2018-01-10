package com.moyansz.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * web工具类
 * 
 * @author duyubo 2015年下午8:01:56
 */
public class WebUtil {
	private static Logger logger = Logger.getLogger(WebUtil.class);

	/**
	 * 异步方式 ，给 客户端写json数据
	 * 
	 * @param response
	 * @param msg
	 */
	public static void writeJsonToClient(HttpServletResponse response, String msg) {
		writeStr(response, msg, "text/json");
	}

	/**
	 * 异步方式给客户端些 文本数据
	 * 
	 * @param response
	 * @param msg
	 */
	public static void writeStrToClient(HttpServletResponse response, String msg) {
		writeStr(response, msg, "text/html");
	}

	public static void writeStr(HttpServletResponse response, String msg, String type) {
		response.setContentType(type);
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(msg);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			logger.error("网络异常", e);
		}
	}

	/**
	 * @function: 返回response应答
	 * @param response
	 * @param code
	 * @param msg
	 *            void
	 */
	public static void pushMSG(HttpServletResponse response, int code, String msg) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			response.setStatus(code);
			out = response.getWriter();
			out.print(msg);
			out.flush();
		} catch (IOException e) {
			logger.error("返回应答出现异常", e);
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 通过HttpServletRequest返回IP地址
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ip String
	 * @throws Exception
	 * @author HX1501337 李韩刚
	 */
	public static String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		logger.info("通过HttpServletRequest返回IP地址,IP=[" + ip + "]");
		return ip;
	}

	/**
	 * 通过IP地址获取MAC地址
	 * 
	 * @param ip
	 *            String,127.0.0.1格式
	 * @return mac String
	 * @throws Exception
	 * @author HX1501337 李韩刚
	 */
	public static String getMACAddress(String ip) throws Exception {
		logger.info("通过IP=[" + ip + "]地址获取MAC地址");
		String line = "";
		String macAddress = "";
		try {
			final String loopback_address = "127.0.0.1";
			// 如果为127.0.0.1,则获取本地MAC地址。
			if (loopback_address.equals(ip)) {
				InetAddress inetAddress = InetAddress.getLocalHost();
				// 貌似此方法需要JDK1.6。
				byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
				// 下面代码是把mac地址拼装成String
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					if (i != 0) {
						sb.append("-");
					}
					// mac[i] & 0xFF 是为了把byte转化为正整数
					String s = Integer.toHexString(mac[i] & 0xFF);
					sb.append(s.length() == 1 ? 0 + s : s);
				}
				// 把字符串所有小写字母改为大写成为正规的mac地址并返回
				macAddress = sb.toString().trim().toUpperCase();
				return macAddress;
			}
		} catch (Exception e) {
			logger.error("获取本地IP的MAC地址异常," + e.getMessage());
		}

		// 获取非本地IP的MAC地址
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String MAC_ADDRESS_PREFIX_A = "MAC Address = ";
			String MAC_ADDRESS_PREFIX_D = "MAC 地址 = ";
			String MAC_ADDRESS_PREFIX = "MAC";
			while ((line = br.readLine()) != null) {
				if (line != null) {
					int index_a = line.indexOf(MAC_ADDRESS_PREFIX_A);
					int index_d = line.indexOf(MAC_ADDRESS_PREFIX_D);
					int index = line.indexOf(MAC_ADDRESS_PREFIX);
					if (index_a > 0) {
						macAddress = line.substring(index_a + MAC_ADDRESS_PREFIX_A.length()).trim().toUpperCase();
						break;
					} else if (index_d > 0) {
						macAddress = line.substring(index_d + MAC_ADDRESS_PREFIX_D.length()).trim().toUpperCase();
						break;
					} else if (index > 0) {
						macAddress = line.substring(line.indexOf("=") + 2, line.length());
						break;
					}
				}
			}
			br.close();
		} catch (Exception e) {
			logger.error("获取非本地IP的MAC地址异常," + e.getMessage());
		}
		logger.info("通过IP=[" + ip + "]地址获取MAC地址=[" + macAddress + "]");
		return macAddress;
	}

	public static Map<String, String> getRequestParameters(HttpServletRequest request) {
		if (request == null)
			return null;
		Map<String, String> reMap = new HashMap<String, String>();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() != 0) {
					reMap.put(paramName, paramValue);
				}
			}
		}
		return reMap;
	}

	/**
	 * @function:获取http请求参数转换为json格式 @param request @return String @exception
	 */
	public static String getAllRequestParams(HttpServletRequest request) {
		Enumeration<String> enu = request.getParameterNames();
		StringBuffer bf = new StringBuffer();
		bf.append("{");
		while (enu.hasMoreElements()) {
			String paraName = enu.nextElement();
			bf.append("\"" + paraName + "\":");
			bf.append("\"" + request.getParameter(paraName) + "\",");
		}

		String sf = bf.toString();
		if (sf.endsWith(",")) {
			sf = sf.substring(0, sf.length() - 1);
		}

		return sf + "}";
	}

	/**
	 * 检查手机号
	 * 
	 * @function:
	 * @param telephone
	 * @return boolean
	 * @exception @author:HX1401077
	 * @since 1.0.0
	 */
	public static boolean checkTelePhone(String telephone) {
		if (telephone != null) {
			if (telephone.startsWith("p")) {
				telephone = telephone.replace("p", "");
			}
		}
		// Pattern pattern =
		// Pattern.compile("^0?(13[0-9]|15[012356789]|17[012356789]|18[012356789]|14[57])[0-9]{8}$");
		Pattern pattern = Pattern.compile("^0?(1[3456789])[0-9]{9}$");
		Matcher matcher = pattern.matcher(telephone);
		return matcher.matches();
	}

	/**
	 * 解析出url参数中的键值对
	 * 
	 * @param url
	 * @return
	 */
	public static Map<String, String> urlReq(String url) {
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(url)) {
			String[] urlArr = url.split("&");
			if (null != urlArr && urlArr.length > 0) {
				for (String urlStr : urlArr) {
					String[] urlStrArr = urlStr.split("=");
					if (null != urlStrArr && urlStrArr.length == 2) {
						map.put(urlStrArr[0], urlStrArr[1]);
					}
				}
			}
		}
		return map;
	}

}
