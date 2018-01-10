package com.moyansz.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 产品级的日期工具类
 * 
 * @author lilong
 * 
 */
public class DateUtil2 {

    public static String getCurrentDateTime() {
	SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_TIME_FORMAT.DATA_TIME_PATTERN);
	return sdf.format(new Date());
    }

    // 默认显示日期的格式
    public static final String DATAFORMAT_STR = "yyyy-MM-dd";

    // 默认显示日期的格式
    public static final String YYYY_MM_DATAFORMAT_STR = "yyyy-MM";

    // 默认显示日期时间的格式
    public static final String DATATIMEF_STR = "yyyy-MM-dd HH:mm:ss";

    // 默认显示简体中文日期的格式
    public static final String ZHCN_DATAFORMAT_STR = "yyyy年MM月dd日";

    // 默认显示简体中文日期时间的格式
    public static final String ZHCN_DATATIMEF_STR = "yyyy年MM月dd日HH时mm分ss秒";

    // 默认显示简体中文日期时间的格式
    public static final String ZHCN_DATATIMEF_STR_4yMMddHHmm = "yyyy年MM月dd日HH时mm分";

    /**
     * 精确到毫秒级
     */
    public static final String DATATIMEV_STR = "yyyyMMddHHmmssSSS";
    /**
     * 精确到秒级
     */
    public static final String DATATIMEV_STR_S = "yyyyMMddHHmmss";

    public static final String LOCAL_FORMAT2 = "yyyy-MM-dd HH:mm:ss.SSS";

    // 年月日连接=符
    public static final String CON = "-";

    // yyyy-MM-dd
    private static DateFormat dateFormat = null;

    // yyyy-MM-dd HH:mm:ss
    private static DateFormat dateTimeFormat = null;

    // yyyy年MM月dd日
    private static DateFormat zhcnDateFormat = null;

    // yyyy年MM月dd日HH时mm分ss秒
    private static DateFormat zhcnDateTimeFormat = null;

    static {
	dateFormat = new SimpleDateFormat(DATAFORMAT_STR);
	dateTimeFormat = new SimpleDateFormat(DATATIMEF_STR);
	zhcnDateFormat = new SimpleDateFormat(ZHCN_DATAFORMAT_STR);
	zhcnDateTimeFormat = new SimpleDateFormat(ZHCN_DATATIMEF_STR);
    }

    /**
     * 
     * 获得日期转换类型
     * 
     * @param formatStr
     * @return
     */
    private static DateFormat getDateFormat(String formatStr) {
	if (DATAFORMAT_STR.equalsIgnoreCase(formatStr)) {
	    return dateFormat;
	}

	else if (DATATIMEF_STR.equalsIgnoreCase(formatStr)) {
	    return dateTimeFormat;
	}

	if (ZHCN_DATAFORMAT_STR.equalsIgnoreCase(formatStr)) {
	    return zhcnDateFormat;
	}

	if (ZHCN_DATATIMEF_STR.equalsIgnoreCase(formatStr)) {
	    return zhcnDateTimeFormat;
	} else {
	    return new SimpleDateFormat(formatStr);
	}
    }

    /**
     * 按照默认显示日期时间的格式"yyyy-MM-dd HH:mm:ss"，转化dateTimeStr为Date类型 dateTimeStr必须是
     * "yyyy-MM-dd HH:mm:ss"的形式
     * 
     * @param dateTimeStr
     * @return
     */
    public static Date getDate(String dateTimeStr) {
	return getDate(dateTimeStr, DATATIMEF_STR);
    }

    /**
     * 按照默认formatStr的格式，转化dateTimeStr为Date类型 dateTimeStr必须是formatStr的形式
     * 
     * @param dateTimeStr
     * @param formatStr
     * @return
     */
    public static Date getDate(String dateTimeStr, String formatStr) {
	try {
	    if (Utils.isStringNull(formatStr)) {
		return null;
	    }
	    DateFormat sdf = getDateFormat(formatStr);
	    Date d = sdf.parse(dateTimeStr);
	    return d;
	} catch (ParseException e) {
	    throw new RuntimeException(e);
	}
    }

    /**
     * 将YYYYMMDD转换成Date日期
     * 
     * @param date
     * @return
     * @throws BusinessException
     */
    public static Date transferDate(String date) throws Exception {
	if (Utils.isStringNull(date))
	    return null;

	if (date.length() != 8)
	    throw new Exception("日期格式错误");

	String yyyy = date.substring(0, 4);
	String mm = date.substring(4, 6);
	String dd = date.substring(6, 8);

	int month = Integer.parseInt(mm);
	int day = Integer.parseInt(dd);
	if (month < 1 || month > 12 || day < 1 || day > 31)
	    throw new Exception("日期格式错误");

	String str = yyyy + CON + mm + CON + dd;
	return getDate(str, DATAFORMAT_STR);
    }

    /**
     * 将YYYY－MM－DD日期转换成yyyymmdd格式字符串
     * 
     * @param date
     * @return
     */
    public static String getYYYYMMDDDate(Date date) {
	if (date == null)
	    return null;
	String yyyy = String.valueOf(getYear(date));
	String mm = String.valueOf(getMonth(date));
	String dd = String.valueOf(getDay(date));

	mm = Utils.rightAlign(mm, 2, "0");
	dd = Utils.rightAlign(dd, 2, "0");
	return yyyy + mm + dd;
    }

    public static void main(String[] args) {
	DateUtil2.getDate("20100815180000", DateUtil2.DATATIMEV_STR_S);
	System.out.println(getYear(new Date()));
	System.out.println(getMonth(new Date()));
	System.out.println(getDay(new Date()));
	System.out.println(getYYYYMMDDDate(new Date()));
	System.out.println(getYYYYMMDDHHMMSSDate(new Date()));
	System.err.println(getYYYYMMDDHHMMSSSSSDate(new Date()));

    }

    public static String getYYYYMMDDHHMMSSSSSDate(Date date) {
	if (date == null) {
	    return null;
	}

	return new SimpleDateFormat(DATATIMEV_STR).format(date);
    }

    /**
     * 将YYYY－MM－DD日期转换成YYYYMMDDHHMMSS格式字符串
     * 
     * @param date
     * @return
     */
    public static String getYYYYMMDDHHMMSSDate(Date date) {
	if (date == null) {
	    return null;
	}
	String yyyy = String.valueOf(getYear(date));
	String mm = String.valueOf(getMonth(date));
	String dd = String.valueOf(getDay(date));
	String hh = String.valueOf(getHour(date));
	String min = String.valueOf(getMin(date));
	String ss = String.valueOf(getSecond(date));

	mm = Utils.rightAlign(mm, 2, "0");
	dd = Utils.rightAlign(dd, 2, "0");
	hh = Utils.rightAlign(hh, 2, "0");
	min = Utils.rightAlign(min, 2, "0");
	ss = Utils.rightAlign(ss, 2, "0");

	return yyyy + mm + dd + hh + min + ss;
    }

    /**
     * 将YYYY－MM－DD日期转换成YYYYMMDDHHMMSS格式字符串
     * 
     * @param date
     * @return
     */
    public static String getYYYY_MM_DD_HH_MM_SSDate(Date date) {
	if (date == null) {
	    return null;
	}
	String yyyy = String.valueOf(getYear(date));
	String mm = String.valueOf(getMonth(date));
	String dd = String.valueOf(getDay(date));
	String hh = String.valueOf(getHour(date));
	String min = String.valueOf(getMin(date));
	String ss = String.valueOf(getSecond(date));

	mm = Utils.rightAlign(mm, 2, "0");
	dd = Utils.rightAlign(dd, 2, "0");
	hh = Utils.rightAlign(hh, 2, "0");
	min = Utils.rightAlign(min, 2, "0");
	ss = Utils.rightAlign(ss, 2, "0");

	return yyyy + "-" + mm + "-" + dd + " " + hh + ":" + min + ":" + ss;
    }

    /**
     * 将YYYY－MM－DD日期转换成yyyymmdd格式字符串
     * 
     * @param date
     * @return
     */
    public static String getYYYYMMDDDate(String date) {
	return getYYYYMMDDDate(getDate(date, DATAFORMAT_STR));
    }

    /**
     * 将Date转换成字符串“yyyy-mm-dd hh:mm:ss”的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToDateString(Date date) {
	return dateToDateString(date, DATATIMEF_STR);
    }

    /**
     * 将Date转换成formatStr格式的字符串
     * 
     * @param date
     * @param formatStr
     * @return
     */
    public static String dateToDateString(Date date, String formatStr) {
	DateFormat df = getDateFormat(formatStr);
	return df.format(date);
    }

    /**
     * 返回一个yyyy-MM-dd HH:mm:ss 形式的日期时间字符串中的HH:mm:ss
     * 
     * @param dateTime
     * @return
     */
    public static String getTimeString(String dateTime) {
	return getTimeString(dateTime, DATATIMEF_STR);
    }

    /**
     * 返回一个formatStr格式的日期时间字符串中的HH:mm:ss
     * 
     * @param dateTime
     * @param formatStr
     * @return
     */
    public static String getTimeString(String dateTime, String formatStr) {
	Date d = getDate(dateTime, formatStr);
	String s = dateToDateString(d);
	return s.substring(DATATIMEF_STR.indexOf('H'));
    }

    /**
     * 获取当前日期yyyy-MM-dd的形式
     * 
     * @return
     */
    public static String getCurDate() {
	// return dateToDateString(new Date(),DATAFORMAT_STR);
	return dateToDateString(Calendar.getInstance().getTime(), DATAFORMAT_STR);
    }

    /**
     * 获取当前日期yyyy年MM月dd日的形式
     * 
     * @return
     */
    public static String getCurZhCNDate() {
	return dateToDateString(new Date(), ZHCN_DATAFORMAT_STR);
    }

    /**
     * 获取当前日期时间yyyy-MM-dd HH:mm:ss的形式
     * 
     * @return
     */
    public static String getCurDateTime() {
	return dateToDateString(new Date(), DATATIMEF_STR);
    }

    /**
     * 获取当前日期时间yyyy年MM月dd日HH时mm分ss秒的形式
     * 
     * @return
     */
    public static String getCurZhCNDateTime() {
	return dateToDateString(new Date(), ZHCN_DATATIMEF_STR);
    }

    /**
     * 获取日期d的days天后的一个Date
     * 
     * @param d
     * @param days
     * @return
     */
    public static Date getInternalDateByDay(Date d, int days) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	now.add(Calendar.DATE, days);
	return now.getTime();
    }

    /**
     * 获取日期d的months月后的一个date
     * 
     * @param d
     * @param months
     * @return
     */
    public static Date getInternalDateByMon(Date d, int months) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	now.add(Calendar.MONTH, months);
	return now.getTime();
    }

    /**
     * 获取日期d的years年后的一个date
     * 
     * @param d
     * @param years
     * @return
     */
    public static Date getInternalDateByYear(Date d, int years) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	now.add(Calendar.YEAR, years);
	return now.getTime();
    }

    /**
     * 获取日期d的sec秒后的日期
     * 
     * @param d
     * @param sec
     * @return
     */
    public static Date getInternalDateBySec(Date d, int sec) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	now.add(Calendar.SECOND, sec);
	return now.getTime();
    }

    /**
     * 获取日期d的min分后的日期
     * 
     * @param d
     * @param min
     * @return
     */
    public static Date getInternalDateByMin(Date d, int min) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	now.add(Calendar.MINUTE, min);
	return now.getTime();
    }

    /**
     * 获取日期d的过hours后的日期
     * 
     * @param d
     * @param hours
     * @return
     */
    public static Date getInternalDateByHour(Date d, int hours) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	now.add(Calendar.HOUR_OF_DAY, hours);
	return now.getTime();
    }

    /**
     * 根据一个日期字符串，返回日期格式，目前支持4种 如果都不是，则返回null
     * 
     * @param DateString
     * @return
     */
    public static String getFormateStr(String DateString) {
	String patternStr1 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}"; // "yyyy-MM-dd"
	String patternStr2 = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}\\s[0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}";
	// "yyyy-MM-dd HH:mm:ss";
	String patternStr3 = "[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日";// "yyyy年MM月dd日"
	String patternStr4 = "[0-9]{4}年[0-9]{1,2}月[0-9]{1,2}日[0-9]{1,2}时[0-9]{1,2}分[0-9]{1,2}秒";// "yyyy年MM月dd日HH时mm分ss秒"

	Pattern p = Pattern.compile(patternStr1);
	Matcher m = p.matcher(DateString);
	boolean b = m.matches();
	if (b) {
	    return DATAFORMAT_STR;
	}
	p = Pattern.compile(patternStr2);
	m = p.matcher(DateString);
	b = m.matches();
	if (b) {
	    return DATATIMEF_STR;
	}
	p = Pattern.compile(patternStr3);
	m = p.matcher(DateString);
	b = m.matches();
	if (b) {
	    return ZHCN_DATAFORMAT_STR;
	}
	p = Pattern.compile(patternStr4);
	m = p.matcher(DateString);
	b = m.matches();
	if (b) {
	    return ZHCN_DATATIMEF_STR;
	}
	return null;
    }

    /**
     * 将一个"yyyy-MM-dd HH:mm:ss"字符串，转换成"yyyy年MM月dd日HH时mm分ss秒"的字符串
     * 
     * @param dateStr
     * @return
     */
    public static String getZhCNDateTime(String dateStr) {
	Date d = getDate(dateStr);
	return dateToDateString(d, ZHCN_DATATIMEF_STR);
    }

    /**
     * 将一个"yyyy-MM-dd"字符串，转换成"yyyy年MM月dd日"的字符串
     * 
     * @param dateStr
     * @return
     */
    public static String getZhCNDate(String dateStr) {
	Date d = getDate(dateStr, DATAFORMAT_STR);
	return dateToDateString(d, ZHCN_DATAFORMAT_STR);
    }

    /**
     * 将dateStr从fmtFrom转换到fmtTo的格式
     * 
     * @param dateStr
     * @param fmtFrom
     * @param fmtTo
     * @return
     */
    public static String getDateStr(String dateStr, String fmtFrom, String fmtTo) {
	Date d = getDate(dateStr, fmtFrom);
	return dateToDateString(d, fmtTo);
    }

    /**
     * 比较两个"yyyy-MM-dd HH:mm:ss"格式的日期，之间相差多少毫秒,time2-time1
     * 
     * @param time1
     * @param time2
     * @return
     */
    public static long compareDateStr(String time1, String time2) {
	Date d1 = getDate(time1);
	Date d2 = getDate(time2);
	return d1.getTime() - d2.getTime();
    }

    /**
     * 将小时数换算成返回以毫秒为单位的时间
     * 
     * @param hours
     * @return
     */
    public static long getMicroSec(BigDecimal hours) {
	BigDecimal bd;
	bd = hours.multiply(new BigDecimal(3600 * 1000));
	return bd.longValue();
    }

    /**
     * 获取Date中的分钟
     * 
     * @param d
     * @return
     */
    public static int getMin(Date d) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	return now.get(Calendar.MINUTE);
    }

    /**
     * 获取Date中的小时(24小时)
     * 
     * @param d
     * @return
     */
    public static int getHour(Date d) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	return now.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取Date中的秒
     * 
     * @param d
     * @return
     */
    public static int getSecond(Date d) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	return now.get(Calendar.SECOND);
    }

    /**
     * 获取xxxx-xx-xx的日
     * 
     * @param d
     * @return
     */
    public static int getDay(Date d) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	return now.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取月份，1-12月
     * 
     * @param d
     * @return
     */
    public static int getMonth(Date d) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	return now.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取19xx,20xx形式的年
     * 
     * @param d
     * @return
     */
    public static int getYear(Date d) {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	now.setTime(d);
	return now.get(Calendar.YEAR);
    }

    /**
     * 得到d的上个月的年份+月份,如200505
     * 
     * @return
     */
    public static String getYearMonthOfLastMon(Date d) {
	Date newdate = getInternalDateByMon(d, -1);
	String year = String.valueOf(getYear(newdate));
	String month = String.valueOf(getMonth(newdate));
	return year + month;
    }

    /**
     * 得到当前日期的年和月如200509
     * 
     * @return String
     */
    public static String getCurYearMonth() {
	Calendar now = Calendar.getInstance(TimeZone.getDefault());
	String DATE_FORMAT = "yyyyMM";
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
	sdf.setTimeZone(TimeZone.getDefault());
	return (sdf.format(now.getTime()));
    }

    public static Date getNextMonth(String year, String month) {
	String datestr = year + CON + month + "-01";
	Date date = getDate(datestr, DATAFORMAT_STR);
	return getInternalDateByMon(date, 1);
    }

    public static Date getLastMonth(String year, String month) {
	String datestr = year + CON + month + "-01";
	Date date = getDate(datestr, DATAFORMAT_STR);
	return getInternalDateByMon(date, -1);
    }

    /**
     * 得到日期d，按照页面日期控件格式，如"2001-3-16"
     * 
     * @param d
     * @return
     */
    public static String getSingleNumDate(Date d) {
	return dateToDateString(d, DATAFORMAT_STR);
    }

    /**
     * 得到d半年前的日期,"yyyy-MM-dd"
     * 
     * @param d
     * @return
     */
    public static String getHalfYearBeforeStr(Date d) {
	return dateToDateString(getInternalDateByMon(d, -6), DATAFORMAT_STR);
    }

    /**
     * 得到当前日期D的月底的前/后若干天的时间,<0表示之前，>0表示之后
     * 
     * @param d
     * @param days
     * @return
     */
    public static String getInternalDateByLastDay(Date d, int days) {

	return dateToDateString(getInternalDateByDay(d, days), DATAFORMAT_STR);
    }

    /**
     * 日期中的年月日相加
     * 
     * @param field
     *            int 需要加的字段 年 月 日
     * @param amount
     *            int 加多少
     * @return String
     */
    public static String addDate(int field, int amount) {
	int temp = 0;
	if (field == 1) {
	    temp = Calendar.YEAR;
	}
	if (field == 2) {
	    temp = Calendar.MONTH;
	}
	if (field == 3) {
	    temp = Calendar.DATE;
	}

	String Time = "";
	try {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	    cal.add(temp, amount);
	    Time = sdf.format(cal.getTime());
	    return Time;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}

    }

    /**
     * 获得系统当前月份的天数
     * 
     * @return
     */
    public static int getCurentMonthDay() {
	Date date = Calendar.getInstance().getTime();
	return getMonthDay(date);
    }

    /**
     * 获得指定日期月份的天数
     * 
     * @return
     */
    public static int getMonthDay(Date date) {
	Calendar c = Calendar.getInstance();
	c.setTime(date);
	return c.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    /**
     * 获得指定日期月份的天数 yyyy-mm-dd
     * 
     * @return
     */
    public static int getMonthDay(String date) {
	Date strDate = getDate(date, DATAFORMAT_STR);
	return getMonthDay(strDate);

    }

    public static String getStringDate(Calendar cal) {

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	return format.format(cal.getTime());
    }

    /**
     * 获取日期
     * 
     * @return
     */
    public static String getDateString() {
	Date date = new Date();
	String yyyy = String.valueOf(DateUtil2.getYear(date));
	String mm = String.valueOf(DateUtil2.getMonth(date));
	String dd = String.valueOf(DateUtil2.getDay(date));
	String hh = String.valueOf(DateUtil2.getHour(date));
	String min = String.valueOf(DateUtil2.getMin(date));
	String ss = String.valueOf(DateUtil2.getSecond(date));

	mm = Utils.rightAlign(mm, 2, "0");
	dd = Utils.rightAlign(dd, 2, "0");
	hh = Utils.rightAlign(hh, 2, "0");
	min = Utils.rightAlign(min, 2, "0");
	ss = Utils.rightAlign(ss, 2, "0");
	StringBuffer dateString = new StringBuffer(19);
	dateString.append(yyyy).append(Constants.JOIN_FLAG.LOG_JOINSIGN).append(mm)
		.append(Constants.JOIN_FLAG.LOG_JOINSIGN).append(dd).append(Constants.JOIN_FLAG.LOG_JOINSIGN).append(hh)
		.append(Constants.JOIN_FLAG.LOG_JOINSIGN).append(min).append(Constants.JOIN_FLAG.LOG_JOINSIGN)
		.append(ss);
	return dateString.toString();
    }

    /**
     * 星期转化为数字
     */
    public static String translateDaytoIntStr(String dayEng) {
	if (dayEng.equals("Sun"))
	    return getDayInt("星期日");
	if (dayEng.equals("Mon"))
	    return getDayInt("星期一");
	if (dayEng.equals("Tue"))
	    return getDayInt("星期二");
	if (dayEng.equals("Wed"))
	    return getDayInt("星期三");
	if (dayEng.equals("Thu"))
	    return getDayInt("星期四");
	if (dayEng.equals("Fri"))
	    return getDayInt("星期五");
	if (dayEng.equals("Sat"))
	    return getDayInt("星期六");
	return null;
    }

    public static String getDayInt(String dayChinese) {
	String day = dayChinese.substring(2);
	if (day.equals("日") || day.equals("天"))
	    day = "7";
	return Utils.getIntForCH(day);
    }

    /**
     * 将时间参数转化为毫秒级的长整数
     * 
     * @param time
     * @return
     */
    public static long changeTimeToLong(String time, String formatStr) {
	long ms = -1;
	if (null == formatStr) {
	    formatStr = "yyyy/MM/dd/HH/mm/ss";
	}
	SimpleDateFormat format = new SimpleDateFormat(formatStr);
	Date sdate;
	try {
	    sdate = format.parse(time);
	    Calendar sca = Calendar.getInstance();
	    sca.setTime(sdate);
	    ms = sca.getTimeInMillis();
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return ms;
    }

    public static long changeTimeToLong(String time) {
	return changeTimeToLong(time, null);
    }

    /**
     * 将毫秒级的长整数转化为时间，格式yyyyMMddHHmmss
     * 
     * @param time
     * @return
     */
    public static String changeLongToTime(long time) {
	String times = "";
	SimpleDateFormat format = new SimpleDateFormat(DATATIMEV_STR_S);
	Calendar ca = Calendar.getInstance();
	ca.setTimeInMillis(time);
	times = format.format(ca.getTime());
	return times;
    }

    /**
     * 将毫秒级的长整数转化为时间，格式yyyyMMddHHmmssSSS
     * 
     * @param time
     * @return
     */
    public static String changeLongToTimeM(long time) {
	String times = "";
	SimpleDateFormat format = new SimpleDateFormat(DATATIMEV_STR);
	Calendar ca = Calendar.getInstance();
	ca.setTimeInMillis(time);
	times = format.format(ca.getTime());
	return times;
    }

    /**
     * 将毫秒级的长整数转化为制定格式的时间
     * 
     * @param time
     * @return
     */
    public static String changeLongToTime(long time, String formatStr) {

	if (formatStr == null) {
	    return changeLongToTime(time);
	}

	String times = "";
	SimpleDateFormat format = new SimpleDateFormat(formatStr);
	Calendar ca = Calendar.getInstance();
	ca.setTimeInMillis(time);
	times = format.format(ca.getTime());
	return times;
    }

    /**
     * 时间格式化转换
     * 
     * @param time
     * @return
     * @author 李珑
     */
    public static String formatTime(Long time) {
	if (time == null) {
	    return null;
	}

	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	return formater.format(time);
    }

    /**
     * 时间格式化转换
     * 
     * @param str
     * @return
     * @author 李珑
     */
    public static Long parse(String str) {
	if (str == null) {
	    return null;
	}

	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	try {
	    return Long.valueOf(formater.parse(str.trim()).getTime());
	} catch (ParseException localParseException) {
	}
	return null;
    }
}
