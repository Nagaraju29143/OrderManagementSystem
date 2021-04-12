package com.ordermanagementsystem.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	private List<String> errors;
	private  String msg;
    private HttpStatus status;
	
	
	
	public ErrorDetails(String msg) {
		this.msg = msg;
	}
	
	
	
	
	public ErrorDetails(List<String> errors, String msg, HttpStatus status) {
		super();
		this.errors = errors;
		this.msg = msg;
		this.status = status;
	}




	public String getMsg() {
		return msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public List<String> getErrors() {
		return errors;
	}

   
}
