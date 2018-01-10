
package com.moyansz.properties;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author lilong
 * @date 2016年11月25日
 */
public class PayConfigUtil {
	private static final Logger log = Logger.getLogger(PayConfigUtil.class);
	
	private static PayConfigUtil instance = new PayConfigUtil();
	private Map<String, String> configMap = new HashMap<String, String>();
	

	private PayConfigUtil() {
		init();
	}

	public static PayConfigUtil getInstance() {
		if (instance == null) {
			instance = new PayConfigUtil();
		}
		return instance;
	}

	private void init() {
		Properties props = null;
		InputStream ips = null;
		try {
			props = new Properties();
			ips = this.getClass().getResourceAsStream("/conf/payconfig.properties");
			props.load(ips);
			Enumeration enm = props.propertyNames();
			while (enm.hasMoreElements()) {
				String key = (String) enm.nextElement();
				String value = props.getProperty(key);
				this.configMap.put(key, value);
			}
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			try {
				if (ips != null) {
					ips.close();
					ips = null;
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public String getConfig(String key) {
		if (key == null)
			return null;
		if (this.configMap.containsKey(key)) {
			return (String) this.configMap.get(key);
		} else {
			return "";
		}
	}

	public boolean resetPara(String key, String value) {
		this.configMap.put(key, value);
		return true;
	}

	public static void main(String[] str) {
		String temp = PayConfigUtil.getInstance().getConfig("ali.alipay_public_key");
		if (temp != null) {
			System.out.println(temp);
		}
	}
}
