/**
 *
 * BestUtil.java
 *
 * 版权所有：深圳市百思特信息科技有限公司.
 */
package com.moyansz.common;

import java.util.UUID;

/**
 * TODO Administrator Describe BestUtil
 * 
 * @author 邱继福
 *
 */
public class BestEduUtil
{
	public static String getGuid()
	{
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(BestEduUtil.getGuid());
	}
}
