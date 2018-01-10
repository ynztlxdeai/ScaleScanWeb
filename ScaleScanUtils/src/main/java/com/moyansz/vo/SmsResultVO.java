package com.moyansz.vo;

/**
 * Project Name:filmbThirdService File Name:SmsResultVO.java Package
 * Name:com.filmb.third.sms.vo Date:2014年11月13日下午3:53:37 Copyright (c) 2014
 * 
 */
/**
 * @projectName:filmbThirdService
 * @packageName:com.filmb.third.sms.vo
 * @className:SmsResultVO.java
 * 
 * @createTime:2014年11月13日-下午3:53:37
 * 
 * 
 */

/**
 * @description:短信发送结果VO类
 * @fileName:SmsResultVO.java
 * @createTime:2014年11月13日 下午3:53:37
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class SmsResultVO implements java.io.Serializable {

	private static final long serialVersionUID = -5351986156925935519L;

	// 发送结果
	private String code;

	// 返回消息
	private String Message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
