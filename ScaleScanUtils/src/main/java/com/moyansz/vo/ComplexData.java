package com.moyansz.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 账号网关系统响应数据对象
 * 
 * @ClassName: ComplexData
 * @Description:
 * @author 刘恒
 * @date 2015年1月20日 上午9:10:34
 * @param <T>
 */
public class ComplexData<T> implements Serializable {

	public com.moyansz.vo.ResponseData<T> responseData;

	// 字符串
	private String str;

	// map对象
	private Map<String, T> map;

	// list对象
	private List<T> list;

	// 某个对象
	private T obj;

	// 布尔对象
	private Boolean booleanObj;

	// 是否成功
	private boolean ok;

	// 异常
	private String exception;

	// 返回码
	private String resCode;

	public ComplexData() {
		super();
	}

	public com.moyansz.vo.ResponseData<T> getResponseData() {
		return responseData;
	}

	public void setResponseData(com.moyansz.vo.ResponseData<T> responseData) {
		this.responseData = responseData;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Map<String, T> getMap() {
		return map;
	}

	public void setMap(Map<String, T> map) {
		this.map = map;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Boolean getBooleanObj() {
		return booleanObj;
	}

	public void setBooleanObj(Boolean booleanObj) {
		this.booleanObj = booleanObj;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	@Override
	public String toString() {
		return "ComplexData [responseData=" + responseData + ", str=" + str + ", map=" + map + ", list=" + list
				+ ", obj=" + obj + ", booleanObj=" + booleanObj + ", ok=" + ok + ", exception=" + exception
				+ ", resCode=" + resCode + "]";
	}

}
