package com.jsp.homeServo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.homeServo.dao.CustomerDao;
import com.jsp.homeServo.dto.Customer;
import com.jsp.homeServo.exception.EmailNotFoundForCustomer;
import com.jsp.homeServo.exception.NoSuchElementFoundByCustomerException;
import com.jsp.homeServo.util.ResponseStructure;
 @RestController
public class CustomerService {
@Autowired
private CustomerDao dao;

public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer){
	ResponseStructure<Customer>structure=new ResponseStructure();
	structure.setData(dao.saveCustomer(customer));
	structure.setMessage("customer saved successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	
	return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
	
}
public ResponseEntity<ResponseStructure<Customer>>login(String email,String password){
	Customer customer=dao.getCustomerByEmail(email);
	if(customer!=null) {
		
		if(customer.getPassword().equals(password)) {
			ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
			structure.setData(dao.saveCustomer(customer));
			structure.setMessage("customer login successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			
		}
		else
			return null;
	}
	else
		throw new EmailNotFoundForCustomer("boss give correct email.....");
}
public ResponseEntity<ResponseStructure<Customer>>getCustomerById(int id){
	Customer db=dao.getCustomerById(id);
	ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
	if(db!=null) {
		responseStructure.setMessage("successfully customer is found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(db);
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure,HttpStatus.FOUND);
	}
	else {
              throw new NoSuchElementFoundByCustomerException("customer id is not found for your id"+ id +"to display");
     
	}
}
public ResponseEntity<ResponseStructure<Customer>>deleteCustomerById(int id){
	Customer db=dao.deleteCustomer(id);
	ResponseStructure<Customer> responseStructure=new ResponseStructure<Customer>();
	if(db!=null) {
		System.out.println(db);
	}
	return null;
}
public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer){
	ResponseStructure<Customer> structure=new ResponseStructure<>();
	Customer c=dao.getCustomerById(customer.getId());
	if(c!=null) {
	structure.setData(dao.saveCustomer(customer));
	structure.setMessage("customer data updated successfully");
	structure.setStatus(HttpStatus.FOUND.value());
	
	return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
	}
	else
	{
		throw new NoSuchElementFoundByCustomerException("customer is not found for your id "+customer.getId()+" to update");
	}
}
 }
 