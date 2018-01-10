package com.moyansz.common;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @描述: 验证工具类.
 * @作者: luck
 * @创建时间: 2015-8-9,上午10:15:34 .
 * @版本: 1.0 .
 */
public class ValidateUtils {

	/**
	 * 判断传入参数是否为字母与数字的组合字符串,而不是单一的字母或者数字
	 * 
	 * @param psw
	 * @return
	 */
	public static boolean isPassword(String pwd) {
		if (ValidateUtils.isInteger(pwd)) {// 是否全部为数字
			return false;// 全部为数字
		} else {
			if (ValidateUtils.isLettersOnly(pwd)) {
				return false;// 全部为字母
			} else {
				if (ValidateUtils.isAlphanumeric(pwd)) {
					return true;// 正常数据
				} else {
					return false;// 包含了非法数据
				}
			}
		}
	}

	public static boolean isPassword2(String str) {
		String regex = "[A-Za-z_0-9]{6,16}";
		return match(regex, str);
	}

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 判断字母、数字（适用于密码校验）.
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false capital
	 */
	public static boolean isAlphanumeric(String str) {
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 必须为字母.
	 * 
	 * @param str
	 *            传入的字符串
	 * @return true or false .
	 */
	public static boolean isLettersOnly(String str) {
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为有且只有小数点后面包含两位的数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDoubleAnd2decimals(String str) {
		Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))([.](\\d){1,2})?$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 验证一个字符串是否完全由纯数字组成的字符串，当字符串为空时也返回false.
	 * 
	 * @author luck
	 * @param str
	 *            要判断的字符串 .
	 * @return true or false .
	 */
	public static boolean isNumeric(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		} else {
			return str.matches("\\d*");
		}
	}

