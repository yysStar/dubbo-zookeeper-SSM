package com.qiyun.exception;

public class ServiceException extends Exception {

	public ServiceException(String errorCode, String errorMesg) {
		super(errorMesg);
		this.errorCode = errorCode;
		this.errorMesg = errorMesg;
	}

	public ServiceException(String errorMesg) {
		super(errorMesg);
	}

	private String errorCode;
	private String errorMesg;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMesg() {
		return errorMesg;
	}

	public void setErrorMesg(String errorMesg) {
		this.errorMesg = errorMesg;
	}

}
