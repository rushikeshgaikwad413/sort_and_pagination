package com.rushikesh.sms.exceptionerror;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	 private String message;
	 private int statusCode;

	

}
