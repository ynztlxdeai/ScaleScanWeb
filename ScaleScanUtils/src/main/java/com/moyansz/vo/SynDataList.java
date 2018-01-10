package com.moyansz.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @description:
 * @fileName:SynDataList.java
 * @createTime:2015年6月10日 下午6:54:43
 * @author:钟赛
 * @version 1.0.0
 *
 */
public class SynDataList implements Serializable {

	private static final long serialVersionUID = 1L;
	private List syn_data;//

	public List getSyn_data() {
		return syn_data;
	}

	public void setSyn_data(List syn_data) {
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
