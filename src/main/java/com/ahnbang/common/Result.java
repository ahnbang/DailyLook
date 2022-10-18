package com.ahnbang.common;


public class Result<T> {
	private int statusCode; // 1,-1
	private T data;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [statusCode=" + statusCode + ", data=" + data + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
