package com.rushikesh.sms.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rushikesh.sms.exception.ProductNotFoundException;
import com.rushikesh.sms.exception.ProductNotFoundException.CustomException;
import com.rushikesh.sms.exceptionerror.ErrorResponse;


@RestControllerAdvice
public class ExceptionHandler2 {
	
	 @ExceptionHandler(ProductNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
	        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
	        ErrorResponse errorResponse = new ErrorResponse("page not found with this offset.", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	 @ExceptionHandler(CustomException.class)
	    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
	        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }
	
	
	

	
}
