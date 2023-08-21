package com.jsp.homeServo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeServo.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {


}
