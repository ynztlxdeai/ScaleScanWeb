package com.moyansz.vo;

import java.io.Serializable;

public class BaseRsp implements Serializable {

	private static final long serialVersionUID = 979467641371124096L;
	private String exception;
	private String exceptionCode;
	private boolean ok;
	
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
