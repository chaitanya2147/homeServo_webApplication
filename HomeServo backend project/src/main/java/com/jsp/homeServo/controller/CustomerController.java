package com.jsp.homeServo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeServo.dto.Customer;
import com.jsp.homeServo.service.CustomerService;
import com.jsp.homeServo.util.ResponseStructure;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping("/customerlogin")
	public ResponseEntity<ResponseStructure<Customer>>login(@RequestParam String email,@RequestParam String password){
		return service.login(email, password);
	}
	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>>getCustomerById(@PathVariable int id){
		return service.getCustomerById(id);
	}
	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>>deleteCustomer(@PathVariable int id){
		return service.deleteCustomerById(id);
		
	}
}
