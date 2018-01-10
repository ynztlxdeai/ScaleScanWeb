package com.moyansz.common;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * 流水号生成服务
 * @author HX1401028
 *
 */
public class OrderGenerateService {
	/**
	 * 流水号共用拼接符
	 */
	private static String comStr = "hxb";
	private static int random_range = 10;
	private static int random_digit = 6;
	
	private static String genOrderByType(String orderType){
		return orderDateTimePart(orderType);
	}
	
	/**
	 * 给流水号添加时间段
	 * @param orderType
	 * @return
	 */
	private static String orderDateTimePart(String orderType){
		StringBuffer order = new StringBuffer(orderType);
		order.append(DateUtil.formatDatayyMMDDHHMMSS(new Date()));
		return orderRandomPart(order);
	}
	
	/**
	 * 给流水号添加随机数部分
	 * @param order
	 * @return
	 */
	private static String orderRandomPart(StringBuffer order){
		Random rd = new Random();
		for(int i=0; i < random_digit; i ++){
			order.append(rd.nextInt(random_range));
		}
		return order.toString();
	}
	
	public static String getInvestNum()
	{
		 StringBuffer str = new StringBuffer(comStr);
		 Calendar now = Calendar.getInstance();
		 String year = now.get(Calendar.YEAR)+"";
		 int month = now.get(Calendar.MONTH)+1;
		 int day = now.get(Calendar.DATE);
		 str.append(year.substring(2,year.length())).append(month<10?"0"+month:month).append(day<10?"0"+day:day);
		 Random rd = new Random();
		 for(int i=0; i < 7; i ++){
			 str.append(rd.nextInt(9));
		 }
		return str.toString();
	}
	
	/**
	 * 生成投资流水号
	 * @return
	 */
	public static String genInvestOrder(){
		return genOrderByType(comStr + "_in");
	}
	/**
	 * 生成提现流水号
	 * @return
	 */
	public static String genWithdrawOrder(){
		return genOrderByType(comStr + "_wi");
	}
	/**
	 * 账户每日收益记录流水
	 * @return
	 */
	public static String genProfitdayOrder(){
		return genOrderByType(comStr + "_pr");
	}
	/**
	 * 生成返还本金流水号
	 * @return
	 */
	public static String genPrincipalReturnOrder(){
		return genOrderByType(comStr + "BJ");
	}
	/**
	 * 生成系统充值流水号
	 * @return
	 */
	public static String genRechargeOrder(){
		return genOrderByType(comStr + "re");
	}
	
	/**
	 * 生成系统充值流水号
	 * @return
	 */
	public static String genRewardsOrder(){
		return genOrderByType(comStr + "rw");
	}
	
	/**
	 * 生成手续费流水号
	 * @return
	 */
	public static String genFactorageOrder(){
		return genOrderByType(comStr + "fa");
	}
	/**
	 * 生成转让流水号
	 * @return
	 */
	public static String genTransferOrder(){
		return genOrderByType(comStr + "tr");
	}
	/**
	 * 生成赎回流水号
	 * @return
	 */
	public static String genSysBuyBackOrder(){
		return genOrderByType(comStr + "sbb");
	}
	
	/**
	 * 生成资金异动流水号
	 * @return
	 */
	public static String genBussNoOrder(){
		return genOrderByType(comStr + "bn");
	}
	
	/**
	 * 生成交易明细流水号
	 * @return
	 */
	public static String genTransBusNoOrder(){
		return genOrderByType(comStr + "tbn");
	}
	
	/**
	 * 生成推广收入流水号(商家角色)
	 * @return
	 */
	public static String genInviteAwardOrder(){
		return genOrderByType(comStr + "ha");
	}
	
	/**
	 * @function: 生成投资推荐奖励流水号 
	 * @return String   
	 * @exception 
	 * @author:张进飞   
	 * @since  1.0.0
	 */
	public static String genInvestrwardsOrder(){
		return genOrderByType(comStr + "inr");
	}
	

	/**
	 * @function:  推荐投资奖励排行榜流水号
	 * @return String   
	 * @exception 
	 * @author:朱瑜   
	 * @since  1.0.0
	 */
	public static String genRecommonInvestOrder(){
		return genOrderByType(comStr + "ri");
	}
	
}
