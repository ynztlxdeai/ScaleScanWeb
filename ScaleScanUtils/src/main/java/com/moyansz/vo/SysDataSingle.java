package com.moyansz.vo;

import java.util.List;

/**
 * 
 * @description:
 * @fileName:SysDataSingle.java
 * @createTime:2015年6月10日 下午6:54:51
 * @author:钟赛
 * @version 1.0.0
 *
 */
public class SysDataSingle {
	private List<SynData> syn_data;

	/**
	 * syn_data
	 * 
	 * @return the syn_data
	 * @since 1.0.0
	 */

	public List<SynData> getSyn_data() {
		return syn_data;
	}

	/**
	 * @param syn_data
	 *            the syn_data to set
	 */
	public void setSyn_data(List<SynData> syn_data) {
		this.syn_data = syn_data;
	}

	private Integer time;

	/**
	 * time
	 * 
	 * @return the time
	 * @since 1.0.0
	 */

	public Integer getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Integer time) {
		this.time = time;
	}

}
