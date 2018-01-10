package com.moyansz.vo;

import java.math.BigDecimal;

/**
 * 当日、当月 限制金额、已充值金额对象
 * 
 * @time 2015年下午3:47:01
 * @author duyubo
 */
public class LimitMoneyVO implements java.io.Serializable {

	private static final long serialVersionUID = 2009383872998161577L;

	/**
	 * 单笔充值限制金额
	 */
	private BigDecimal soloLimitAmt;

	/**
	 * 单日充值金额限制
	 */
	private BigDecimal dayLimitAmt;

	/**
	 * 单月充值金额限制
	 */
	private BigDecimal monthLimitAmt;

	/**
	 * 客户当日充值金额累计
	 */
	private BigDecimal dayRechargeAmt;

	/**
	 * 客户当月充值金额累计
	 */
	private BigDecimal monthRechargeAmt;

	/**
	 * 描述
	 */
	private String description;

	public LimitMoneyVO() {
		super();
	}

	/**
	 * @param soloLimitAmt
	 * @param dayLimitAmt
	 * @param monthLimitAmt
	 * @param dayRechargeAmt
	 * @param monthRechargeAmt
	 * @param description
	 */
	public LimitMoneyVO(BigDecimal soloLimitAmt, BigDecimal dayLimitAmt, BigDecimal monthLimitAmt,
			BigDecimal dayRechargeAmt, BigDecimal monthRechargeAmt, String description) {
		super();
		this.soloLimitAmt = soloLimitAmt;
		this.dayLimitAmt = dayLimitAmt;
		this.monthLimitAmt = monthLimitAmt;
		this.dayRechargeAmt = dayRechargeAmt;
		this.monthRechargeAmt = monthRechargeAmt;
		this.description = description;
	}

	/**
	 * @return the soloLimitAmt
	 */
	public BigDecimal getSoloLimitAmt() {
		return soloLimitAmt;
	}

	/**
	 * @param soloLimitAmt
	 *            the soloLimitAmt to set
	 */
	public void setSoloLimitAmt(BigDecimal soloLimitAmt) {
		this.soloLimitAmt = soloLimitAmt;
	}

	/**
	 * @return the dayLimitAmt
	 */
	public BigDecimal getDayLimitAmt() {
		return dayLimitAmt;
	}

	/**
	 * @param dayLimitAmt
	 *            the dayLimitAmt to set
	 */
	public void setDayLimitAmt(BigDecimal dayLimitAmt) {
		this.dayLimitAmt = dayLimitAmt;
	}

	/**
	 * @return the monthLimitAmt
	 */
	public BigDecimal getMonthLimitAmt() {
		return monthLimitAmt;
	}

	/**
	 * @param monthLimitAmt
	 *            the monthLimitAmt to set
	 */
	public void setMonthLimitAmt(BigDecimal monthLimitAmt) {
		this.monthLimitAmt = monthLimitAmt;
	}

	/**
	 * @return the dayRechargeAmt
	 */
	public BigDecimal getDayRechargeAmt() {
		return dayRechargeAmt;
	}

	/**
	 * @param dayRechargeAmt
	 *            the dayRechargeAmt to set
	 */
	public void setDayRechargeAmt(BigDecimal dayRechargeAmt) {
		this.dayRechargeAmt = dayRechargeAmt;
	}

	/**
	 * @return the monthRechargeAmt
	 */
	public BigDecimal getMonthRechargeAmt() {
		return monthRechargeAmt;
	}

	/**
	 * @param monthRechargeAmt
	 *            the monthRechargeAmt to set
	 */
	public void setMonthRechargeAmt(BigDecimal monthRechargeAmt) {
		this.monthRechargeAmt = monthRechargeAmt;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
