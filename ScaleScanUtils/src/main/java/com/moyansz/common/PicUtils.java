package com.moyansz.common;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PicUtils {
	/**
	 * base64格式的图片转换成byte[]
	 * @param base64Pic
	 * @return
	 */
	public static byte[] transToBytes(String base64Pic) {
		if (StringUtils.isEmpty(base64Pic)) {
			return new byte[0];
		}
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] pic = decoder.decodeBuffer(base64Pic);

			return pic;
		} catch (Exception e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	/**
	 * byte[]的图片转换成 base64格式
	 * @param base64Pic
	 * @return
	 */
	public static String transToBase64(byte[] bytes) {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return new String();
		}
	}
}
