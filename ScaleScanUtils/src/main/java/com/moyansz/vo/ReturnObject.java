package com.moyansz.vo;

import java.io.Serializable;

public class ReturnObject implements Serializable {

	private static final long serialVersionUID = 979467641371124096L;
	private int code; // 0表成功，1表失败
	private String msg; // 失败原因
	private Object data; // 数据体

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
