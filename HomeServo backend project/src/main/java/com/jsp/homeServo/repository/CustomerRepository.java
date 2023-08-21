package com.jsp.homeServo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeServo.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String email);



}
