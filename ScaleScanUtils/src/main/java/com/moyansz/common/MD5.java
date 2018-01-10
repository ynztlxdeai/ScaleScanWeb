package com.moyansz.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




public class MD5 {
	
	

	/**
	 * 构造函数
	 */
	public MD5() {
	}

	/**
	 * 使用信息摘要MD5单向加密技术对字符串进行加密。 对字符串进行加密，生成32位的加密字符串
	 * 
	 * @param data
	 *            源串
	 * @return 加密串
	 */
	synchronized static public final String getMD5(String data) {
		if (data == null) {
			return null;
		}

		// 数据摘要实例化对象
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			return ByteUtils.bytesToHexString(digest.digest());
		} catch (NoSuchAlgorithmException nsae) {
			;
		}	
		return data;
	}
	
	/**
	 * 在MD5的基础上增加一个密约的加密
	 * @param data
	 * @return
	 */
	synchronized static public final String getTokenMD5(String token, String data) {
		byte[] tokens = token.getBytes();
		
		if (data == null) {
			return null;
		}

		// 数据摘要实例化对象
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			return ByteUtils.bytesToHexString(digest.digest(tokens));
		} catch (NoSuchAlgorithmException nsae) {
			;
		}	
		return data;
	}
	

}
