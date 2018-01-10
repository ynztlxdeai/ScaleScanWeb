/**
 * @Title: NumberUtil.java
 * @Package com.hx.hxb.common.util
 * @Description:  Copyright: Copyright (c) 2015 Company:深圳惠信世纪有限公司
 * @author:徐亮
 * @email:569537216@qq.com
 * @date 2015年6月9日 下午3:48:16
 * @version V1.0
 */
package com.moyansz.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @ClassName: NumberUtil
 * @Description: 数字工具类
 * @author Comsys-徐亮
 * @date 2015年6月9日 下午3:48:16
 */
public class NumberUtil {

	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是浮点数
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是数字
	 */
	public static boolean isNumber(String value) {
		return isInteger(value) || isDouble(value);
	}

	/**
	 * 返回百分比
	 * 
	 * @function:
	 * @param son
	 * @param father
	 * @return String
	 * @exception @author:张朋飞
	 * @since 1.0.0
	 */
	public static String numberPercentToStr(double son, double father) {
		if (0 == father) {
			return "0%";
		}
		BigDecimal a = new BigDecimal(son);
		BigDecimal b = new BigDecimal(father);// b不能为0
		BigDecimal relt = a.divide(b, 4, RoundingMode.HALF_UP);

		NumberFormat num = NumberFormat.getPercentInstance();
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);

		return num.format(relt);
	}
	
	/**
	 * 获取金额保留两位小数
	 * @param price
	 * @return
	 */
	public static double priceFormat(double price){
		if (0 >= price) {
			return 0;
		}
		 NumberFormat f=NumberFormat.getInstance();
		 f.setMaximumFractionDigits(2);
		 return Double.parseDouble(f.format(price));
		
	} 
}
