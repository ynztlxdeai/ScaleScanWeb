/**
 * Project Name:filmbComm File Name:EncryptUtil.java Package
 * Name:com.filmb.comm.utils Date:2014年11月19日下午3:26:07 Copyright (c) 2014
 * 
 */
/**
 * @projectName:filmbComm
 * @packageName:com.filmb.comm.utils
 * @className:EncryptUtil.java
 * 
 * @createTime:2014年11月19日-下午3:26:07
 * 
 * 
 */

package com.moyansz.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:MD5,SHA加密工具类
 * @fileName:EncryptUtil.java
 * @createTime:2014年11月19日 下午3:26:07
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class EncryptUtil {

	/**
	 * 
	 * @function:md5加密
	 * @param inputText
	 * @return String
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}

	/**
	 * 
	 * @function: sha加密
	 * @param inputText
	 * @return String
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static String sha(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	/**
	 * 
	 * @function: md5或者sha-1加密
	 * @param inputText
	 *            要加密的内容
	 * @param algorithmName加密算法名称：md5或者sha-1，不区分大小写
	 * @return String
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	/**
	 * 
	 * @function:返回十六进制字符串
	 * @param arr
	 * @return String
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

	// 测试
	public static void main(String[] args) {
		// md5加密测试
		String md5_1 = md5("123");
		String md5_2 = md5("abc");
		System.out.println(md5_1 + "\n" + md5_2);
		System.out.println("md5 length: " + md5_1.length());
		System.out.println("md5 length: " + md5_2.length());
		// sha加密测试
		String sha_1 = sha("123");
		String sha_2 = sha("abc");
		System.out.println(sha_1 + "\n" + sha_2);
		System.out.println("sha length: " + sha_1.length());
	}
}
