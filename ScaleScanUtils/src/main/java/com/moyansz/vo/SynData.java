package com.moyansz.vo;

import java.io.Serializable;

/**
 * 
 * @description:
 * @fileName:SynData.java
 * @createTime:2015年6月10日 下午6:54:11
 * @author:钟赛
 * @version 1.0.0
 *
 */
public class SynData implements Serializable {

	private static final long serialVersionUID = 1L;
	private Account data;
	private Integer uid;
	private Integer update;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getUpdate() {
		return update;
	}

	public void setUpdate(Integer update) {
		this.update = update;
	}

	public Account getData() {
		return data;
	}

	public void setData(Account data) {
		this.data = data;
	}

}
