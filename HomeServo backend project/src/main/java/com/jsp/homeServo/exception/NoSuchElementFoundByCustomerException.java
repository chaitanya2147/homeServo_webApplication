package com.jsp.homeServo.exception;

import lombok.Data;

@Data
public class NoSuchElementFoundByCustomerException extends RuntimeException {
private String message="email is not found pls enter correct email";
public NoSuchElementFoundByCustomerException(String message) {
	super();
	this.message=message;
}
public NoSuchElementFoundByCustomerException() {
	super();
}
}
