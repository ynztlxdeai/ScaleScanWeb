/**   
 * @projectName:cybCommon  
 * @packageName:com.hx.cyb.common.properties  
 * @className:ProConfigUtil.java  
 *   
 * @createTime:2015年3月28日-下午2:24:01  
 *  
 *    
 */
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
 * @description: 加载中间件配置文件到Map集合中
 * @fileName:ProConfigUtil.java
 * @createTime:2015年5月22日 下午6:31:14
 * @author:李辞辞
 * @version 1.0.0
 *
 */
public class ProSMSUtil {
	private static ProSMSUtil instance = new ProSMSUtil();
	private Map<String, String> configMap = new HashMap<String, String>();
	private static final Logger log = Logger.getLogger(ProSMSUtil.class);

	private ProSMSUtil() {
		init();
	}

	public static ProSMSUtil getInstance() {
		if (instance == null) {
			instance = new ProSMSUtil();
		}
		return instance;
	}

	private void init() {
		Properties props = null;
		InputStream ips = null;
		try {
			props = new Properties();
			ips = this.getClass().getResourceAsStream("/conf/sms.properties");
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
		String temp = ProSMSUtil.getInstance().getConfig("imgSavePath");
		if (temp != null) {
			System.out.println(temp);
		}
	}
}