	/**
	 * 判断输入的字符串是否符合Email样式.
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是Email样式返回true,否则返回false
	 */
	public static boolean isEmail(String str) {
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为质数
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 7) {
			if (x == 2 || x == 3 || x == 5 || x == 7)
				return true;
		}
		int c = 7;
		if (x % 2 == 0)
			return false;
		if (x % 3 == 0)
			return false;
		if (x % 5 == 0)
			return false;
		int end = (int) Math.sqrt(x);
		while (c <= end) {
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 6;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 6;
		}
		return true;
	}

	/**
	 * 判断是不是合法手机号码
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		if(StringUtils.isEmpty(mobile)){
			return false;
		}
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
		return pattern.matcher(mobile.trim()).matches();

	}

	/**
	 * 是否为座机 (010-66571346)
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		Pattern pattern = Pattern.compile("^0[0-9]{2,3}[-|－][0-9]{7,8}([-|－][0-9]{1,4})?$");
		return pattern.matcher(phone).matches();
	}

	/**
	 * 是否为邮编
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean isPostCode(String post) {
		Pattern pattern = Pattern.compile("^[0-9]{6}$");
		return pattern.matcher(post).matches();
	}

	/**
	 * 是否为日期格式：yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isDate(String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return date != null;
	}

	/**
	 * 是否为时间格式：hh:mm:ss
	 * 
	 * @param timeStr
	 * @return
	 */
	public static boolean isTime(String timeStr) {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
		Date date = null;
		try {
			date = df.parse(timeStr);
		} catch (ParseException e) {
			return false;
		}
		return date != null;
	}

	/**
	 * 是否为日期时间格式：yyyy-MM-dd hh:mm:ss or yyyy-MM-dd hh:mm
	 * 
	 * @param dateTime
	 * @return
	 */
	public static boolean isDateTime(String dateTime) {
		int first = dateTime.indexOf(":");
		int last = dateTime.lastIndexOf(":");
		if (first == -1) {
			return false;
		}
		SimpleDateFormat df = null;
		if (first == last) {
			df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		} else {
			df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		Date date = null;
		try {
			date = df.parse(dateTime);
		} catch (ParseException e) {
			return false;
		}
		return date == null;
	}

	/**
	 * 是否为url
	 * 
	 * @param url
	 * @return
	 */
	public static boolean isURL(String url) {
		Pattern pattern = Pattern.compile(
				"^(https?|ftp):\\/\\/(((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|[A-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[A-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[A-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[A-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[A-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[A-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)+(\\/(([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(\\#((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$");
		return pattern.matcher(url).matches();
	}

	/**
	 * 例如：ABC-B2C$ABC-B2C
	 * 
	 * @param frpCode
	 * @return
	 */
	public static boolean isCapitalBar(String frpCode) {
		Pattern pattern = Pattern.compile("^[A-Z]+[-－][A-Z[22]]+(\\$[A-Z]+[-－][A-Z[22]]+)*");
		return pattern.matcher(frpCode).matches();
	}

	/**
	 * 是否为合法IP地址
	 * 
	 * @param ip
	 * @return
	 */
	public static boolean isIP(String ip) {
		Pattern pattern = Pattern.compile(
				"^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$");
		return pattern.matcher(ip).matches();
	}

	/**
	 * 是否为合法MAC地址，验证十六进制格式
	 * 
	 * @param mac
	 * @return
	 */
	public static boolean isMac(String mac) {
		Pattern pattern = Pattern.compile("^([0-9a-fA-F]{2})(([\\s:-][0-9a-fA-F]{2}){5})$");
		return pattern.matcher(mac).matches();
	}

	/**
	 * 是否为合法的QQ号码.<br/>
	 * 1、QQ号的开头不能是0为开头 .<br/>
	 * 2、QQ号必须由数字构成，不包含其他字符.<br/>
	 * 3、QQ号长度为5到15位，多的算违规.
	 * 
	 * @param qq
	 *            .
	 * @return true/false .
	 */
	public static boolean isQQ(String qq) {
		Pattern pattern = Pattern.compile("^[1-9][0-9]{4,14}$");
		return pattern.matcher(qq).matches();
	}

	/**
	 * 是否为合法的银行卡号
	 * 
	 * @param bankCard
	 *            银行卡号
	 * @return
	 */
	public static boolean isBankCard(String bankCard) {
		if (!StringUtils.isBlank(bankCard)) {
			String nonCheckCodeCardId = bankCard.substring(0, bankCard.length() - 1);
			if (nonCheckCodeCardId.matches("\\d+")) {
				char[] chs = nonCheckCodeCardId.toCharArray();
				int luhmSum = 0;
				for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
					int k = chs[i] - '0';
					if (j % 2 == 0) {
						k *= 2;
						k = k / 10 + k % 10;
					}
					luhmSum += k;
				}
				char b = (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
				return bankCard.charAt(bankCard.length() - 1) == b;
			}
		}
		return false;
	}

	private static List<String> generateBankCard(int count) {
		long l = 100000000000000000l;
		List<String> list = new ArrayList<String>();
		for (int a = 1; a <= count; a++) {
			String s = String.valueOf(l + a);
			char[] chs = s.toCharArray();
			int luhmSum = 0;
			for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
				int k = chs[i] - '0';
				if (j % 2 == 0) {
					k *= 2;
					k = k / 10 + k % 10;
				}
				luhmSum += k;
			}
			char b = (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
			String bankcard = s + b;
			if (isBankCard(bankcard)) {
				list.add(s + b);
			}
		}
		return list;
	}

	/**
	 * 检查字符串长度是否小于最小长度
	 * 
	 * @param str
	 *            待检查的字符串
	 * @param minLength
	 *            最小长度
	 * @param message
	 *            异常信息
	 */
	public static void checkStrMinLength(String str, Integer minLength, String message) {
		if (str.trim().length() < minLength) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 检查字符串的字节长度是否小于最小长度
	 * 
	 * @param str
	 *            待检查的字符串
	 * @param minLength
	 *            最小长度
	 */
	public static boolean checkStrMinLengthByBytes(String str, Integer minLength) {
		int length = str.getBytes().length;
		if (length >= minLength) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查字符串的字节长度是否大于最大长度
	 * 
	 * @param str
	 *            待检查的字符串
	 * @param minLength
	 *            最小长度
	 */
	public static boolean checkStrMaxLengthByBytes(String str, Integer maxLength) {
		int length = str.getBytes().length;
		if (length <= maxLength) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查字符串是否大于最大长度
	 * 
	 * @param str
	 *            待检查的字符串
	 * @param maxLength
	 *            最大长度
	 * @param message
	 *            异常信息
	 */
	public static void checkStrMaxLength(String str, Integer maxLength, String message) {
		if (str.trim().length() > maxLength) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 验证对象是否为空
	 * 
	 * @param obj
	 *            被验证的对象
	 * @param message
	 *            异常信息
	 */
	public static void checkNotNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 验证对象是否为NULL,空字符串，空数组，空的Collection或Map(只有空格的字符串也认为是空串)
	 * 
	 * @param obj
	 *            被验证的对象
	 * @param message
	 *            异常信息
	 */
	@SuppressWarnings("rawtypes")
	public static void checkNotEmpty(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
		if (obj instanceof String && obj.toString().trim().length() == 0) {
			throw new IllegalArgumentException(message);
		}
		if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
			throw new IllegalArgumentException(message);
		}
		if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
			throw new IllegalArgumentException(message);
		}
		if (obj instanceof Map && ((Map) obj).isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 判断参数否非空
	 * 
	 * @param obj
	 * @param message
	 * @return
	 */
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	/**
	 * 判断参数是否非NULL,空字符串，空数组，空的Collection或Map(只有空格的字符串也认为是空串)
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String && obj.toString().trim().length() == 0) {
			return true;
		}
		if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
			return true;
		}
		if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
			return true;
		}
		if (obj instanceof Map && ((Map) obj).isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isIdCard(String idCard) {
		Pattern pattern = Pattern.compile("^(^\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$");
		return pattern.matcher(idCard).matches();
	}

	/**
	 * 组织机构代码
	 * 
	 * @param orgCode
	 * @return
	 */
	public static final boolean isOrgCode(String orgCode) {
		String[] codeNo = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] staVal = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33",
				"34", "35" };
		Pattern pat = Pattern.compile("^[0-9A-Z]{8}-[0-9X]$");
		Matcher matcher = pat.matcher(orgCode);
		if (!matcher.matches()) {
			return false;
		}
		Map map = new HashMap();
		for (int i = 0; i < codeNo.length; i++) {
			map.put(codeNo[i], staVal[i]);
		}
		final int[] wi = { 3, 7, 9, 10, 5, 8, 4, 2 };
		String[] all = orgCode.split("-");
		final char[] values = all[0].toCharArray();
		int parity = 0;
		for (int i = 0; i < values.length; i++) {
			final String val = Character.toString(values[i]);
			parity += wi[i] * Integer.parseInt(map.get(val).toString());
		}
		String cheak = (11 - parity % 11) == 10 ? "X" : Integer.toString((11 - parity % 11));

		return cheak.equals(all[1]);
	}

	/*********************************** 身份证验证开始 ****************************************/
	/**
	 * 身份证号码验证 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，
	 * 八位数字出生日期码，三位数字顺序码和一位数字校验码。 2、地址码(前六位数）
	 * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码（第七位至十四位）
	 * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 4、顺序码（第十五位至十七位）
	 * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。 5、校验码（第十八位数）
	 * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
	 * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4
	 * 2 （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0
	 * X 9 8 7 6 5 4 3 2
	 */

	/**
	 * 功能：身份证的有效验证
	 * 
	 * @param IDStr
	 *            身份证号
	 * @return 有效：返回"" 无效：返回String信息
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public static String IDCardValidate(String IDStr) throws ParseException {
		String errorInfo = "";// 记录错误信息
		String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2" };
		String Ai = "";
		// ================ 号码的长度 15位或18位 ================
		if (IDStr.length() != 15 && IDStr.length() != 18) {
			errorInfo = "身份证号码长度应该为15位或18位。";
			return errorInfo;
		}
		// =======================(end)========================

		// ================ 数字 除最后以为都为数字 ================
		if (IDStr.length() == 18) {
			Ai = IDStr.substring(0, 17);
		} else if (IDStr.length() == 15) {
			Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
		}
		if (isNumeric(Ai) == false) {
			errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
			return errorInfo;
		}
		// =======================(end)========================

		// ================ 出生年月是否有效 ================
		String strYear = Ai.substring(6, 10);// 年份
		String strMonth = Ai.substring(10, 12);// 月份
		String strDay = Ai.substring(12, 14);// 月份
		if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
			errorInfo = "身份证生日无效。";
			return errorInfo;
		}
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
					|| (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
				errorInfo = "身份证生日不在有效范围。";
				return errorInfo;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
			errorInfo = "身份证月份无效";
			return errorInfo;
		}
		if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
			errorInfo = "身份证日期无效";
			return errorInfo;
		}
		// =====================(end)=====================

		// ================ 地区码时候有效 ================
		Hashtable h = GetAreaCode();
		if (h.get(Ai.substring(0, 2)) == null) {
			errorInfo = "身份证地区编码错误。";
			return errorInfo;
		}
		// ==============================================

		// ================ 判断最后一位的值 ================
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String strVerifyCode = ValCodeArr[modValue];
		Ai = Ai + strVerifyCode;

		if (IDStr.length() == 18) {
			if (Ai.equals(IDStr) == false) {
				errorInfo = "身份证无效，不是合法的身份证号码";
				return errorInfo;
			}
		} else {
			return "";
		}
		// =====================(end)=====================
		return "";
	}

	/**
	 * 功能：设置地区编码
	 * 
	 * @return Hashtable 对象
	 */
	@SuppressWarnings("unchecked")
	private static Hashtable GetAreaCode() {
		Hashtable hashtable = new Hashtable();
		hashtable.put("11", "北京");
		hashtable.put("12", "天津");
		hashtable.put("13", "河北");
		hashtable.put("14", "山西");
		hashtable.put("15", "内蒙古");
		hashtable.put("21", "辽宁");
		hashtable.put("22", "吉林");
		hashtable.put("23", "黑龙江");
		hashtable.put("31", "上海");
		hashtable.put("32", "江苏");
		hashtable.put("33", "浙江");
		hashtable.put("34", "安徽");
		hashtable.put("35", "福建");
		hashtable.put("36", "江西");
		hashtable.put("37", "山东");
		hashtable.put("41", "河南");
		hashtable.put("42", "湖北");
		hashtable.put("43", "湖南");
		hashtable.put("44", "广东");
		hashtable.put("45", "广西");
		hashtable.put("46", "海南");
		hashtable.put("50", "重庆");
		hashtable.put("51", "四川");
		hashtable.put("52", "贵州");
		hashtable.put("53", "云南");
		hashtable.put("54", "西藏");
		hashtable.put("61", "陕西");
		hashtable.put("62", "甘肃");
		hashtable.put("63", "青海");
		hashtable.put("64", "宁夏");
		hashtable.put("65", "新疆");
		hashtable.put("71", "台湾");
		hashtable.put("81", "香港");
		hashtable.put("82", "澳门");
		hashtable.put("91", "国外");
		return hashtable;
	}

	/**
	 * 功能：判断字符串是否为日期格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIDCardDate(String strDate) {
		Pattern pattern = Pattern.compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws ParseException {
		// String IDCardNum="210102820826411";
		// String IDCardNum="210102198208264114";
		String IDCardNum = "522501197502012455";
		ValidateUtils cc = new ValidateUtils();
		System.out.println(cc.IDCardValidate(IDCardNum));
		// System.out.println(cc.isDate("1996-02-29"));
	}
	/*********************************** 身份证验证结束 ****************************************/

}
