package com.moyansz.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.moyansz.common.DateUtil;


/**
 * 
 * @description: 字符串工具类
 * @fileName:StringUtils.java
 * @createTime:2015年3月18日 下午2:26:09
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class StringUtils {

	/**
	 * �?��字符串是否为空白 empty ("") or null 建议使用
	 * org.apache.commons.lang3.StringUtils.isBlank()
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().equals("");
	}

	/**
	 * 
	 * @function:去掉�?��空格
	 * @param str
	 * @return String
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static String trimAllEmpty(String str) {
		return str == null ? str : str.replaceAll(" +", "");
	}

	/**
	 * @function: 生成18位流水号，格式如�?0141215223209678776
	 * @return String
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static String getBusinessNum() {
		Date date = new Date();
		String sn = DateUtil.dateToString(date, "yyyyMMdd");
		String cur = DateUtil.dateToString(date, "yyyyMMddHHmmss");
		String sn_business_num1 = System.getProperty("sn_business_num");
		if (sn_business_num1 == null || "".equals(sn_business_num1)) {
			System.setProperty("sn_business_num", sn);// 设置已标识时间串
			System.setProperty("business_num_key", "1");// 设置自增长标识，�?�?��
			return cur + "0001";
		} else {
			int startNum = 1;// 尾部流水�?�?��
			String sn_business_num = sn;// 当天标识
			String key = "";
			if (sn_business_num.equals(System.getProperty("sn_business_num"))) {
				key = System.getProperty("business_num_key");
				if (key != null && !"".equals(key)) {
					startNum = Integer.parseInt(key);
					startNum++;
				}
			}

			String endNum = "" + startNum;
			if (endNum.length() == 1)// 自动标识长度�?
			{
				key = "000" + startNum;
			} else if (endNum.length() == 2)// 自动标识长度�?
			{
				key = "00" + startNum;
			} else if (endNum.length() == 3)// 自动标识长度�?
			{
				key = "0" + startNum;
			}
			System.setProperty("sn_business_num", sn);
			System.setProperty("business_num_key", "" + startNum);
			return cur + key;
		}
	}

	/**
	 * @function: 随机8位数字邀请码
	 * @return int
	 * @exception @author:Wuwenyong
	 * @since 1.0.0
	 */
	public static int inviteCode() {
		int code = 0;
		int number = 100000000;
		while (true) {
			code = (int) (Math.random() * number);
			if (String.valueOf(code).length() == 8 && code > 10000000 && code < 99999999) {
				break;
			}
		}
		return code;
	}

	/**
	 * 
	 * @function: 将空字符串转为null
	 * @param str
	 *            空字符串
	 * @return
	 * @return type Object
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static Object covertEmptyStringToNull(String str) {
		if (str != null && "".equals(str.trim())) {
			return null;
		} else {
			return str;
		}
	}

	/**
	 * 
	 * @function: 将null转为空字符串
	 * @param str
	 * @return
	 * @return type Object
	 * @exception @author:肖震
	 * @since 1.0.0
	 */
	public static String covertNullToEmptyString(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	public static Object covertNullObjectToEmptyString(Object str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	// 金额保存两位小数，并且不四舍五入
	public static BigDecimal moneyToKeepDecimals(Object object, int len) {
		String newMoney = "0.00";
		if (null != object) {
			String money = object.toString();
			if (money.contains(".")) {
				String[] strArray = money.split("\\.");
				if (1 == strArray[1].length()) {
					newMoney = money + "0";
				} else if (2 == strArray[1].length()) {
					newMoney = money;
				} else {
					newMoney = strArray[0] + "." + strArray[1].substring(0, len);
				}
			} else {
				newMoney = money + ".00";
			}
		}
		return new BigDecimal(newMoney);
	}

	public static String formatNumber(Double num) {
		try {
			return new DecimalFormat("##.##").format(num);
		} catch (Exception e) {
			return null;
		}
	}

	public static String formatTime(Date date) {
		if (date != null)
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return null;
	}

	public static String formatTime(String format, Date date) {
		if (date != null)
			return new SimpleDateFormat(format).format(date);
		return null;
	}

	/**
	 * 
	 * @function: 生成 interestIntoParmStr 参数收益转入接口参数
	 * @param param
	 * @return String
	 * @exception @author:叶威龙
	 * @since 1.0.0
	 */
	public static String buildInterestIntoParmStr(Map<String, Map<String, String>> param) {
		Set<String> keys = param.keySet();
		StringBuffer res = new StringBuffer();
		for (String k : keys) {
			Map<String, String> map = param.get(k);
			res.append(map.get("uid") + ",");
			res.append(map.get("hxAccName") + ",");
			res.append(map.get("loginPwd") + ",");
			res.append(map.get("amount") + ",");
			res.append(map.get("orderNo") + ",");
			res.append(map.get("datetime") + ",");
			res.append(map.get("remarkInfo") + ";");
		}
		return res.toString().substring(0, res.length() - 1);
	}

	public static String buildmoneyBatchIntoParmStr(Map<String, Map<String, String>> param) {
		Set<String> keys = param.keySet();
		StringBuffer res = new StringBuffer();
		for (String k : keys) {
			Map<String, String> map = param.get(k);
			res.append(map.get("orderNo") + ",");
			res.append(map.get("uid") + ",");
			res.append(map.get("hxAccName") + ",");
			res.append(map.get("loginPwd") + ",");
			res.append(map.get("amount") + ",");
			res.append(map.get("remarkInfo") + ",");
			res.append(map.get("tradeType") + ",");
			res.append(map.get("fee") + ",");
			res.append(map.get("feeRemark") + ",");
			res.append(map.get("feeType") + ";");
		}
		return res.toString().substring(0, res.length() - 1);
	}

	/**
	 * 
	 * @function: 把Double格式化保留两位小数，但不四舍五入
	 * @param d
	 * @return String
	 * @exception @author:Zhanglinxing
	 * @since 1.0.0
	 */
	public static String formatDouble(Double d) {
		if (d != null) {
			DecimalFormat formater = new DecimalFormat();
			formater.setMaximumFractionDigits(2);
			formater.setGroupingSize(0);
			formater.setRoundingMode(RoundingMode.FLOOR);
			return formater.format(d);
		} else {
			return null;
		}
	}

	/**
	 * 过滤HTML标签
	 * 
	 * @function:
	 * @param str
	 * @return String
	 * @exception @author:李辞辞
	 * @since 1.0.0
	 */
	public static String toHTMLStr(String str) {
		String value = "";
		if (str == null)
			return null;
		value = str.replaceAll("&", "&amp;");
		value = value.replaceAll(">", "&gt;");
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll("\"", "&quot;");
		return value;
	}

	/**
	 * 把数字精确到小数点后两位，并且以千元分隔符分隔
	 * 
	 * @function:
	 * @param str
	 * @return String
	 * @exception @author:李辞辞
	 * @since 1.0.0
	 */
	public static String strToThousandSign(String str) {
		String newStr = "";
		DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
		try {
			double d = Double.parseDouble(str);
			newStr = df.format(d);
		} catch (IllegalArgumentException e) {
			newStr = null;
		}
		return newStr;
	}

	/**
	 * 删除指定内容的字符串方法
	 * 
	 * @function:
	 * @param 文本
	 * @param 需要去除的内容([^0-9])
	 * @return String
	 * @exception @author:qiuhai
	 * @since 1.0.0
	 */
	public static String removeString(String str, String param) {

		Pattern pattern = Pattern.compile(param);
		Matcher matcher = pattern.matcher(str);
		String result = matcher.replaceAll("");
		return result;
	}

	/**
	 * 根据特点字符来分割字符串 str： 要分割的字符串 type：分隔符 t：每隔t数量来分割字符串str 如str： 1324545334
	 * stype：， t：3 结果为：1,324,545,334
	 * 
	 * @exception @author:Zhanglinxing
	 * @since 1.0.0
	 */
	public static String getStringByType(String str, String type, int t) {
		String result = ""; // 要返回的字符串结果
		if (str.length() <= t) {
			return str;
		} else {
			str = new StringBuilder(str).reverse().toString(); // 先将字符串颠倒顺序
			for (int i = 0; i < str.length(); i++) {
				if (i * t + t > str.length()) {
					result += str.substring(i * t, str.length());
					break;
				}
				result += str.substring(i * t, i * t + t) + type;
			}
			if (result.endsWith(type)) {
				result = result.substring(0, result.length() - 1);
			}
		}
		return new StringBuilder(result).reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(toHTMLStr("<script>alert(1);</script>"));
		System.out.println(strToThousandSign("456789.12322"));
	}
}
