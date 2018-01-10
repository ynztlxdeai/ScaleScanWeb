
package com.moyansz.common;
/**
 * 
 * @描述: redis存储键定义
 * @作者: luck
 * @时间: 2016年11月14日
 * @版本: 1.0 .
 */
public class RedisConstants {
	
	/******************************************   门户首页缓存定义     *************************************************/
	public static final String HOME_NEW_BASIC = "homeNewBasic";						// 新加入的学校
	
	public static final String HOME_BASIC_REPORT = "homeBasicReport";				// 基础教育统计位置
	
	public static final String HOME_NEW_TEACHERCOURSE = "homeNewTeacherCourse";		// 首页最新名师课表
	
	public static final String TRAIN_RECOMMEND   = "trainRecommend";				// 培训机构推荐
	
	public static final String HOT_TEACHER = "hotTeacher";									//热门教师
	
	
	/******************************************   基础教育缓存定义     *************************************************/
	public static final String BAISC_SCHOOLREPORT_SCHOOLID = "basicSchoolReportBySchoolId";	// 基础教育学校统计
	
	
	
	/******************************************   数据字典缓存定义     *************************************************/
	public static final String DICT_GRADE_LIST = "dictGradeList";					// 年级属性
	
	public static final String DICT_GRADE_TYPE_LIST = "dictGradeTypeList";					// 字典表查询类型
	public static final String DICT_GRADE_PARENT_LIST = "dictGradeParentList";					// 字典表查询上级
	
	
	
	/******************************************   客服相关缓存定义     *************************************************/
	public static final String CUSTOM_LIST_BYCITYID = "customListByCityId";			// 客服设置
	
	
	/******************************************   定时任务缓存定义     *************************************************/
	
	public static final String ATTENDLESSON_SCHEDU_LASTTIME_ONEHOURS = "attendLessonScheduLastTimeForOneHours";
	public static final String ATTENDLESSON_SCHEDU_LASTTIME_ONEDAY = "attendLessonScheduLastTimeForOneDay";
	
	public static final String PROMOTED_SCHEDU_LASTTIME_ONEHOURS = "promotedScheduLastTimeForOneHours";
	
	public static final String LOGIN_ERROR_USER = "USERLOGINFAILLOCK";
	
	//会员代理用户缓存key
	public static final String LOGIN_USER_MBMBER = "LOGIN_USER_MBMBER_";
	
}
