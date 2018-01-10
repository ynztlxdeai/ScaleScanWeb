
package com.moyansz.common;

/**
 * 
 * @description:系统常量
 * @fileName:SystemConstants.java
 * @createTime:2014年11月5日 下午7:54:19
 * @author:肖震
 * @version 1.0.0
 *
 */
public final class SystemConstants {

	// 惠信宝体验金持续时间天数
	public final static String TRY_DAYS = "tryDays";

	// 体验金金额
	public final static String TRY_AMOUNT = "tryAmount";
	// 短信间隔
	public final static String MSG_INTERVAL = "msgInterval";

	// 平台服务关闭
	public final static String NO_BESPEAK = "0";
	// 平台服务关闭
	public final static String TERRACE_ERROR = "2500000";
	// 系统服务关闭
	public final static String SYSTEM_ERROR = "2400000";
	// 无此服务平台对象(即安全认证失败)
	public final static String SECURITY_VALIDATION = "2600000";
	// 账号网关执行代码出现异常
	public final static String TERRACE_EXCEPTION = "2800000";
	// 1048777登录账号错误
	public final static String IS_NOT_VIP = "1048776";
	// 1048777登录账号错误
	public final static String ACC_ERROR = "1048777";
	// 1048778 登录密码错误
	public final static String PWD_ERROR = "1048778";
	// 1048780账号开始被锁定
	public final static String LOCK_START = "1048780";
	// 1048784账号在帐号中心被冻结
	public final static String FREEZE_ERROR = "1048784";
	// 1048781账号处于锁定保护期
	public final static String LOCK_GUARD = "1048781";
	// 手机验证码 错误
	public final static String CHECK_CODE_ERROR = "1048821";
	// 手机请求验证码繁忙
	public final static String CHECK_CODE_EXCEPTION = "1048686";
	// 手机号已被绑定过
	public final static String ERROR_MOBILE_EXIST = "1048688";
	// 系统访问繁忙
	public final static String SYSTEM_ACCESS_BUSY = "1048689";

	/**
	 * 1049112编码：客户已经是惠粉
	 */
	public final static String ERROR_ACC_VIP = "1049112";

	// 验证时效性1=验证后验证码失效 ,2验证后验证码保留有效性
	public final static Integer CHECK_DEL = 2;

	// 验证类型2=手机
	public final static Integer CHECK_PHONE = 2;

	// 验证类型1=账号
	public final static Integer CHECK_ACC = 1;

	// 验证码超时时间30分钟
	public final static Integer VALIDTIME = 1800;

	// 业务系统编号151=创业宝网站 152=创业宝app 153=创业宝后台
	public final static Integer SYS_ID = 151;

	// 注册来源（1.网站 2.admin 3.ios）
	public final static Integer SRC_FLG = 1;

	// genid 生成uid标签 1 后台生成
	public final static Integer GENID_FLG = 1;

	// ncd 2=有验证码有手机号
	public final static Integer NCD_FLG = 2;

	// Acmail 1=代表无邮箱
	public final static Integer ACMAIL_FLG = 1;

	/**
	 * 是否存在，查询类型，手机
	 */
	public final static String TYPE_MOBILE = "2";

	/**
	 * 已存在，被占用
	 */
	public final static String IS_EXIST = "0";
	/**
	 * 不存在，未被占用
	 */
	public final static String NOT_IS_EXIST = "1";

	/**
	 * 返回状态，其他
	 */
	public static String CHECK_STUTUS_BAD = "1";

	// 是否显示体验金弹出框
	public final static String IS_SHOW_TRY = "is_show_try";

	// 放到session中的用户信息
	public final static String USER_SESSION_INFO = "user_session_info";
	public final static String ADMINUSER_SESSION_INFO = "adminuser_session_info";
	public final static String ADMINUSER_LOGIN_ACCOUNT = "adminUserAccount";
	// 用户登录类型-web端
	public final static short USER_LOGIN_TYPE_WEB = 1;
	// 用户用户名
	public final static String USER_LOGIN_ACCOUNT = "userAccount";
	// 用户头像
	public final static String USER_LOGIN_PORTRAIT = "portrait";
	// 评论分页排除ID
	public final static String USER_PAGE_ID = "userPageId";
	// 用户预约状态
	public final static String USER_BESPEAKSTATUS = "user_bespeak_status";

	/**
	 * 放到session中的userid信息
	 */
	public final static String USERID_SESSION_INFO = "UserId_session_info";

	/**
	 * 放到session中的uid信息
	 */
	public final static String USER_SESSION_UID = "User_session_uid";

	/**
	 * 放到session中的accName信息
	 */
	public final static String USERACCNAME_SESSION_INFO = "UserAccname_session_info";

	/**
	 * 项目路径(充值会使用到)
	 */
	public static String WEB_URL = "http://hd.365sji.com";

	/**
	 * 项目使用端口号
	 */
	public static String PROXYPORT = "7001";

