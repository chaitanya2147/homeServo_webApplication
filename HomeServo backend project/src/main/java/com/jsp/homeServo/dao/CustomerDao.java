package com.jsp.homeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeServo.dto.Customer;
import com.jsp.homeServo.repository.CustomerRepository;

@Repository
public class CustomerDao {
@Autowired
private CustomerRepository repository;

public Customer saveCustomer(Customer customer) {
	return repository.save(customer);
	
}
public Customer updateCustomer(Customer customer) {
	Customer customer2=repository.findById(customer.getId()).get();
	if(customer2!=null) {
		if(customer.getName()==null) {
			customer.setName(customer2.getName());
		}
		if(customer.getPhone()==0) {
			customer.setPhone(customer2.getPhone());
		}
		if(customer.getFamilyCount()==0) {
			customer.setFamilyCount(customer2.getFamilyCount());
		}
		if(customer.getEmail()==null) {
			customer.setEmail(customer2.getEmail());
		}
		if(customer.getPassword()==null) {
			customer.setPassword(customer2.getPassword());
		}
		if(customer.getWorks()==null) {
			customer.setWorks(customer2.getWorks());
		}
		if(customer.getAddress()==null) {
			customer.setAddress(customer2.getAddress());
		}
		repository.save(customer);
		return customer;
	}
	else {
		return null;
	}
}
 public Customer getCustomerByEmail(String email) {
	 Customer customer=repository.findByEmail(email);
	 if(customer!=null) {
		 return customer;
	 }
	 return null;
	 
 }
 public Customer deleteCustomer(int id) {
	 Optional<Customer> optional=repository.findById(id);
	 if(optional.isPresent()) {
		 repository.deleteById(id);
		 return optional.get();
		 }
	 else {
		 
	return null;
	
	 } 
 }
 public Customer getCustomerById(int id) {
	 if(repository.findById(id).isPresent()) {
		 Customer customer=repository.findById(id).get();
		 return customer;
		 
	 }
	 else {
		 return null;
	 }
 }
 public List<Customer>getAllCustomer(){
	return repository.findAll();
	 
 }
 
	
	public Customer deleteCustomerByEmail(String email) {
		Customer customer=repository.findByEmail(email);
		if(customer!=null) {
			 repository.delete(customer);
		}
	return null;
	}
}
