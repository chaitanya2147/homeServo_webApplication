package com.jsp.homeServo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeServo.dto.ServiceCost;
import com.jsp.homeServo.service.ServiceCostService;
import com.jsp.homeServo.util.ResponseStructure;

@RestController
public class ServiceCostController {
@Autowired
private ServiceCostService service;

@PostMapping("/cost")
public ResponseEntity<ResponseStructure<ServiceCost>>saveCost(@RequestParam int v_id,@RequestParam int w_id){
	return service.saveCost(v_id,w_id);
	
}
@PutMapping("/cost")
public ResponseEntity<ResponseStructure<ServiceCost>>payment(@RequestParam int c_id,@RequestBody ServiceCost cost){
	return service.payment(c_id,cost);
}
}