	/* ============ Begin 定义提现错误信息码 ==================== */
	/** 提现金额错误 */
	public static String WITHDRAW_AMOUNT_ERROR = "10001";
	/** 提现卡号错误 */
	public static String WITHDRAW_BANKCARD_ERROR = "10002";
	/** 未绑定卡号 */
	public static String NOT_BIND_BACKCARD = "10003";
	/** 支付密码输入错误 */
	public static String WITHDRAW_PAYPASSWORD_ERROR = "10004";
	/** 支付密码超过最大输入次数，不允许在输入 */
	public static String WITHDRAW_PAYPASSWORD_IPT_COUNT_ERROR = "10005";
	/** 提现余额大余帐户余额 */
	public static String WITHDRAW_ACCOUNT_AMOUNT_INSUFFICIENT = "10006";
	/** 提现金额为零 */
	public static String WITHDRAW_ACCOUNT_AMOUNT_ZERO = "10007";
	/** 提现费用计算错误 */
	public static String WITHDRAW_FEE_CACU_ERROR = "10008";
	/** 系统参数配置中未正确配置提现模式 */
	public static String WITHDRAW_MODEL_ERROR = "10009";
	/** 提现账户的余额数据格式不正确(如为空等) */
	public static String WITHDRAW_ACCOUNT_AMOUNT_ERROR = "10010";
	/** 提现金额为负数 */
	public static String WITHDRAW_APPLY_AMOUNT_NEGATIVE = "10011";
	/** 提现费用计算错误 */
	public static String WITHDRAW_FEE_CACU_ERROR_DESC = "提现费用计算错误";

	/* ============ End 定义提现错误信息码 ============================== */

	/** 支付密码输入字段定义 */
	public static String PAY_PASSWORD_MAX_IPT_COUNT = "payPassMaxIptCount";

	/** 惠信宝APP端获取提现信息接口的提示信息 */
	public static String HXB_APP_WITHRAWALTIP = "hxbAppWithrawalTip";

	/* ============= Begin 定义支付信息码 ======================== */

	/** 支付成功 */
	public static String PAY_SUCCESS = "0000";

	/** 支付失败 */
	public static String PAY_FAILURE = "1005 ";

	/** 不存在此用户 */
	public static String USER_NOT_EXIST = "不存在此用户";

	/** 支付手机号码不存在 */
	public static String PAY_MOBILE_NOT_EXIST = "支付手机号码不存在";
	/** 支付手机号码不存在 */
	public static String PAY_BLANKCARDNO_NOT_EXIST = "支付银行卡号不存在";

	public static String PAY_SYSTEM_IS_BUSY = "系统繁忙，请稍后再试！";

	/* ============= Begin 定义支付信息码 ======================== */

	/**
	 * 充值金额超出限制
	 */
	public static String RECHARGE_AMOUNT_OVERFLOW_SOLO = "单笔充值金额超出限制";

	/**
	 * 充值金额超出限制
	 */
	public static String RECHARGE_AMOUNT_OVERFLOW_DAY = "当日充值金额超出限制";

	/**
	 * 充值金额超出限制
	 */
	public static String RECHARGE_AMOUNT_OVERFLOW_MONTH = "当月充值金额超出限制";

	/**
	 * 银行卡未绑定
	 */
	public static String BANK_CARD_HAVENO_BIND = "银行卡未绑定";

	/**
	 * 惠粉H5链接的key
	 */
	public final static String RSA_KEY = "key";
	public final static String UID = "uId";
	// 用户账号
	public final static String ACC_NAME = "accName";
	// 用户密码
	public final static String ACC_PWD = "accPwd";
	public final static String MAC = "mac";
	// 登录来源
	public final static String LOGIN_SOURCE = "loginSource";

	/**
	 * 1:登录状态 app
	 */
	public final static short LOGIN_STATUS = 1;

	/**
	 * 0:未登录状态 app
	 */
	public final static short LOGINOUT_STATUS = 0;

	/**
	 * 2:用户已经登录 app
	 */
	public final static String REPEAT_LOGIN = "2";

	// 查询体验金开始条数
	public final static Integer EXPERIENCE_INDEX = 1;
	// 查询体验金结束条数
	public final static Integer EXPERIENCE_END = 40;
	/**
	 * 当前用户的菜单列表
	 */
	public final static String USER_SESSION_MENU_LIST = "User_session_menuList";

	// cdn地址
	/*
	 * public static String CDN_URL = null;
	 * 
	 * static { init(); }
	 * 
	 *//**
		 * @function: 读取配置文件初始化常量信息
		 * @exception @author:Wuwenyong
		 * @since 1.0.0
		 *//*
		 * private static void init() { try { InputStream is =
		 * SystemConstants.class.getResourceAsStream("/config.properties");
		 * Properties prop = new Properties(); prop.load(new
		 * InputStreamReader(is)); CDN_URL = prop.getProperty("cdn_url");
		 * is.close(); prop = null; } catch (Exception e) { e.printStackTrace();
		 * } }
		 */
}
