/**  
 * Project Name:filmbMiddleware  
 * File Name:PropertyUtil.java  
 * Package Name:com.filmb.middlew.base.property  
 * Date:2014年11月26日下午4:37:38  
 * Copyright (c) 2014  
 *  
*/
/**   
 * @projectName:filmbMiddleware  
 * @packageName:com.filmb.middlew.base.property  
 * @className:PropertyUtil.java  
 *   
 * @createTime:2014年11月26日-下午4:37:38  
 *  
 *    
 */

package com.moyansz.properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description:属性文件读取类
 * @fileName:PropertyUtil.java
 * @createTime:2014年11月26日 下午4:37:38
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class PropertyConfig extends PropertyPlaceholderConfigurer {
	private static Map<String, String> map = new HashMap<String, String>(); // 将属性保存起来

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = null;
			if (keyStr != null) {
				value = props.getProperty(keyStr);
			}
			map.put(keyStr, value);
			// System.out.println("---------------------------keyStr="+keyStr+",value="+value);

		}
	}

	public static String getValueBykey(String key) {
		String value = map.get(key);
		if (StringUtils.isEmpty(value)) {
			value = "no exception define in property file (middleware), key:" + key;
		}
		return value;
	}
}
