package com.moyansz.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * @description:日期工具类   
 * @fileName:DateUtil.java 
 * @createTime:2015年3月18日 下午2:15:53  
 * @author:肖震 
 * @version 1.0.0  
 *
 */
public class DateUtil {
private static Calendar cal = Calendar.getInstance();
	
	/**
	 * 获取两个时间相差的小时数 
	 * @param start
	 * @param end
	 * @return
	 */
	public static double getDiffHour(Date start ,Date end) {
		double diff = (end.getTime() - start.getTime())/1000/60/60;
		return diff;
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat sdf3 = new SimpleDateFormat("yyMMdd");
	public static SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf5 = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    public static SimpleDateFormat sdf7 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
    public static SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy年MM月dd日");
    public static SimpleDateFormat sdf9 = new SimpleDateFormat("MM.dd");
    public static SimpleDateFormat sdf10 = new SimpleDateFormat("yyMMddHHmmss");
    public static SimpleDateFormat sdf11 = new SimpleDateFormat("YYYYMMddHHmmss");
    public static SimpleDateFormat sdf12 = new SimpleDateFormat("HH:mm:ss");
    
	public static Date toDataYYYYMMDD(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date toDataYYYYMMDDHHmmss(String str) {
		try {
			return sdf4.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatDataYYYYMMDD(Date date) {
		return sdf2.format(date);
	}
	public static String formatDataYYMMDD(Date date) {
		return sdf3.format(date);
	}
	public static String formatDataYYYYMMDDHHMMSS(Date date) {
		return sdf11.format(date);
	}
	public static String formatDataYYMMDDHHMMSS(Date date) {
		return sdf5.format(date);
	}
	public static String formatDatayyMMDDHHMMSS(Date date) {
		return sdf10.format(date);
	}
	
	public static String formatDataYYYYMMDDLine(Date date) {
		return sdf.format(date);
	}
	public static String formatDataToDatetime(Date date){
		return sdf4.format(date);
	}
	
	public static String formatDataDay(Date date) {
		return sdf.format(date);
	}
	
	public static String formatHhmmss(Date date) {
		return sdf12.format(date);
	}
	/**
	 * 获取当前日期month个月后的日期 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date getAddMonthDate(Date date ,int month) {
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
	}
	 
	/**
	 * 格式化日期x年x月x日 xx:xx
	 * @param date
	 * @return
	 */
	public static String getZHDate(Date date) {
        String zhDate = sdf6.format(date);
        return zhDate;
	}
	public static String getZHShortDate(Date date){
		String zhShortDate = sdf8.format(date);
		return zhShortDate;
	}
	/**
     * 按天借款的方式 返款时间的计算
     * @param releaseTime 放款时间
     * @param termCount 借款天数
     * @return 还款日期
     */
    public static Date getDayRepayDate(Date releaseTime,int termCount) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(releaseTime);
        calendar.add(Calendar.DATE, termCount);
        return calendar.getTime();
    }
	/**
	 * 获取某天之前或者之后自然日 返回格式   ：yyyy-MM-dd
	 * @param releaseTime
	 * @param termCount   负数则为之前    正数则为之后
	 * @return
	 */
	public static String getNatureDay(Date releaseTime,int termCount){
		Date date = getDayRepayDate(releaseTime,termCount);
		return sdf.format(date);
	}
	
	/**
	 *  获取某天之前或者之后自然日 返回格式   ：yyyy-MM-dd HH:mm:ss
	 * @param releaseTime
	 * @param termCount 负数则为之前    正数则为之后
	 * @return String
	 * @Description:
	 * @author 刘恒   
	 * @date 2015年3月11日 下午12:47:18 
	 * @version V1.0
	 */
	public static Date getNatureDay(String releaseTime,int termCount){
        Calendar calendar = Calendar.getInstance() ;  
        try {  
            calendar.setTime(sdf4.parse(releaseTime)) ;  
        } catch (java.text.ParseException e) {  
            e.printStackTrace();  
        }  
        calendar.add(calendar.DATE,termCount) ;  
        return calendar.getTime() ;  
	}
	 
	/**
	 * 获取某天之前或者之后的几个月自然日 返回格式   ：yyyy-MM-dd
	 * @param date
	 * @param month   负数则为之前    正数则为之后
	 * @return
	 */
	public static String getNatureMonth(Date date ,int month){
		Date dateCal = getAddMonthDate(date,month);
		return sdf.format(dateCal);
	}
	
	/**
	 * 判断两个其实是否为同一天
	 * @param date
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date, Date date2){
		if(date == null || date2 == null) return false;
		return differDays(date, date2) == 0?true:false;
	}
	
	/**
	 *  判断参数日期是否为当天
	 * @param date
	 * @param todayDate
	 * @return
	 */
	public static boolean isToday(Date date){
		if(date == null) return false;
		return differDays(date, new Date()) == 0? true: false;
	}
	
	
	/**
	 * 判断给定日期与当天相差的天数     给定的日期为以后的日期则为负数
	 * @param date
	 * @param todayDate
	 * @return
	 */
	public static int differDays(Date date, Date baseDate){
		if(date == null) return -1;
		cal.setTime(date);
		Calendar today = Calendar.getInstance();
		today.setTime(baseDate);
		int differYearDay = today.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
		if(today.get(Calendar.YEAR) > cal.get(Calendar.YEAR)){
			int templYear = cal.get(Calendar.YEAR);
			differYearDay = 0;
			while(templYear != today.get(Calendar.YEAR)){
				cal.set(Calendar.YEAR, templYear ++);
				differYearDay += cal.getActualMaximum(Calendar.DAY_OF_YEAR);
			}
			differYearDay = differYearDay + today.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
		}else if(today.get(Calendar.YEAR) < cal.get(Calendar.YEAR)){
			int templYear = cal.get(Calendar.YEAR);
			differYearDay = cal.get(Calendar.DAY_OF_YEAR);
			templYear --;
			while(templYear != today.get(Calendar.YEAR)){
				cal.set(Calendar.YEAR, templYear --);
				differYearDay += cal.getActualMaximum(Calendar.DAY_OF_YEAR);
			}
			differYearDay += today.getActualMaximum(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR);
			differYearDay = -differYearDay;
		}
		return differYearDay;
	}
	
	/**
	 * 
	 * @function:  比较两个时间相隔天数，精确到秒的比较
	 * @param registerTime
	 * @param nowDate
	 * @return int   
	 * @exception 
	 * @author:刘玉峰   
	 * @since  1.0.0
	 */
	public static int differDaysByTime(Date registerTime, Date nowDate){
	       long intervalMilli = nowDate.getTime() - registerTime.getTime();
	       return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}
	
	
	/**
	 * 获取给定日期与当前日期相差天数
	 * @function:  
	 * @param date
	 * @return int   
	 * @exception 
	 * @author:HX1401122   
	 * @since  1.0.0
	 */
	public static int differDays(Date date){
		Date baseDate = new Date();
		return differDays(baseDate,date);
	}
	
	/**
	 * 
	 * @function:计算两个日期相差天数  
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return int   
	 * @exception 
	 * @author:肖震   
	 * @since  1.0.0
	 */
	public static int differDaysWithoutRigor(Date startDate, Date endDate){
		
		try
		{
			return daysBetween(startDate,endDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();  
		}
		return 0;
	}
	
	
	public static Date nextYear(int hav, Date date){
		return next(Calendar.YEAR, hav, date);
	}
	
	public static Date nextMonth(int hav, Date date){
		return next(Calendar.MONTH, hav, date);
	}
	
	public static Date nextDay(int hav, Date date){
		return next(Calendar.DAY_OF_MONTH, hav, date);
	}
	
	public static Date next(int dateType, int hav, Date date){
		cal.setTime(date);
		cal.add(dateType, hav);
		return cal.getTime();
	}
	
	public static Date nextDayUpdateTime(int hav, Date date){
		Calendar calOrg = Calendar.getInstance();
		calOrg.setTime(date);
		Calendar newCal = Calendar.getInstance();
		newCal.set(Calendar.YEAR, calOrg.get(Calendar.YEAR));
		newCal.set(Calendar.MONTH, calOrg.get(Calendar.MONTH));
		newCal.set(Calendar.DAY_OF_MONTH, calOrg.get(Calendar.DAY_OF_MONTH));
		newCal.add(Calendar.DAY_OF_MONTH, hav);
		return newCal.getTime();
	}
	
	public static String nextDayByHour(int hav, Date date){
    	SimpleDateFormat dft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
    	Calendar   dar=Calendar.getInstance();     
    	dar.setTime(date);     
    	dar.add(java.util.Calendar.HOUR_OF_DAY, hav);     
        return dft.format(dar.getTime());
	}
	/**
	 * 比较给的时间与现在的时间前后顺序   true:之后的时间、 false:之前的时间
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static boolean afterTime(int hour, int minute){
		int nowHour = cal.get(Calendar.HOUR_OF_DAY);
		int nowMinute = cal.get(Calendar.MINUTE) + 5;
		
		
		if(nowHour < hour) return true;
		if(nowHour > hour) return false;
		if(nowHour == hour && nowMinute <= minute) return false;
		return true;
	}
	/**
	 * 
	 * description: 将日期转字符串
	 * 
	 * @param date 日期
	 * @param format 日期格式
	 * @return String 字符串
	 * @author:肖震
	 * @since 1.0.0
	 */
	public static String dateToString(Date date, String format)
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	/**
	 * 
	 * @function:字符串转日期  
	 * @param str 字符串
	 * @param formatt 日期格式，如：yyyy-MM-dd
	 * @return Date   
	 * @exception 
	 * @author:肖震   
	 * @since  1.0.0
	 */
	public static Date StringToDate(String str,String formatt)
	{
		Date date = null;
		try {
			  if(!StringUtils.isEmpty(str))
			  {
		        SimpleDateFormat format = new SimpleDateFormat(formatt);		   
		   
		         date = format.parse(str);
			   }
		   } catch (ParseException e) {
		    e.printStackTrace();
		   }
		   return date;
	}
	
	/**  
     * 计算两个日期之间相差的小时数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差小时数 
     * @author 李辞辞
     * @throws ParseException  
     */    
    public static int hoursBetween(Date smdate,Date bdate) throws ParseException    
    {    
        smdate=sdf5.parse(sdf5.format(smdate));  
        bdate=sdf5.parse(sdf5.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_hours=(time2-time1)/(1000*3600);  
            
       return Integer.parseInt(String.valueOf(between_hours));           
	
    }
    
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
      
    /**
     * 
     * @function:字符串的日期格式的计算  
     * @param smdate
     * @param bdate
     * @return int
     * @throws ParseException    
     * @exception 
     * @author:肖震   
     * @since  1.0.0
     */
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }  
    
    /**
     * @function: unix时间戳转换为日期  
     * @param timeStamp
     * @return
     * @throws ParseException Date   
     * @exception 
     * @author:duyubo   
     * @since  1.0.0
     */
    public static Date timeStampToDate(Long unixTimeStamp) throws ParseException{
    	if(unixTimeStamp != null){
    		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    		return format.parse(format.format(unixTimeStamp*1000));
    	}
    	return null;
    }
    
    /**
     * @function:秒数转为时间格式  
     * @param time
     * @return String   
     * @exception 
     * @author:duyubo   
     * @since  1.0.0
     */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time > 0){
        	minute = time / 60;
        	if (minute < 1){
        		timeStr = time +"秒";
        	} else if (minute < 60) {
        		second = time % 60;
        		timeStr = minute + "分" + unitFormat(second) +"秒";
        	} else {
        		hour = minute / 60;
        		if (hour > 99)
        			return "99小时59分59秒";
        		minute = minute % 60;
        		second = time - hour * 3600 - minute * 60;
        		timeStr = hour + "小时" + unitFormat(minute) + "分" + unitFormat(second) +"秒";
        	}
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
    /**
     * 计算两个时间的秒差
     * @param start
     * @param end
     * @return int
     * @Description:
     * @author 刘恒   
     * @date 2015年3月14日 下午10:42:06 
     * @version V1.0
     */
    public static int differSecond(Date start ,Date end){
    	return (int)((end.getTime()-start.getTime())/1000);
    }

    /**
     * 计算两日期相差的天数
     * 
     * @param early
     * @param late
     * @return
     */
    public static  Date addDay(Date date, int days) {

        Calendar caled = Calendar.getInstance();
        caled.setTime(date);
        caled.add(Calendar.DATE, days);

        return caled.getTime();
    }
	
    /**
     * add minutes
     * 
     * @param early
     * @param late
     * @return
     */
    public static  Date addMinutes(Date date, int minutes) {

        Calendar caled = Calendar.getInstance();
        caled.setTime(date);
        caled.add(Calendar.MINUTE, minutes);

        return caled.getTime();
    }
    

    /**
     * 时间差相差分钟
     * @param date
     * @param minutes
     * @return
     */
    public static int differMinutes(Date start ,Date end){
    	return (int)((end.getTime()-start.getTime())/(1000*60));
    }
    
    /**
     * 返回固定格式的当前时间
     *   yyyy-MM-dd hh:mm:ss
     * @param date
     * @return
     */
    public static String dateToStringWithTime( ) {

        return dateToString(new java.util.Date(), "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 获取系统当前年月
     * @return YYYYMM格式
     */
    public static String getCurPeriod()
    {
    	String billPeriod = null;
		int month = Calendar.getInstance().get( Calendar.MONTH)+1;
		int year = Calendar.getInstance().get( Calendar.YEAR );
		
		billPeriod = Integer.toString(year);
		if(month<10)
			billPeriod = billPeriod + "0" + Integer.toString(month);
		else
			billPeriod = billPeriod + Integer.toString(month);
		return billPeriod;
    }
    
    /**
     * 获取指定月份的上一个月
     * @param billPeriod 当前月
     * @return lastMonth 上一个月
     */
    public static String getBeforeMonth(String billPeriod) {
        int lastMonth = 0;
    	if(billPeriod != null && !"".equals(billPeriod)){
    		char[] temp = billPeriod.toCharArray();
    		if (temp[temp.length - 2] == '0' && temp[temp.length - 1] == '1') {
    			lastMonth = Integer.parseInt(billPeriod) - 100 + 11;// 假如是一月的时候上月应是上年12月
			} else {
				lastMonth = Integer.parseInt(billPeriod) - 1;// 上月
			}
        }
        return String.valueOf(lastMonth);
    }
    
    /** 
     * 日期格式字符串转换成时间戳 
     * @param date 字符串日期 
     * @param format 如：yyyy-MM-dd HH:mm:ss 
     * @return 
     */  
    public static String date2TimeStamp(String date_str,String format){  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat(format);  
            return String.valueOf(sdf.parse(date_str).getTime()/1000);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    } 
    
    /** 
     * 取得当前时间戳（精确到秒） 
     * @return 
     */  
    public static String getCurtimeStamp(){  
        long time = System.currentTimeMillis();  
        String t = String.valueOf(time/1000);  
        return t;  
    }  
    
    
    /** 
     * 时间戳转换成日期格式字符串 
     * @param seconds 精确到秒的字符串 
     * @param formatStr 
     * @return 
     */  
    public static String timeStamp2Date(String seconds,String format) {  
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
            return "";  
        }  
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
    }  
    
    /**
     * 获取包括当月在内的过去几个月
     * @param count 需要返回的月数
     * @return YYYYMM格式的字符串组成的向量
     */
    public static String[] getBeforeMonths(int count) {
        String[] months = new String[count];
        java.util.Calendar cal = java.util.Calendar.getInstance();
        for (int i = 1; i <= count; i++) {
            java.util.Date dt = cal.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            String str = formatter.format(dt);
            months[i - 1] = str;
            cal.add(java.util.Calendar.MONTH, -1);
        }
        return months;
    }
    
    /**
     * 获取不包括当月在内的过去几个月
     * @param count 需要返回的月数
     * @return YYYYMM格式的字符串组成的向量
     */
    public static String[] getBeforeMonthsNoCurMonth(int count) {
    	String[] arr = new String[count];
    	String[] str = getBeforeMonths(count+1);
    	for (int i = 0; i < arr.length; i++)
		{
    		arr[i] = str[i+1];
		}
    	return arr;
    }
    
    public static String getFirstOrEndMonth(int num){
    	Calendar cale = Calendar.getInstance();  
        cale.set(Calendar.DAY_OF_MONTH,num);//设置为1号,当前日期既为本月第一天
        String day = sdf.format(cale.getTime());
        return day;
    }
    
    /**
     * 一种字符串格式的日期 转换为另一种
     * 比如 yyyyMMddHHmmss 转换为  yyyy-MM-dd HH:mm:ss
     * @time 2015年上午10:06:10
     * @author duyubo
     * @return
     */
    public static String convertToAnotherDataFmt(String dataStr,SimpleDateFormat fromStyle,SimpleDateFormat toStyle){
		try {
			Date date = fromStyle.parse(dataStr);
			String aim = dateToString(date, toStyle.toPattern());
			return aim;
		} catch (ParseException e) {
			e.printStackTrace();
		}  
    	return null;
    }
    /**
     * 比较日期大小
     * @param DATE1
     * @param DATE2
     * @author 邱先锋
     * @return
     */
    public static int compareDate(Date dt1, Date dt2) {
        try {
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    
	/**  
     * 计算两个日期之间相差的分钟数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差分钟数 
     * @author lhl
     * @throws ParseException  
     */    
    public static int mimeBetween(String smdate,String bdate) throws ParseException    
    {    
    	
    	
    	Date sTime=sdf4.parse(smdate);  
        Date eTime=sdf4.parse(bdate);  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sTime);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(eTime);    
        long time2 = cal.getTimeInMillis();         
        long between_hours=(time2-time1)/(1000*60);  
            
       return Integer.parseInt(String.valueOf(between_hours));           
	
    }
	
    /**给指定的时间增加10分钟
     * @param  smdate
     * @return String
     * @author lhl
     * @date 2016-11-04
     * */
    public static String newSmdate(String smdate)throws ParseException{
    	
    	 Date sTime=sdf4.parse(smdate); 
    	 Calendar cal = Calendar.getInstance();    
         cal.setTime(sTime);
         long time1 = cal.getTimeInMillis();
    	 time1=time1+600*1000;
    	 smdate=sdf4.format(time1);    	 
    	 return smdate;
    	 
    }
    
    
	/**  
     * 计算日期与当前时间的差 
     * @param smdate 时间 
     * @return 相差秒数 
     * @author lhl
     * @throws ParseException  
     */    
    public static int secondsBetween(Date smdate) throws ParseException    
    {    
    	
    	Date date=new Date();
    	smdate=sdf4.parse(sdf4.format(smdate));  
    	date=sdf4.parse(sdf4.format(date));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(date);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time1-time2)/(1000);  
            
       return Integer.parseInt(String.valueOf(between_days));   
    	   
	
    }
    
    
    public static void main(String[] args)
	{
    	
    	System.out.println(date2TimeStamp("2012-12-12 12:13:14", "yyyy-MM-dd HH:mm:ss"));
		System.out.println(timeStamp2Date(date2TimeStamp("2012-12-12 12:13:14", "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
//    	System.out.println(getCurPeriod());
//    	System.out.println(getBeforeMonth(getCurPeriod()));
//    	System.out.println(getBeforeMonth("201501"));
    	/*String[] m = getBeforeMonthsNoCurMonth(12);
    	
    	for (int i = 0; i < m.length; i++)
		{
			System.out.println(m[i]);
		}*/
    	//获得当前日期只有N个月的时间
    	/*SimpleDateFormat formt=new SimpleDateFormat("YYYY-MM-dd");
    	System.out.println(formt.format(new Date()));
    	System.out.println(formt.format(getAddMonthDate(new Date(),6)));
    	System.out.println(differDaysWithoutRigor(new Date(),getAddMonthDate(new Date(),6)));*/
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    	Calendar cale = Calendar.getInstance();  
        cale.set(cale.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String lastDay = format.format(cale.getTime());
        System.out.println("-----2------lastDay:"+lastDay);
        
		try {
	        String now1 = "2015-07-16 14:51:00";	        
	        String now2 = "2015-07-15 14:51:00";
			Date dt1 = sdf4.parse(now1);
			Date dt2 = sdf4.parse(now2);
			int ii = compareDate(dt1,dt2);
		       System.out.println(ii);
		       
		      System.out.println(formatHhmmss(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}