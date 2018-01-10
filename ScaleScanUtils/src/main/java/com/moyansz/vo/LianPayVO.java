/**
 * Project Name:filmbThirdService File Name:LianPayVO.java Package
 * Name:com.filmb.third.pay.vo Date:2014年11月18日上午10:10:51 Copyright (c) 2014
 * 
 */
/**
 * @projectName:filmbThirdService
 * @packageName:com.filmb.third.pay.vo
 * @className:LianPayVO.java
 * 
 * @createTime:2014年11月18日-上午10:10:51
 * 
 * 
 */

package com.moyansz.vo;

import java.util.Date;

/**
 * 
 * @description: 连连支付实体对象
 * @fileName:LianPayVO.java
 * @createTime:2015年6月8日 下午2:44:41
 * @author:邱先锋
 * @version 1.0.0
 * 
 */
public class LianPayVO implements java.io.Serializable {

	private static final long serialVersionUID = 4637834691504407256L;

	private String BillNo;// 本地订单号

	private String Amount;// 充值金额

	private String rechargeMoney;// Appchonghijine

	private String user_id;// 用户ID

	private String userIp;// 本地系统IP

	private String aynPayFrontMer;// 异步通知地址

	private String payFrontMer;// 同步通知地址

	private String url_order;// 本地系统订单号详细地址

	private String id_no;// 用户身份证号

	private String acct_name;// 银行账号姓名

	private String no_agree;// 用户首次签约支付生成的协议号，可用于二次支付

	private String card_no;// 银行卡，首次使用输入卡号

	private String id_type;//

	public static final String SIGN_TYPE_RSA = "RSA";
	public static final String SIGN_TYPE_MD5 = "MD5";

	private String oid_partner; // 商户编号是商户在连连钱包支付平台上开设的商户号码，为18位数字，如：201304121000001004
	private String sign_type; // 参与签名 签名方式
	private String sign;

	private String busi_partner; // 虚拟商品销售：101001,实物商品销售：109001 //商户业务类型
	private String no_order; // 商户系统唯一订单号
	private String dt_order; // 格式：YYYYMMDDH24MISS 14位数字，精确到秒 //商户订单时间
	private String name_goods;// 商品名称
	private String info_order; // 订单描述
	private String money_order; // 该笔订单的资金总额，单位为RMB-元。大于0的数字，精确到小数点后两位。如：49.65
								// 交易金额
	private String notify_url; // 连连钱包支付平台在用户支付成功后通知商户服务端的地址 服务器异步通知 地址
	private String valid_order; // 订单有效期
	private String risk_item; // 风控字段

	private String shareing_data;

	private String force_bank;

	private String flag_modify;

	private String inverstOrderId;

	private Date registerTime;// 用户注册时间

	private String rechargeStatus;// 充值状态

	public LianPayVO(String billNo, String amount, String rechargeMoney, String user_id, String userIp,
			String aynPayFrontMer, String payFrontMer, String url_order, String id_no, String acct_name,
			String no_agree, String card_no, String id_type, String oid_partner, String sign_type, String sign,
			String busi_partner, String no_order, String dt_order, String name_goods, String info_order,
			String money_order, String notify_url, String valid_order, String risk_item, String shareing_data,
			String force_bank, String flag_modify, String inverstOrderId) {
		super();
		BillNo = billNo;
		Amount = amount;
		this.rechargeMoney = rechargeMoney;
		this.user_id = user_id;
		this.userIp = userIp;
		this.aynPayFrontMer = aynPayFrontMer;
		this.payFrontMer = payFrontMer;
		this.url_order = url_order;
		this.id_no = id_no;
		this.acct_name = acct_name;
		this.no_agree = no_agree;
		this.card_no = card_no;
		this.id_type = id_type;
		this.oid_partner = oid_partner;
		this.sign_type = sign_type;
		this.sign = sign;
		this.busi_partner = busi_partner;
		this.no_order = no_order;
		this.dt_order = dt_order;
		this.name_goods = name_goods;
		this.info_order = info_order;
		this.money_order = money_order;
		this.notify_url = notify_url;
		this.valid_order = valid_order;
		this.risk_item = risk_item;
		this.shareing_data = shareing_data;
		this.force_bank = force_bank;
		this.flag_modify = flag_modify;
		this.inverstOrderId = inverstOrderId;
	}

	public LianPayVO() {
		super();
	}

	public String getBillNo() {
		return BillNo;
	}

	public void setBillNo(String billNo) {
		BillNo = billNo;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getAynPayFrontMer() {
		return aynPayFrontMer;
	}

	public void setAynPayFrontMer(String aynPayFrontMer) {
		this.aynPayFrontMer = aynPayFrontMer;
	}

	public String getPayFrontMer() {
		return payFrontMer;
	}

	public void setPayFrontMer(String payFrontMer) {
		this.payFrontMer = payFrontMer;
	}

	public String getUrl_order() {
		return url_order;
	}

	public void setUrl_order(String url_order) {
		this.url_order = url_order;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getNo_agree() {
		return no_agree;
	}

	public void setNo_agree(String no_agree) {
		this.no_agree = no_agree;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBusi_partner() {
		return busi_partner;
	}

	public void setBusi_partner(String busi_partner) {
		this.busi_partner = busi_partner;
	}

	public String getNo_order() {
		return no_order;
	}

	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

	public String getDt_order() {
		return dt_order;
	}

	public void setDt_order(String dt_order) {
		this.dt_order = dt_order;
	}

	public String getName_goods() {
		return name_goods;
	}

	public void setName_goods(String name_goods) {
		this.name_goods = name_goods;
	}

	public String getInfo_order() {
		return info_order;
	}

	public void setInfo_order(String info_order) {
		this.info_order = info_order;
	}

	public String getMoney_order() {
		return money_order;
	}

	public void setMoney_order(String money_order) {
		this.money_order = money_order;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getValid_order() {
		return valid_order;
	}

	public void setValid_order(String valid_order) {
		this.valid_order = valid_order;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

	public String getRechargeMoney() {
		return rechargeMoney;
	}

	public void setRechargeMoney(String rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	public String getShareing_data() {
		return shareing_data;
	}

	public void setShareing_data(String shareing_data) {
		this.shareing_data = shareing_data;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getForce_bank() {
		return force_bank;
	}

	public void setForce_bank(String force_bank) {
		this.force_bank = force_bank;
	}

	public String getFlag_modify() {
		return flag_modify;
	}

	public void setFlag_modify(String flag_modify) {
		this.flag_modify = flag_modify;
	}

	public String getInverstOrderId() {
		return inverstOrderId;
	}

	public void setInverstOrderId(String inverstOrderId) {
		this.inverstOrderId = inverstOrderId;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getRechargeStatus() {
		return rechargeStatus;
	}

	public void setRechargeStatus(String rechargeStatus) {
		this.rechargeStatus = rechargeStatus;
	}

}
