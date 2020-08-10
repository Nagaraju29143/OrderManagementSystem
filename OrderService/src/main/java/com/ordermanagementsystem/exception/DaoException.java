package com.ordermanagementsystem.exception;

public class DaoException extends RuntimeException{
	
	  private String errorMessage;

	  public DaoException(String errorMessage, Throwable cause) {
	        super(errorMessage, cause);
	    }

}
