package com.jsp.homeServo.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.homeServo.util.ResponseStructure;
@ControllerAdvice
public class ExceptionHandlerForHomeServo extends ResponseEntityExceptionHandler {
	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>>SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
   ResponseStructure<String> structure=new ResponseStructure<String>();
	structure.setMessage(ex.getMessage());
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setData("you can not perform this operation");
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	
}
	@ExceptionHandler(EmailNotFoundForCustomer.class)
	public ResponseEntity<ResponseStructure<String>>emailNotFoundForCustomer(EmailNotFoundForCustomer ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("check rey properly...1");
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
}