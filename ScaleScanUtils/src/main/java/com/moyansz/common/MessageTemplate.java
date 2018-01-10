package com.moyansz.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class MessageTemplate {
	/*手机验证码*/
	public static String mobileVerificationMessage;
	/*提现成功*/
	public static String withdrawMessage;
	/*充值超过最大限额提示*/
	public static String maxRechargeAmountMessage;
	private static Logger logger = Logger.getLogger(MessageTemplate.class);
	static  {
		Properties p = new Properties();
		try {
			p.load(MessageTemplate.class.getResourceAsStream("/messagetemplate.properties"));
			mobileVerificationMessage = p.getProperty("mobileVerificationMessage");
			withdrawMessage = p.getProperty("withdrawMessage");
			maxRechargeAmountMessage = p.getProperty("maxRechargeAmountMessage");
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
