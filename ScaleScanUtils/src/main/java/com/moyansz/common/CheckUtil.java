package com.moyansz.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检验 校验 工具类
 */
public class CheckUtil {

	/**
	 * 获取一个字符串中中文的数量
	 * 
	 * @param str
	 * @return
	 */
	public static int getChineseNumber(String str) {
		Pattern pattern = Pattern.compile("[\u4E00-\u9FA5]");
		Matcher matcher = pattern.matcher(str);
		int number = 0;
		while (matcher.find()) {
			number++;
		}

		return number;
	}

	/**
	 * @function:校验惠信号
	 * @param nickname
	 * @return boolean
	 * @exception @author:duyubo
	 * @since 1.0.0
	 */
	public static boolean checkAccName(String accName) {
		if (accName != null && !accName.trim().equals("")) {
			int chineseNumber = CheckUtil.getChineseNumber(accName);
			if (chineseNumber > 0) {
				return false;
			}
			Pattern pattern = Pattern
					.compile("[\u4E00-\u9FA5a-zA-Z][\u4E00-\u9FA5a-zA-Z0-9_]{5," + (20 - chineseNumber) + "}");
			Matcher matcher = pattern.matcher(accName);
			return matcher.matches();
		}
		return false;
	}

	/**
	 * @function:校验邮箱
	 * @param email
	 * @return boolean
	 * @exception @author:duyubo
	 * @since 1.0.0
	 */
	public static boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile(
				"^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches() && email.length() < 41;
	}

	/**
	 * @function:校验球球号码
	 * @param qq
	 * @return boolean
	 * @exception @author:duyubo
	 * @since 1.0.0
	 */
	public static boolean checkQQ(String qq) {
		Pattern pattern = Pattern.compile("^[1-9]\\d{4,10}$");
		Matcher matcher = pattern.matcher(qq);
		return matcher.matches();
	}

	public static boolean checkPostCode(String postCode) {
		Pattern pattern = Pattern.compile("^\\d{6}");
		Matcher matcher = pattern.matcher(postCode);
		return matcher.matches();
	}

	/**
	 * @function:校验固话
	 * @param phone
	 * @return boolean
	 * @exception @author:duyubo
	 * @since 1.0.0
	 */
	public static boolean checkPhone(String phone) {
		Pattern pattern = Pattern.compile("^(0\\d{2,3}-)(\\d{7,8})(-(\\d{1,8}))?$");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	/**
	 * @function:校验手机
	 * @param telephone
	 * @return boolean
	 * @exception @author:duyubo
	 * @since 1.0.0
	 */
	public static boolean checkMobilePhone(String telephone) {
		// Pattern pattern =
		// Pattern.compile("^0?(13[0-9]|15[012356789]|17[012356789]|18[0123456789]|14[57])[0-9]{8}$");
		Pattern pattern = Pattern.compile("^0?(1[3456789])[0-9]{9}$");
		Matcher matcher = pattern.matcher(telephone);
		return matcher.matches();
	}

	/**
	 * 校验真实姓名
	 * 
	 * @author duyubo 2015年下午8:25:30
	 * @param realName
	 * @return
	 */
	public static boolean checkRealName(String realName) {
		Pattern rnReg = Pattern.compile("^([\u4E00-\u9FA5]{2,6}(?:·[\u4E00-\u9FA5]{2,6})*)+$"); // 中文,兼容少数名族名字
		// Pattern rnReg = Pattern.compile("^([a-zA-Z
		// ]{2,20}|([\u4E00-\u9FA5]{2,6}(?:·[\u4E00-\u9FA5]{2,6})*))$"); //中文
		// 英文名(兼容空格),兼容少数名族名字
		Matcher rnMatcher = rnReg.matcher(realName);
		return rnMatcher.matches();
	}

	/**
	 * @function:校验身份证
	 * @param IDNumber
	 * @return boolean
	 * @exception @author:duyubo
	 * @since 1.0.0
	 */
	public static boolean checkCardNo(String IDNumber) {
		// boolean result=IDNumber.matches("[0-9]{15}|[0-9]{17}[0-9X]");
		boolean result = IDNumber.matches("[a-zA-Z0-9]{6,18}");
		// if(result){
		// int year,month,date;
		// if(IDNumber.length()==15){
		// year=Integer.parseInt(IDNumber.substring(6,8));
		// month=Integer.parseInt(IDNumber.substring(8,10));
		// date=Integer.parseInt(IDNumber.substring(10,12));
		// }else{
		// year=Integer.parseInt(IDNumber.substring(6,10));
		// month=Integer.parseInt(IDNumber.substring(10,12));
		// date=Integer.parseInt(IDNumber.substring(12,14));
		// }
		// switch(month){
		// case 2:result=(date>=1)&&(year%4==0?date<=29:date<=28);break;
		// case 1:
		// case 3:
		// case 5:
		// case 7:
		// case 8:
		// case 10:
		// case 12:result=(date>=1)&&(date<=31);break;
		// case 4:
		// case 6:
		// case 9:
		// case 11:result=(date>=1)&&(date<=31);break;
		// default:result=false;break;
		// }
		// }
		return result;
	}

	// 是否为数字
	public static boolean checkDigital(String Digital) {
		Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
		Matcher matcher = pattern.matcher(Digital);
		return matcher.matches();
	}

	// 只能输入两位小数
	// 是否为数字
	public static boolean towDecimal(String decimal) {
		Pattern pattern = Pattern.compile("(^(\\d+)(\\.(\\d){1,2})*$)");
		Matcher matcher = pattern.matcher(decimal);
		return matcher.matches();
	}

	// 判断字符串中是否包含空格
	public static boolean isContainBlank(String str) {
		boolean containBlank = false;
		if (!StringUtils.isEmpty(str)) {
			if (str.contains(" ")) {
				containBlank = true;
			}
		}
		return containBlank;
	}

	/**
	 * 手机号验证
	 * 
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**
	 * 校验所有字符串参数中是否有为空的
	 * 
	 * @time 2015年下午5:38:09
	 * @author duyubo
	 * @param strs
	 *            待校验字符串
	 * @return
	 */
	public static Boolean isEmptys(String... strs) {
		for (String parm : strs) {
			if (org.apache.commons.lang.StringUtils.isBlank(parm)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @function: 验证金额
	 * @param str
	 * @return boolean
	 * @exception @author:邱先锋
	 * @since 1.0.0
	 */
	public static boolean isAmount(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后一位的数字的正则表达式
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}
}
