
package com.moyansz.common;

/**
 * 
 * @author 李珑
 *
 */
public interface Constants {
    public static final String USERID = "userId";
    public static final String CNAME = "cname";

    public static final String TOPIC_COMMAND_EXCEPTION = "command_exception";

    public static class DATE_TIME_FORMAT {
	// 默认日期格式
	public static final String DATA_PATTERN = "yyyy-MM-dd";
	// 默认时间格式
	public static final String TIME_PATTERN = "HH:mm:ss";
	// 默认日期时间格式
	public static final String DATA_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME = "time";
    }

    public static class JOIN_FLAG {
	// 连接符
	public static final String LOG_JOINSIGN = "_";
	// 匹配符
	public static final String MATCHSIGN = "%";
    }

}
