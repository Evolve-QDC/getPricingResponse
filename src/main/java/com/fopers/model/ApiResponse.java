package com.fopers.model;

public class ApiResponse<T> {
	
	private int status;
	private String message;
	private Object result;
	private String exceptionOccured = null;
	private String exceptionMessage = null;
	
	public ApiResponse(int status, String message, Object result, String exceptionOccured, String exceptionMessage) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
		this.exceptionOccured = exceptionOccured;
		this.exceptionMessage = exceptionMessage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getExceptionOccured() {
		return exceptionOccured;
	}

	public void setExceptionOccured(String exceptionOccured) {
		this.exceptionOccured = exceptionOccured;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
	
	

}
