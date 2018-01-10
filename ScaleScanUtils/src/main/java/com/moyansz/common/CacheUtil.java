package com.moyansz.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 缓存工具类
 * @fileName:CacheUtil.java
 * @author:肖震
 * @version 1.0.0
 */
public class CacheUtil {
	private static Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

	/**
	 * @function:存入Cache
	 * @param key
	 * @param value
	 * @return boolean
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static boolean add(String key, Object value) {
		boolean flag = false;
		if (!StringUtils.isEmpty(key) && value != null) {
			cache.put(key, value);
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @function:根据key获得value
	 * @param key
	 * @return Object
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static Object getValueByKey(String key) {
		Object value = null;
		if (!StringUtils.isEmpty(key)) {
			value = cache.get(key);
		}
		return value;
	}

	/**
	 * 
	 * @function: cache中删除key
	 * @param key
	 * @return boolean
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static boolean remove(String key) {
		boolean flag = false;
		if (!StringUtils.isEmpty(key) && cache.containsKey(key)) {
			cache.remove(key);
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @function: 清空缓存
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static void clear() {
		cache.clear();
	}

	/**
	 * 
	 * @function:获得缓存大小
	 * @return int
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static int size() {
		return cache.size();
	}
}
