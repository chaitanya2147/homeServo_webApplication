package com.jsp.homeServo.exception;

public class EmailNotFoundForCustomer extends RuntimeException{
	private String message="email is not found pls enter correct email";
	public EmailNotFoundForCustomer(String message) {
		super();
		this.message=message;
	}
	public EmailNotFoundForCustomer() {
		super();
	}

}
