package com.jsp.homeServo.exception;

import lombok.Data;

@Data
public class PasswordNotFoundForVendorException extends RuntimeException {
	private String message;

	public PasswordNotFoundForVendorException(String message) {
		super();
		this.message = message;
	}
	
	
}
