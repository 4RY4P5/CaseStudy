package com.example.loanService_r2dbc.model;

public class ResponseMsg {
	private String status;
	private long id;
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id2) {
		this.id = id2;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseMsg(String status, long id, String message) {
		super();
		this.status = status;
		this.id = id;
		this.message = message;
	}
	
	public ResponseMsg() {
		
	}
}
