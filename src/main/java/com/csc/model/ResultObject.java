package com.csc.model;

public class ResultObject {
	private Object result;
	private Object detail;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}

	public ResultObject(Object result, Object detail) {
		super();
		this.result = result;
		this.detail = detail;
	}

	public ResultObject() {
		super();
	}

}
