
package com.moyansz.common;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.lang.ArrayUtils;

/**
 * 
 * @描述: 转换处理类
 * @作者: luck
 * @时间: 2016年8月10日
 * @版本: 1.0 .
 */
public class CastUtil {
	public static String castString(Object obj) {
		return castString(obj, "");
	}

	public static String castString(Object obj, String defaultValue) {
		if (obj != null) {
			if (obj.getClass().getName().equals("java.lang.Double")) {
				DecimalFormat format = new DecimalFormat("#.00");
				format.setRoundingMode(RoundingMode.FLOOR);
				return format.format(obj);
			}
			return String.valueOf(obj);
		}

		return defaultValue;
	}

	public static double castDouble(Object obj) {
		return castDouble(obj, 0.0D);
	}

	public static double castDouble(Object obj, double defaultValue) {
		double doubleValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtils.isNotEmpty(strValue)) {
				try {
					strValue = strValue.replaceAll(",", "");
					doubleValue = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}

	public static long castLong(Object obj) {
		return castLong(obj, 0L);
	}

	public static long castLong(Object obj, long defaultValue) {
		long longValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtils.isNotEmpty(strValue)) {
				try {
					longValue = Long.parseLong(strValue);
				} catch (NumberFormatException e) {
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}

	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}

	public static int castInt(Object obj, int defaultValue) {
		int intValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtils.isNotEmpty(strValue)) {
				try {
					intValue = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
	
	
	public static float castFloat(Object obj) {
		return castFloat(obj, 0);
	}

	public static float castFloat(Object obj, int defaultValue) {
		float floatValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtils.isNotEmpty(strValue)) {
				try {
					floatValue = Float.parseFloat(strValue);
				} catch (NumberFormatException e) {
					floatValue = defaultValue;
				}
			}
		}
		return floatValue;
	}

	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}

	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (obj != null) {
			booleanValue = Boolean.parseBoolean(castString(obj));
		}
		return booleanValue;
	}

	public static String[] castStringArray(Object[] objArray) {
		if (objArray == null) {
			objArray = new Object[0];
		}
		String[] strArray = new String[objArray.length];
		if (ArrayUtils.isNotEmpty(objArray)) {
			for (int i = 0; i < objArray.length; ++i) {
				strArray[i] = castString(objArray[i]);
			}
		}
		return strArray;
	}

	public static double[] castDoubleArray(Object[] objArray) {
		if (objArray == null) {
			objArray = new Object[0];
		}
		double[] doubleArray = new double[objArray.length];
		if (!(ArrayUtils.isEmpty(objArray))) {
			for (int i = 0; i < objArray.length; ++i) {
				doubleArray[i] = castDouble(objArray[i]);
			}
		}
		return doubleArray;
	}

	public static long[] castLongArray(Object[] objArray) {
		if (objArray == null) {
			objArray = new Object[0];
		}
		long[] longArray = new long[objArray.length];
		if (!(ArrayUtils.isEmpty(objArray))) {
			for (int i = 0; i < objArray.length; ++i) {
				longArray[i] = castLong(objArray[i]);
			}
		}
		return longArray;
	}

	public static int[] castIntArray(Object[] objArray) {
		if (objArray == null) {
			objArray = new Object[0];
		}
		int[] intArray = new int[objArray.length];
		if (!(ArrayUtils.isEmpty(objArray))) {
			for (int i = 0; i < objArray.length; ++i) {
				intArray[i] = castInt(objArray[i]);
			}
		}
		return intArray;
	}

	public static boolean[] castBooleanArray(Object[] objArray) {
		if (objArray == null) {
			objArray = new Object[0];
		}
		boolean[] booleanArray = new boolean[objArray.length];
		if (!(ArrayUtils.isEmpty(objArray))) {
			for (int i = 0; i < objArray.length; ++i) {
				booleanArray[i] = castBoolean(objArray[i]);
			}
		}
		return booleanArray;
	}
}
