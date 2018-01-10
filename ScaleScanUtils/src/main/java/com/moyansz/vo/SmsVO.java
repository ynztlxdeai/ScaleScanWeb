/**  
 * Project Name:filmbThirdService  
 * File Name:SmsVO.java  
 * Package Name:com.filmb.third.sms.vo  
 * Date:2014年11月13日下午2:33:56  
 * Copyright (c) 2014  
 *  
*/
/**   
 * @projectName:filmbThirdService  
 * @packageName:com.filmb.third.sms.vo  
 * @className:SmsVO.java  
 *   
 * @createTime:2014年11月13日-下午2:33:56  
 *  
 *    
 */

package com.moyansz.vo;

/**
 * @description: 短信对象
 * @fileName:SmsVO.java
 * @createTime:2014年11月13日 下午2:33:56
 * @author:肖震
 * @version 1.0.0
 * 
 */
public class SmsVO implements java.io.Serializable {
	/**
	 * serialVersionUID:TODO
	 * 
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = -3705207123222779797L;

	private String mobile;

	private String content;

	String account;

	String password;

	String invokerID;

	String businessType;

	String sendType;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInvokerID() {
		return invokerID;
	}

	public void setInvokerID(String invokerID) {
		this.invokerID = invokerID;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
