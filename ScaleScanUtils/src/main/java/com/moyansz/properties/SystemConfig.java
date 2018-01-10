package com.moyansz.properties;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SystemConfig {
	/* 账户网关请求头 平台标示key */
	public static String meridKey;
	/* 账户网关请求头 平台标示value */
	public static String meridValue;
	/* 账户网关请求头 域名key */
	public static String domainNameKey;
	/* 账户网关请求头 域名value */
	public static String domainNameValue;
	/* 账号同步接口路径 */
	public static String hxFinanceAccountMiddlewareURL;
	/* 账号同步方法 */
	public static String loginMethod;
	/** 帐号升级为准惠粉/惠粉方法 */
	public static String setSpecialPermission;
	/** 账号网管查询用户信息方法 */
	public static String queryUserInfo;
	/** 账号网管批量查询用户信息方法 */
	public static String batchQueryUserInfo;
	/** 图片访问前缀 **/
	public static String imageServerHttpUrl;

	/* 手机短信有效时间 */
	public static String phoneCodeLife;
	/* 动态响应网页类型 */
	public static Integer webType;
	/* 调用账号网关【忘记密码发认证邮件】接口，找回密码所发邮件有效期 */
	public static Integer forgetPwdSendAuthMailReq_life;
	// 调用账号网关【忘记密码短信重置密码发验证码】接口，验证码有效期秒数
	public static Integer fesetPwdSendCodeReq_life;
	// 账号网关 业务系统编号
	public static Integer sysId;
	// 支付网关访问地址
	public static String pay_gate_way_service_url;
	// 短信接口测试地址
	public static String SMSURL_C;
	// 短信接口线上地址
	public static String SMSURL_Z;
	// 业务系统的短信账号 惠卡贷前台 hkd71 惠卡贷app hkd72 惠卡贷后台 hkd73
	public static String SMS_account;
	// 业务系统的短信密码 与账号相同
	public static String SMS_password;
	// 业务系统 ID（业务数据登录短信管理系统） 惠卡贷前台 71 惠卡贷app 72 惠卡贷后台 73
	public static String SMS_invokerID;
	// 1： 模板短信(目前业务只有验证码)； 2：发送任意内容 默认为2 类型1只给注册使用，注册调用的是账号网关的短信接口
	public static String SMS_sendType;

	// 后台图片上传临时路径
	public static String TEMPIMGSAVEPATH;
	// 后台上传图片所在服务器
	public static String IMGSAVEPATH;

	// 后台上传图片所在服务器
	public static String TRANSFER_BUY_RETURN;

	// 年份、年份月份、年份月份日期模板xml文件夹地址
	public static String TEMPLATES_PATH;
	// 年份xml模板名
	public static String YEAR_TEMPLATE_FILE;
	// 年份月份xml模板名
	public static String YEAR_MONTH_TEMPLATE_FILE;
	// 年份月份日期xml模板名
	public static String YEAR_MONTH_DATE_TEMPLATE_FILE;

	// 连连支付接口
	public static String lianPaySubmitInterface;
	// 连连支付wap接口
	public static String lianWapPaySubmitInterface;
	// 连连支付接口
	public static String lianPayValidInterface;
	// 连连支付查询银行卡bin信息接口
	public static String LIANPAY_QUERYCARDBIN_INTERFACE;
	// 连连支付用户签约信息查询 API接口
	public static String LIANPAY_QUERYBANKCARDLIST_INTERFACE;
	// 连连支付-认证支付接口
	public static String LIANPAY_PREPOSITPAY_INTERFACE;
	// 连连支付 查询订单状态接口
	public static String LIANPAY_QUERYORDER_INTERFACE;
	// 连连支付APP接口
	public static String LIANPAY_APPSUBMIT_INTERFACE;

	/**
	 * 连连支付代付 提现接口
	 */
	public static String LIANPAY_WITHDRAW_INTERFACE;

	/**
	 * 连连支付代付 查询代付(指提现)订单详细信息接口
	 */
	public static String LIANPAY_QUERY_WITHDRAW_ORDER_INTERFACE;

	// 第三方服务地址
	public static String thirdServiceUrl;
	// 短信接口
	public static String smsInterface;

	// 充值同步回调地址
	public static String payFrontMerUrl;

	// 充值WAP同步回调地址
	public static String wapPayFrontMerUrl;
	// 充值异步回调地址
	public static String aynPayFrontMerUrl;
	// 连连支付提现异步回调地址
	public static String withdrawNotifyUrl;
	/** 与惠卡商城对接的RSA签名公钥 */
	public static String Hkmall_public_key;
	/** 与惠卡商城对接的RSA签名私钥 */
	public static String Hkmall_private_key;
	/** 与钱包对接的RSA签名私钥 */
	public static String H5_private_key;
	/** 与微信公众号对接的RSA签名私钥 */
	public static String PublicNo_private_key;

	/**
	 * 单笔充值限额
	 */
	public static String soloRechargeLimitAmt;

	/* 编码方式 */
	public static final String CHARSET_ENCODE = "UTF-8";
	private static Logger logger = Logger.getLogger(SystemConfig.class);
	static {
		Properties p = new Properties();
		try {
			p.load(SystemConfig.class.getResourceAsStream("/config.properties"));
			meridKey = p.getProperty("meridKey");
			meridValue = p.getProperty("meridValue");
			domainNameKey = p.getProperty("domainNameKey");
			domainNameValue = p.getProperty("domainNameValue");
			phoneCodeLife = p.getProperty("phoneCodeLife");
			hxFinanceAccountMiddlewareURL = p.getProperty("hxFinanceAccountMiddlewareURL");
			loginMethod = p.getProperty("loginMethod");
			setSpecialPermission = p.getProperty("setSpecialPermission");
			queryUserInfo = p.getProperty("queryUserInfo");
			batchQueryUserInfo = p.getProperty("batchQueryUserInfo");
			imageServerHttpUrl = p.getProperty("imageServerHttpUrl");
			pay_gate_way_service_url = p.getProperty("pay_gate_way_service_url");
			if (p.getProperty("webType") != null) {
				webType = Integer.valueOf(p.getProperty("webType"));
			}
			if (p.getProperty("forgetPwdSendAuthMailReq_life") != null) {
				forgetPwdSendAuthMailReq_life = Integer.valueOf(p.getProperty("forgetPwdSendAuthMailReq_life"));
			}
			if (p.getProperty("fesetPwdSendCodeReq_life") != null) {
				fesetPwdSendCodeReq_life = Integer.valueOf(p.getProperty("fesetPwdSendCodeReq_life"));
			}
			if (p.getProperty("sysId") != null) {
				sysId = Integer.valueOf(p.getProperty("sysId"));
			}
			SMSURL_C = p.getProperty("SMSURL_C");
			SMSURL_Z = p.getProperty("SMSURL_Z");
			SMS_account = p.getProperty("SMS_account");
			SMS_password = p.getProperty("SMS_password");
			SMS_invokerID = p.getProperty("SMS_invokerID");
			SMS_sendType = p.getProperty("SMS_sendType");
			TEMPIMGSAVEPATH = p.getProperty("tempImgSavePath");
			IMGSAVEPATH = p.getProperty("imgSavePath");
			TRANSFER_BUY_RETURN = p.getProperty("transfer_buy_return");
			TEMPLATES_PATH = p.getProperty("templates_path");
			YEAR_TEMPLATE_FILE = p.getProperty("year_template_file");
			YEAR_MONTH_TEMPLATE_FILE = p.getProperty("year_month_template_file");
			YEAR_MONTH_DATE_TEMPLATE_FILE = p.getProperty("year_month_date_template_file");

			lianPaySubmitInterface = p.getProperty("lian_pay_submit_interface");
			lianWapPaySubmitInterface = p.getProperty("lian_wap_pay_submit_interface");
			lianPayValidInterface = p.getProperty("lian_pay_valid_interface");
			LIANPAY_QUERYCARDBIN_INTERFACE = p.getProperty("lian_pay_queryCardBin_interface");
			LIANPAY_QUERYBANKCARDLIST_INTERFACE = p.getProperty("lian_pay_queryBankcardList_interface");
			LIANPAY_QUERYORDER_INTERFACE = p.getProperty("lian_pay_queryOrder_interface");
			LIANPAY_PREPOSITPAY_INTERFACE = p.getProperty("lian_pay_prepositPay_interface");
			LIANPAY_APPSUBMIT_INTERFACE = p.getProperty("lian_pay_app_submit_interface");
			LIANPAY_WITHDRAW_INTERFACE = p.getProperty("lianpay_withdraw_interface");
			LIANPAY_QUERY_WITHDRAW_ORDER_INTERFACE = p.getProperty("lianpay_query_withdraw_order_interface");
			thirdServiceUrl = p.getProperty("pay_gate_way_service_url");
			smsInterface = p.getProperty("sms_interface");
			aynPayFrontMerUrl = p.getProperty("aynPayFrontMerUrl");
			payFrontMerUrl = p.getProperty("payFrontMerUrl");
			wapPayFrontMerUrl = p.getProperty("wapPayFrontMerUrl");
			withdrawNotifyUrl = p.getProperty("withdrawNotifyUrl");
			soloRechargeLimitAmt = p.getProperty("soloRechargeLimitAmt");
			Hkmall_public_key = p.getProperty("HKMALL_PUBLICK_KEY");
			Hkmall_private_key = p.getProperty("HKMALL_PRIVATE_KEY");
			H5_private_key = p.getProperty("h5PrivateKey");
			PublicNo_private_key = p.getProperty("PUBLICNO_PRIVATE_KEY");

		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(SystemConfig.meridKey);
	}
}
