package com.ordermanagementsystem.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler   {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleOrderNotFoundException(OrderNotFoundException ex) {
		
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DaoException.class)
	public ResponseEntity<ErrorDetails> handleDaoException(DaoException ex) {
		
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                 HttpHeaders headers, HttpStatus status, WebRequest request) {
		 
		 List<String> errorList = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()) .collect(Collectors.toList());
	        
		 ErrorDetails errorDetails = new ErrorDetails(errorList,"Order validation failed",HttpStatus.BAD_REQUEST );
		 
	     return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
	 }

}
