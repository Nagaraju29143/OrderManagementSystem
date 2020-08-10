package com.ordermanagementsystem.exception;

public class OrderNotFoundException extends RuntimeException {

	  private String errorMessage;
	  
	  

	    public OrderNotFoundException(String errorMessage) {
	        super(errorMessage);
	    }


}
