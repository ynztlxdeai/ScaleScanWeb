/**
 *
 * NMSUtils.java
 *
 *  版权所有
 */

package com.moyansz.common;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;

import shaded.com.google.gson.Gson;


/**
 * 产品级的工具类
 * 
 * @author lilong
 * 
 */
public class MHSHUtils {
	/**
	 * 判断字符串是否为Null或空字符串
	 * 
	 * @param String
	 *            要判断的字符串
	 * @return String true-是空字符串,false-不是空字符串
	 */
	public static boolean isStringNull(String s) {
		return s == null || "".equals(s.trim()) || "NULL".equalsIgnoreCase(s);

	}

	/**
	 * 字符串数组转换为字符串,使用逗号分隔
	 */
	public static String split(String[] s, String spliter) {
		if (isStringNull(s)) {
			return "";
		}
		if (s.length == 1) {
			return s[0];
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1) {
				sb.append(s[i]);
				break;
			}
			sb.append(s[i]).append(spliter);

		}

		return sb.toString();
	}

	/**
	 * 如果第一个字符串不为空则返回该字符串,否则返回第二个
	 */
	public static String isStringNull(String s, String _default) {
		if (isStringNull(s)) {
			return _default;
		}
		else {
			return s;
		}
	}

	/**
	 * 判断字符串数组是否为空
	 */
	public static boolean isStringNull(String[] s) {
		return (s == null || s.length == 0);
	}

	/**
	 * 改变字符串编码到gbk
	 */
	public static String toGBK(String src, String characterCode) {
		if (isStringNull(src)) return "";
		String s = null;
		try {
			s = new String(src.getBytes("ISO-8859-1"), characterCode);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 转换String到boolean
	 */
	public static boolean parseBoolean(String flag) {
		if (isStringNull(flag)) {
			return false;
		}
		else if (flag.equals("true") || flag.equals("1") || flag.equals("是") || flag.equals("yes")) {
			return true;
		}
		else if (flag.equals("false") || flag.equals("0") || flag.equals("否") || flag.equals("no")) {
			return false;
		}
		else {
			return false;
		}
	}

	/**
	 * 转换String到int <br>
	 * null或空字符,返回0 <br>
	 * true返回1 <br>
	 * false返回0
	 */
	public static int parseInt(String flag) throws NumberFormatException {
		if (isStringNull(flag)) {
			return 0;
		}
		else if (flag.equals("true")) {
			return 1;
		}
		else if (flag.equals("false")) {
			return 0;
		}
		else {
			return Integer.parseInt(flag);
		}
	}

	/**
	 * 转换String到long
	 */
	public static long parseLong(String flag) throws NumberFormatException {
		if (isStringNull(flag)) {
			return 0;
		}
		else {
			return Long.parseLong(flag);
		}
	}

	/**
	 * 字符填充
	 * 
	 * @param source
	 *            源字符串
	 * @param filler
	 *            填充字符,如0或*等
	 * @param length
	 *            最终填充后字符串的长度
	 * @return 最终填充后字符串
	 */
	public static String fill(String source, String filler, int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length - source.length(); i++) {
			sb.append(filler);
		}
		sb.append(source);
		return sb.toString();
	}

	/**
	 * 从开头到spliter字符,截取字符串数组中的每一项
	 * 
	 * @param arr
	 *            源字符串数组
	 * @param spliter
	 *            切割符
	 * @return 切割后的字符串数组
	 */
	public static String[] subStrBefore(String[] arr, String spliter) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(0, arr[i].indexOf(spliter));
		}
		return arr;
	}

	/**
	 * 
	 * 将字串转成日期，字串格式: yyyy-MM-dd
	 * 
	 * @param string
	 *            String
	 * @return Date
	 */
	public static Date parseDate(String string) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return (Date) formatter.parse(string);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string, boolean caseSensitive) {
		if (isStringNull(string) || isStringNull(strings)) {
			return false;
		}

		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive) {
				if (strings[i].equals(string)) {
					return true;
				}
			}
			else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符串数组中是否包含指定的字符串。大小写敏感。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string) {
		return contains(strings, string, true);
	}

	/**
	 * 不区分大小写判定字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean containsIgnoreCase(String[] strings, String string) {
		return contains(strings, string, false);
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String[]
	 * @return int[]
	 */
	public static int[] parseInt(String[] s) {
		if (isStringNull(s)) {
			return (new int[0]);
		}
		int[] result = new int[s.length];
		try {
			for (int i = 0; i < s.length; i++) {
				result[i] = Integer.parseInt(s[i]);
			}
		}
		catch (NumberFormatException ex) {
		}
		return result;
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String
	 * @return int[]
	 */
	public static int[] split(String s) throws NumberFormatException {
		if (isStringNull(s)) {
			return new int[0];
		}
		if (s.indexOf(",") > -1) {
			return split(s, ",");
		}
		else {
			int[] i = new int[1];
			i[0] = Integer.parseInt(s);
			return i;
		}
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String
	 * @param spliter
	 *            分隔符如逗号
	 * @return int[]
	 */
	public static int[] split(String s, String spliter) {
		if (isStringNull(s) || s.indexOf(spliter) == -1) {
			return (new int[0]);
		}
		String[] ary = s.split(spliter);
		int[] result = new int[ary.length];
		try {
			for (int i = 0; i < ary.length; i++) {
				result[i] = Integer.parseInt(ary[i]);
			}
		}
		catch (NumberFormatException ex) {
		}
		return result;
	}

	/**
	 * 将字符串的第一个字母大写
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String firstCharToUpperCase(String s) {
		if (isStringNull(s)) {
			return "";
		}
		char[] arrC = s.toCharArray();
		arrC[0] = Character.toUpperCase(arrC[0]);
		return String.copyValueOf(arrC);
	}

	/**
	 * 根据当前字节长度取出加上当前字节长度不超过最大字节长度的子串
	 * 
	 * @param str
	 * @param currentLen
	 * @param MAX_LEN
	 * @return
	 */
	public static String getSubStr(String str, int currentLen, int MAX_LEN) {
		int i;
		for (i = 0; i < str.length(); i++) {
			if (str.substring(0, i + 1).getBytes().length + currentLen > MAX_LEN) {
				break;
			}
		}
		if (i == 0) {
			return "";
		}
		else {
			return str.substring(0, i);
		}
	}

	/**
	 * 判断集合是否为空
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isCollectionNull(Collection<?> c) {
		return c == null || c.size() == 0;

	}

	/**
	 * 判断map是否为空
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isMapNull(Map<?, ?> map) {
		return map == null || map.size() == 0;
	}

	/**
	 * 获取guid
	 * 
	 * @return
	 */
	public static String getGuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 补齐字符串,当字符串长度少于规定长度时填充
	 * 
	 * @param str
	 *            当前字符串
	 * @param length
	 *            规定长度
	 * @param alignStr
	 *            填充的字符串
	 * @return
	 */
	public static String rightAlign(String str, int length, String alignStr) {
		if (isStringNull(str) || isStringNull(alignStr)) {
			return "";
		}
		int strLength = str.length();

		if (strLength < length) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length - strLength; i++) {
				sb.append(alignStr);
			}
			sb.append(str);
			return sb.toString();
		}
		return str;
	}

	/**
	 * 判断字符串是否为十六进制数组...(这也行？那要是十进制数组、八进制数组呢)
	 * 
	 * @param String
	 *            value
	 * @return boolean
	 */
	public static boolean isHexNumber(String value) {
		boolean result = false;
		String hexStr = "0123456789ABCDEF";
		if (value != null) {
			char[] chars = value.toUpperCase().toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (hexStr.indexOf(chars[i]) < 0) {
					return false;
				}
			}
			result = true;
		}
		return result;
	}

	/**
	 * 判断字符串是否为一个整型数(或者说该字符串是否能转换为整型)
	 * 
	 * @param String
	 *            value
	 * @return boolean
	 */
	public static boolean isNumber(String value) {
		boolean result = false;
		String decStr = "0123456789";
		if (value != null && !value.trim().equals("")) {
			char[] chars = value.toUpperCase().toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (decStr.indexOf(chars[i]) < 0) {
					return false;
				}
			}
			result = true;
		}
		return result;
	}

	/**
	 * 字符串是否是整数
	 * 
	 * @param Object
	 *            value
	 * @return boolean
	 */
	public static boolean isInt(Object value) {
		boolean result = false;
		if (value != null) try {
			Integer.parseInt(value.toString());
			result = true;
		}
		catch (Exception ex) {
			result = false;
		}
		return result;
	}

	/**
	 * 字符串是否是浮点数
	 * 
	 * @param Object
	 *            value
	 * @return boolean
	 */
	public static boolean isFloat(Object value) {
		boolean result = false;
		if (value != null) try {
			Float.parseFloat(value.toString());
			result = true;
		}
		catch (Exception ex) {
			result = false;
		}
		return result;
	}

	/**
	 * 整数值是否超过限制
	 * 
	 * @param int value
	 * @param int min
	 * @param int max
	 * @return boolean
	 */
	public static boolean isOverValue(int value, int min, int max) {
		return !((value >= min) && (value <= max));
	}

	/**
	 * 字符串是否是超过长度限制
	 * 
	 * @param String
	 *            value
	 * @param int minLen
	 * @param int maxLen
	 * @return boolean
	 */
	public static boolean isOverLength(String value, int minLen, int maxLen) {
		boolean result = false;
		if (value != null) {
			int min, max;
			min = (minLen < 0) ? 0 : minLen;
			max = (maxLen > 255) ? 255 : maxLen;
			int len = value.length();
			result = (len >= min) && (len <= max);
		}
		return !result;
	}

	/**
	 * 判断字符串是否是合法IP
	 * 
	 * @param String
	 *            ip
	 * @return boolean
	 */
	public static boolean isValidIP(String ip) {
		if ((ip == null) || ip.equals("")) return false;
		if (ip.endsWith(".") || ip.startsWith(".")) // add by yan
		// [考虑到输入有如：2.3.4.5.或者是.2.3.3.3]
		return false;
		if (ip != null) {
			String[] ips = ip.replace('.', ':').split(":");
			if (ips.length != 4) return false;
			for (int i = 0; i < ips.length; i++) {
				if (ips[i].length() > 3) return false;
				if (!isInt(ips[i])) return false;
				if (isOverValue(Integer.parseInt(ips[i]), 0, 255)) return false;
			}
		}
		return true;
	}

	public static boolean isValidIPWithNull(String ip) {

		if (null == ip || ip.endsWith(".") || ip.startsWith(".")) // add by yan
		// [考虑到输入有如：2.3.4.5.或者是.2.3.3.3]
		return false;
		if (ip != null) {
			String[] ips = ip.replace('.', ':').split(":");
			if (ips.length != 4) return false;
			for (int i = 0; i < ips.length; i++) {
				if (ips[i].length() > 3) return false;
				if (!isInt(ips[i])) return false;
				if (isOverValue(Integer.parseInt(ips[i]), 0, 255)) return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否是合法...这个叫啥来着...
	 * 
	 * @param String
	 *            ip
	 * @return boolean
	 */
	public static boolean isValid3DotAddr(String ip) {
		if ((ip == null) || ip.equals("")) return false;
		if (ip.endsWith(".") || ip.startsWith(".")) // add by yan
		return false;
		if (ip != null) {
			String[] ips = ip.replace('.', ':').split(":");
			if (ips.length != 3) return false;
			for (int i = 0; i < ips.length; i++) {
				if (!isInt(ips[i])) return false;
				if (isOverValue(Integer.parseInt(ips[i]), 0, 255)) return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否是合法MAC地址
	 * 
	 * @param String
	 *            mac
	 * @return boolean
	 */
	public static boolean isValidMac(String mac) {
		if ((mac == null) || mac.equals("")) return false;
		if (mac.length() != 17) return false;
		if (mac != null) {
			String[] macs = mac.split("-");
			if (macs.length != 6) return false;
			String chars = "0123456789ABCDEF-";
			char[] upMacs = mac.toUpperCase().toCharArray();
			for (int i = 0; i < upMacs.length; i++)
				if (chars.indexOf(upMacs[i]) < 0) return false;
		}
		return true;
	}

	/**
	 * 获取一个整数字符串的高低位表示的字节数组 比如"1234"转换后表示为"12 34"共2个字节 "12345"转换成4个字节的长度，结果为"12
	 * 34 5F FF" maxLen表示结果的元素个数 如果要转换的值长度不够maxLen，则用F代替
	 * 
	 * @param String
	 *            s1 整数字符串
	 * @param int maxLen 长度
	 * @return byte[]
	 */
	public static byte[] getHighLowBytes(String s1, int maxLen) {
		char[] cs = new char[maxLen];
		int i = 0;
		for (i = 0; i < maxLen; i++)
			cs[i] = 'F';
		char[] cs1 = s1.toCharArray();
		for (i = 0; i < cs1.length; i++)
			cs[i] = cs1[i];
		int len = maxLen / 2;
		byte[] result = new byte[len];
		for (int j = 0; j < len; j++) {
			int a = j * 2;
			int b = (j + 1) * 2;
			String s = s1.substring(a, b);
			result[j] = Byte.parseByte(s);
		}
		return result;
	}

	/**
	 * 获取字符串从指定位置开始的右边字串
	 * 
	 * @param String
	 *            src
	 * @param int count
	 * @return String
	 */
	public static String rightString(String src, int count) {
		String result = src;
		int len = src.length();
		if (count < len) {
			result = src.substring(len - count);
		}
		return result;
	}

	/**
	 * 获取字符串从指定位置开始的左边字串
	 * 
	 * @param String
	 *            src
	 * @param int count
	 * @return String
	 */
	public static String leftString(String src, int count) {
		String result = src;
		int len = src.length();
		if (count < len) {
			result = src.substring(0, count);
		}
		return result;
	}

	/**
	 * 把数字字符串的右边rightCount位自动加1，一般用户电话号码
	 * 
	 * @param String
	 *            src
	 * @param int rightCount
	 * @return String
	 */
	public static String incRightStr(String src, int rightCount) {
		String result = src;
		int len = src.length();
		if (isNumber(src)) {
			if (rightCount <= len) {
				String leftStr = leftString(src, len - rightCount);
				String rightStr = rightString(src, rightCount);
				StringBuffer buf = new StringBuffer();
				for (int i = 0; i < rightCount - 1; i++) {
					buf.append("0");
				}
				rightStr = buf.toString() + (Integer.parseInt(rightStr) + 1);
				rightStr = rightString(rightStr, rightCount);
				result = leftStr + rightStr;
			}
		}
		return result;
	}

	/**
	 * 把数字字符串的右边rightCount位自动减1，一般用户电话号码
	 * 
	 * @param String
	 *            src
	 * @param int rightCount
	 * @return String
	 */
	public static String decRightStr(String src, int rightCount) {
		String result = src;
		int len = src.length();
		if (isNumber(src)) {
			if (rightCount <= len) {
				String leftStr = leftString(src, len - rightCount);
				String rightStr = rightString(src, rightCount);
				StringBuffer zeroBuf = new StringBuffer();
				for (int i = 0; i < rightCount - 1; i++) {
					zeroBuf.append("0");
				}

				int dec = Integer.parseInt(rightStr) - 1;
				if (dec >= 0) {
					rightStr = zeroBuf.toString() + dec;
					rightStr = rightString(rightStr, rightCount);
					result = leftStr + rightStr;
				}
			}
		}
		return result;
	}

	/**
	 * 将int数据转换成规定长度的字符串，不够长度左边补零
	 * 
	 * @param int value 指定int数据
	 * @param int length 长度
	 * @return
	 */
	public static String getStringForInt(int value, int length) {
		String str = String.valueOf(value);
		int len = str.length();
		int addNum = length - len;
		if (addNum == 0) return "" + value;
		for (int i = 0; i < addNum; i++) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * 将阿拉伯数字转换为中文数
	 * 
	 * @param int i
	 * @return String
	 */
	public static String getCHNumberForInt(int i) {
		String str = "";
		switch (i) {
		case 0:
			str = "〇";
			break;
		case 1:
			str = "一";
			break;
		case 2:
			str = "二";
			break;
		case 3:
			str = "三";
			break;
		case 4:
			str = "四";
			break;
		case 5:
			str = "五";
			break;
		case 6:
			str = "六";
			break;
		case 7:
			str = "七";
			break;
		case 8:
			str = "八";
			break;
		case 9:
			str = "九";
			break;
		}
		return str;
	}

	/**
	 * 将阿拉伯数字转换为中文数
	 * 
	 * @param int i
	 * @return String
	 */
	public static String getIntForCH(String i) {
		String str = "";
		if (i.equals("一")) {
			str = "1";
		}
		if (i.equals("二")) {
			str = "2";
		}
		if (i.equals("三")) {
			str = "3";
		}
		if (i.equals("四")) {
			str = "4";
		}
		if (i.equals("五")) {
			str = "5";
		}
		if (i.equals("六")) {
			str = "6";
		}
		if (i.equals("七")) {
			str = "7";
		}
		if (i.equals("八")) {
			str = "8";
		}
		if (i.equals("九")) {
			str = "9";
		}
		if (i.equals("十")) {
			str = "10";
		}
		if (i.equals("零")) {
			str = "0";
		}
		if (i.equals("日")) {
			str = "0";
		}
		return str;
	}

	/**
	 * 判断本地IP是否在给定IP段，如果是返回本地IP，否则返回"127.0.0.1"...
	 * 
	 * @param String
	 *            matchIp
	 * @return String
	 */
	public static String getThisIp(String matchIp) {
		String result = "127.0.0.1";
		if (isValidIP(matchIp)) try {
			String hostName = InetAddress.getLocalHost().getHostName();
			InetAddress[] address = InetAddress.getAllByName(hostName);
			String[] ips = matchIp.replace('.', ':').split(":");
			for (int i = 0; i < address.length; i++) {
				String localIp = address[i].getHostAddress();
				String[] ips2 = localIp.replace('.', ':').split(":");
				if ((ips2[0].equals(ips[0])) && (ips2[1].equals(ips[1])) && (ips2[2].equals(ips[2]))) {
					result = localIp;
					break;
				}
			}
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 判断字符串数组是否包含某字符串
	 * 
	 * @param String
	 *            [] strs
	 * @param String
	 *            subStr
	 * @return boolean
	 */
	public static boolean isIndexOf(String[] strs, String subStr) {
		if (strs != null && strs.length != 0) {
			for (int i = 0; i < strs.length; i++)
				if ((strs[i] != null) && (strs[i].equalsIgnoreCase(subStr))) {
					return true;
				}
		}
		return false;
	}

	/**
	 * 判断整型数组中是否包含某整数
	 * 
	 * @param int[] values
	 * @param int value
	 * @return boolean
	 */
	public static boolean isIndexOf(int[] values, int value) {
		if (values != null && values.length > 0) {
			for (int i = 0; i < values.length; i++)
				if (values[i] == value) return true;
		}
		return false;
	}

	/**
	 * 判断某集合中是否包含某字符串
	 * 
	 * @param Vector
	 *            strs
	 * @param String
	 *            subStr
	 * @return boolean
	 */
	public static boolean isIndexOf(Vector<?> strs, String subStr) {
		if (strs != null) {
			for (int i = 0; i < strs.size(); i++) {
				if ((strs.get(i) != null) && (strs.get(i).toString().equalsIgnoreCase(subStr))) {
					return true;
				}
			}	
		}
		return false;
	}

	/**
	 * 获取格式化的当前时间。年月日时分秒 格式化为：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		Date now = Calendar.getInstance().getTime();
		String time = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(now);
		return time;
	}

	/**
	 * 获取两个日期间的时间差，以秒来计算。(传入时间必须为格式化的yyyy-MM-dd HH:mm:ss字符串)
	 * 
	 * @param 开始日期
	 *            startTimeStr
	 * @param 介绍日期
	 *            endTimeStr
	 * @return int
	 */
	public static int getSecondsBetweenTwoDate(String startTimeStr, String endTimeStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startTime = sdf.parse(startTimeStr);
			Date endTime = sdf.parse(endTimeStr);
			return (int) (endTime.getTime() - startTime.getTime()) / 1000;
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 获取当前时间：时分秒 格式化为：HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getCurTime() {
		Date now = Calendar.getInstance().getTime();
		String time = (new SimpleDateFormat("HH:mm:ss")).format(now);
		return time;
	}

	/**
	 * 获取当前日期：年月日 格式化为：yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurDate() {
		Date now = Calendar.getInstance().getTime();
		String time = (new SimpleDateFormat("yyyy-MM-dd")).format(now);
		return time;
	}

	/**
	 * 获取当前时间：年月日时分秒 格式化为yyyy-MM-dd_HH-mm-ss
	 * 
	 * @return String
	 */
	public static String getDatetime() {
		Date now = Calendar.getInstance().getTime();
		String time = (new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")).format(now);
		return time;
	}

	/**
	 * 获取合法日期
	 * 
	 * @param String
	 *            date
	 * @return String
	 */
	public static String getValidDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date aDate = format.parse(date);
			return format.format(aDate);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取合法时间
	 * 
	 * @param String
	 *            dateTime
	 * @return String
	 */
	public static String getValidDateTime(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date aDate = format.parse(dateTime);
			return format.format(aDate);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 延迟多少时间(毫秒计算)
	 * 
	 * @param long milSeconds
	 */
	public static void delay(long milSeconds) {
		if (milSeconds > 0) try {
			Thread.sleep(milSeconds);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 判断该时间是否合法
	 * 
	 * @param String
	 *            str
	 * @return boolean
	 */
	public static boolean isValidDataTime(String str) {
		if ((str == null) || str.trim().equals("")) return false;
		str = str.trim();
		if (str.length() != 19) return false;
		String year = str.substring(0, 4);
		if (!isInt(year)) return false;
		String month = str.substring(5, 7);
		if (!isInt(month)) return false;
		String day = str.substring(8, 10);
		if (!isInt(day)) return false;
		String hour = str.substring(11, 13);
		if (!isInt(hour)) return false;
		String minute = str.substring(14, 16);
		if (!isInt(minute)) return false;
		String second = str.substring(17, 19);
		if (!isInt(second)) return false;
		return true;
	}

	/**
	 * 把一个字节数组转换成16进制字符串
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexString(byte[] bytes) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("");
		String temp;
		int i, length;

		length = bytes.length;
		for (i = 0; i < length; i++) {
			temp = Integer.toHexString(bytes[i] & 0x000000ff);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			buffer.append(temp);
		}

		return buffer.toString();
	}

	/**
	 * 拷贝指定HashMap中的内容到新的HashMap，并返回该Map
	 * 
	 * @param HashMap
	 *            srcHashMap
	 * @return HashMap
	 */
//	public static HashMap cloneHashMap(HashMap srcHashMap) {
//		if (srcHashMap == null || srcHashMap.keySet().size() == 0) return null;
//		
//		else {
//			HashMap map = new HashMap();
//			Object[] keys = srcHashMap.keySet().toArray();
//			for (int i = 0; i < keys.length; i++) {
//				Object key = keys[i];
//				map.put(key, srcHashMap.get(key));
//			}
//			return map;
//		}
//	}

	/**
	 * 返回（底数是 e）double 值的自然对数。
	 * 
	 * @param double value
	 * @return double
	 */
	public static double log10(double value) {
		if (value > 0) return Math.log(value) / Math.log(10);
		else
			return -1;
	}

	/**
	 * 从MAP中获取指定键的值(整型值)
	 * 
	 * @param Map
	 *            map
	 * @param String
	 *            key
	 * @return int
	 */
	public static int getIntFromMap(Map<String, String> map, String key) {
		if (map == null || key == null) {
			return -1;
		}

		Set<Map.Entry<String, String>> set = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			String mapKey = entry.getKey();
			
			if (mapKey.trim().toUpperCase().equalsIgnoreCase(key.trim().toUpperCase())) {
				Object value = entry.getValue();
				if (value != null && isNumber(value.toString().trim())) {
					return Integer.parseInt(map.get(mapKey).toString().trim());
				}
			}
		}

		return -1;
	}

	/**
	 * 从MAP中获取指定键的值(字符串类型值)
	 * 
	 * @param Map
	 *            map
	 * @param String
	 *            key
	 * @return String
	 */
	public static String getStrFromMap(Map<String, Object> map, String key) {
		try {

			if (map == null || key == null) {
				return "";
			}
			
			Set<String> keySet = map.keySet();
			// Iterator iterator = keySet.iterator();
			boolean flag = false;
			Object mapKeys[] = keySet.toArray();
			for (int i = 0; i < mapKeys.length; i++) {
				if (String.valueOf(mapKeys[i]).equalsIgnoreCase(key)) {
					flag = true;
				}
			}

			if (!flag) return "";

			Set<Map.Entry<String,Object>> entrySet = map.entrySet();
			Iterator<Map.Entry<String,Object>> entrySetIt = entrySet.iterator();
			
			while (entrySetIt.hasNext()) {
				Entry<String, Object> entry = entrySetIt.next();
				String mapKey = entry.getKey();
				
				if (mapKey.trim().toUpperCase().equalsIgnoreCase(key.trim().toUpperCase())) {
					if (entry.getValue() == null || entry.getValue().toString().equals("")) {
						return "";
					}
					return entry.getValue().toString().trim();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取Map中对应键key（忽略大小写和空格）的值
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static Object getObjFromMap(Map<String, String> map, String key) {
		if (map == null || key == null) {
			return null;
		}

		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			String mapKey = entry.getKey();
			
			if (mapKey.trim().toUpperCase().equalsIgnoreCase(key.trim().toUpperCase())) {
				return entry.getValue();
			}
		}

		return null;
	}

	/**
	 * 检查字符串是否符合规则，形如：1,3-5 或者 3-9
	 * 
	 * @param String
	 *            str
	 * @return boolean
	 */
	public static boolean checkStrValid(String str) {
		if (str == null || str.trim().equals("")) return false;
		else {
			String[] strs = str.split(",");
			if (strs.length == 0) return false;
			int min = -1;
			for (int i = 0; i < strs.length; i++) {
				min = checkSub(strs[i], min);
				if (min == -2) return false;
			}
			return true;
		}
	}

	/**
	 * 检查字符串是否为单个数字或者是 3-9
	 * 
	 * @param String
	 *            str
	 * @param int min
	 * @return int
	 */
	private static int checkSub(String str, int min) {
		if (isInt(str)) {
			int id = Integer.parseInt(str);
			if (id <= min) return -2;
			else {
				min = id;
				return min;
			}
		}
		else if (str != null) {
			String[] strs = str.split("-");
			if (strs.length != 2) return -2;
			else {
				if (isInt(strs[0]) && Integer.parseInt(strs[0]) > min && isInt(strs[1])
						&& Integer.parseInt(strs[1]) > min && Integer.parseInt(strs[0]) < Integer.parseInt(strs[1])
						&& Integer.parseInt(strs[1]) < 63) return Integer.parseInt(strs[1]);
			}
		}
		return -2;
	}

	/**
	 * 从合法的字符串中获取数字列表 形如：3,9-13 输出结果为:[3,9,10,11,12,13]
	 * 
	 * @param String
	 *            str
	 * @return List
	 */
	public static List<String> getIdsFromStr(String str) {
		List<String> list = new ArrayList<String>();
		if (str == null) return list;
		
		String[] subStr = str.split(",");
		
		for (int i = 0; i < subStr.length; i++) {
			List<String> subIds = getSubFromStr(subStr[i]);
			for (int j = 0; j < subIds.size(); j++) {
				Object obj = subIds.get(j);
				
				if (!list.contains(obj)) list.add(obj.toString());
			}
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				try {
					int aValue = Integer.parseInt(a);
					int bValue = Integer.parseInt(b);
					if (aValue > bValue) return 1;
					return aValue >= bValue ? 0 : -1;
				}
				catch (NumberFormatException e) {
					return -1;
				}
			}
		});
		
		return list;
	}

	/**
	 * 从合法的字符串中获取数字列表 形如：5-8 输出结果为:[5,6,7,8]
	 * 
	 * @param String
	 *            str
	 * @return List
	 */
	private static List<String> getSubFromStr(String str) {
		List<String> list = new ArrayList<String>();
		if (str == null || str.trim().equals("")) {
		}
		else if (isInt(str)) {
			if (Integer.parseInt(str) > -1) list.add(str);
		}
		else if (str.length() >= 1) {
			String[] strs = str.split("-");
			if (strs.length == 1) list.add(str);
			else {
				int start = Integer.parseInt(strs[0]);
				int end = Integer.parseInt(strs[1]);
				for (int i = start; i <= end; i++) {
					list.add(String.valueOf(i));
				}
			}
		}
		return list;
	}

	/**
	 * 将Id列表转换成字符串，形如 [4,7,8,9,22,25,26] 输出结果为:4-9,22,25-26
	 * 
	 * @param List
	 *            ids
	 * @return String
	 */
	public static String getIdString(List<String> ids) {
		try {
			if (ids == null || ids.size() == 0) return " ";
			
			Collections.sort(ids, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					try {
						int aValue = Integer.parseInt(a);
						int bValue = Integer.parseInt(b);
						if (aValue > bValue) return 1;
						return aValue >= bValue ? 0 : -1;
					}
					catch (NumberFormatException e) {
						return -1;
					}
				}
			});

			Vector<List<String>> v = new Vector<List<String>>();
			List<String> newList = new ArrayList<String>();
			int j = 0, i = 0;

			int id = Integer.parseInt(ids.get(0).toString());
			i = id;
			boolean isEqu = true;
			for (; j < ids.size() && j < 63;) {
				id = Integer.parseInt(ids.get(j).toString());
				if (i == id) {
					if (!isEqu) // 如果前一个是不相等，那么要新建一个列表
					newList = new ArrayList<String>();
					isEqu = true;
					newList.add(String.valueOf(i));
					if (j == ids.size() - 1) v.add(newList);
					i++;
					j++;
				}
				else if (id < i) {
					if (isEqu) v.add(newList);
					isEqu = false;
					j++;
				}
				else {
					if (isEqu) v.add(newList);
					isEqu = false;
					i++;
				}
			}
			// String str = "";
			StringBuffer buf = new StringBuffer();
			for (i = 0; i < v.size(); i++) {
				List<String> list = v.get(i);
				if (i < v.size() - 1) {
					if (list.size() == 1) {
						buf.append(list.get(0).toString());
					}
					else {
						buf.append(list.get(0).toString());
						buf.append("-");
						buf.append(list.get(list.size() - 1).toString());
					}
					buf.append(",");
				}
				else {
					if (list.size() == 1) {
						buf.append(list.get(0).toString());
					}
					else {
						buf.append(list.get(0).toString());
						buf.append("-");
						buf.append(list.get(list.size() - 1).toString());
					}
				}
			}
			return buf.toString();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	/**
	 * 将id列表转换成 1,2,3,4,5,9,10,11的形式
	 * 
	 * @param List
	 *            ids
	 * @return String
	 */
	public static String getStrFromIds(List<String> ids) {
		StringBuffer buf = new StringBuffer();
		if (ids != null && ids.size() > 0) for (int i = 0; i < ids.size(); i++) {
			if (i == 0) {
				buf.append(ids.get(i));
			}
			else {
				buf.append(",");
				buf.append(ids.get(i));
			}
		}
		return buf.toString();
	}

	/**
	 * 将1-5,9-11转换成 1,2,3,4,5,9,10,11的形式
	 * 
	 * @param String
	 *            ids
	 * @return String
	 */
	public static String getStrFromIds(String srcStr) {
		return getStrFromIds(getIdsFromStr(srcStr));
	}

	public static String getIdStrFromInt(int value) {
		List<String> list = byteIntToIntArray(value);
		return getStrFromIds(list);
	}

	/**
	 * 将id转换为2进制的数字，形如：15 输出为 [0,1,2,3]
	 * 
	 * @param int id
	 * @return List
	 */
	public static List<String> byteIntToIntArray(int id) {
		List<String> list = new ArrayList<String>();
		int size = id / 2 + 1;
		for (int i = 0; i < size; i++) {
			if (id % 2 != 0) list.add(String.valueOf(i));
			id = id / 2;
		}
		return list;
	}

	/**
	 * 将多个Id转换成数字
	 * 
	 * @param List
	 *            ids
	 * @return int
	 */
	public static int byteIntArrayToInt(List<String> ids) {
		int value = 0;
		if (ids != null && ids.size() > 0) for (int i = 0; i < ids.size(); i++) {
			value = value + (int) Math.pow(2, Integer.parseInt(ids.get(i).toString()));
		}
		return value;
	}

	/**
	 * 将诸如 1,2,3,4等这样数字转换成数字，如:0,1,2,3 输出结果为 15
	 * 
	 * @param String
	 *            str
	 * @return int
	 */
	public static int stringIdsToInt(String str) {
		if (str == null || str.trim().equals("")) return -1;
		return byteIntArrayToInt(getIdsFromStr(str));
	}

	public static List<String> getListFromMap(HashMap<String, String> map, String[] keys) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < keys.length; i++)
			list.add(map.get(keys[i]));
		return list;
	}

	

	/**
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(MHSHUtils.getGuid());
		System.out.println(MHSHUtils.getGuid());
		System.out.println(MHSHUtils.getGuid());
		System.out.println(MHSHUtils.getGuid());
		System.out.println(MHSHUtils.getGuid());
		System.out.println(MHSHUtils.getGuid());
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("guid", "1");
		m1.put("parent_guid", "-1");

		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("guid", "2");
		m2.put("parent_guid", "1");

		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("guid", "3");
		m3.put("parent_guid", "2");

		Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("guid", "4");
		m4.put("parent_guid", "-1");

		Map<String, Object> m5 = new HashMap<String, Object>();
		m5.put("guid", "5");
		m5.put("parent_guid", "1");

		Map<String, Object> m6 = new HashMap<String, Object>();
		m6.put("guid", "6");
		m6.put("parent_guid", "3");

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);

	}

	/**
	 * 十六进制数组转换为字符串
	 * 
	 * @param String
	 *            srcString
	 * @return String
	 */
	public static String chAciiscToChStr(String srcString) {
		return new String(twoCharsToOneBytes(srcString));
	}

	public static byte[] twoCharsToOneBytes(String digits) {
		int length;
		byte[] buffer;
		String temp, temp2;
		length = digits.trim().length();
		if (length % 2 != 0) {
			digits = digits + "f";
			length = length + 1;
		}
		buffer = new byte[length / 2];
		for (int i = 0; i < length - 1;) {
			temp = digits.substring(i, i + 1);
			temp2 = digits.substring(i + 1, i + 2);
			buffer[i / 2] = (byte) ((0x000000f0 & Integer.parseInt(temp, 16) << 4) | 0x0000000f & Integer.parseInt(
					temp2, 16));
			i = i + 2;
		}
		return buffer;
	}

	/**
	 * 在指定字符串前面追加多次特殊字符
	 * 
	 * @param srcStr
	 * @param appendStr
	 * @param num
	 * @return
	 */
	public static String appendStrBefore(String srcStr, String appendStr, int num) {
		for (int i = 0; i < num; i++) {
			srcStr = appendStr + srcStr;
		}
		return srcStr;
	}

	/**
	 * 若Map中有非String类型的value，则转成String
	 * 
	 * @param resultMap
	 */
	public static void tranlateString(Map<String, Object> resultMap) {
		if (resultMap == null) {
			return;
		}

		Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			String mapKey = entry.getKey();
			Object obj = entry.getValue();

			if (obj != null) {
				resultMap.put(mapKey, obj.toString());
			}

		}
	}

	/**
	 * 字符串时间转换为长时间格式 eg:"2013-08-01 12:22:33"转为 1375286400000
	 * 
	 * @param String
	 * @return long
	 * @author gaoxp
	 */
	public static long str2Long(String strTime) {
		long l = 0l;
		try {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.setTime(formatter.parse(strTime));
			l = c.getTimeInMillis();
			return l;
		}
		catch (Exception e) {
			return l;

		}
	}

	/**
	 * 字符串时间转换为长时间格式 eg:"2013-08-01"转为 1375286400000
	 * 
	 * @param String
	 * @return long
	 * @author gaoxp
	 */
	public static long str2Long2(String strTime) {
		long l = 0l;
		try {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			c.setTime(formatter.parse(strTime));
			l = c.getTimeInMillis();
			return l;
		}
		catch (Exception e) {
			return l;

		}
	}

	/**
	 * 长时间格式转换为字符串时间 eg: 1375286400000转为"2013-08-01 12:22:33"
	 * 
	 * @param long
	 * @return String
	 * @author gaoxp
	 */
	public static String long2Str(long lTime) {
		String s = "";
		try {
			Date d = new Date();
			d.setTime(lTime);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			s = formatter.format(d);
			return s;
		}
		catch (Exception e) {
			return s;
		}
	}

	/**
	 * 长时间格式转换为字符串时间 eg: 1375286400000转为"2013-08-01"
	 * 
	 * @param long
	 * @return String
	 * @author gaoxp
	 */
	public static String long2Str2(long lTime) {
		String s = "";
		try {
			Date d = new Date();
			d.setTime(lTime);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			s = formatter.format(d);
			return s;
		}
		catch (Exception e) {
			return s;
		}
	}

	/**
	 * JSON串转成对象
	 * 
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public static <T> T fromJson(String jsonStr, Class<T> cls) throws Exception {
		if (jsonStr == null || jsonStr.equals("") || jsonStr.equals(" ")) {
			return null;
		}
		Gson gson = new Gson();
		T    obj  = gson.fromJson(jsonStr, cls);
		return obj;
	}

	/**
	 * JSON串转成对象
	 * 
	 * @param jsonStr
	 * @param typeOfT
	 * @return
	 */
	public static Object fromJson(String jsonStr, Type typeOfT) throws Exception {
		if (jsonStr == null || jsonStr.equals("") || jsonStr.equals(" ")) {
			return null;
		}
		Gson gson = new Gson();
		Object obj = gson.fromJson(jsonStr, typeOfT);
		return obj;
	}

	/**
	 * 对象转JSON串
	 * 
	 * @param t
	 * @return
	 */
	public static <T> String toJson(T obj) throws Exception {
		if (obj == null) {
			return null;
		}
		Gson gson = new Gson();
		String jsonStr = gson.toJson(obj);
		return jsonStr;
	}

	public static Class<?> classForName(String classname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return Class.forName(classname, true, classLoader);
	}
}
