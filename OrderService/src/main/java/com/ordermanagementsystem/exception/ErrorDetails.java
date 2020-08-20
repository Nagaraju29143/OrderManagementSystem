package com.ordermanagementsystem.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
    
    private HttpStatus status;
	private  String msg;
	private List<String> errors;
	
	public ErrorDetails(String msg) {
		this.msg = msg;
	}
	
	public ErrorDetails(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.msg = message;
        this.errors = errors;
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
