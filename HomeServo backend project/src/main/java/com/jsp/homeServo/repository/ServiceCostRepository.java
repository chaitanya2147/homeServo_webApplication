package com.jsp.homeServo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeServo.dto.ServiceCost;

public interface ServiceCostRepository extends JpaRepository<ServiceCost, Integer> {

}
