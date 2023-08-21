package com.jsp.homeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundForCostException extends RuntimeException {
	private String message;

	public NoSuchElementFoundForCostException(String message) {
		super();
		this.message = message;
	}
	
}
