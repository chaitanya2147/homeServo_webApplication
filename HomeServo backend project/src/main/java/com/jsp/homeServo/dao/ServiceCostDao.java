package com.jsp.homeServo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeServo.dto.ServiceCost;
import com.jsp.homeServo.repository.ServiceCostRepository;
@Repository
public class ServiceCostDao {

	@Autowired
	private ServiceCostRepository repository;
	
	public ServiceCost saveServiceCost(ServiceCost cost) {
		return repository.save(cost);
		
	}
	public ServiceCost payServiceCost(ServiceCost cost) {
		ServiceCost cost2=repository.findById(cost.getId()).get();
		if(cost2!=null) {
			cost2.setMode(cost.getMode());
			return repository.save(cost);
		}
		else
		return null;
		
	}
	public ServiceCost getServiceCost(int id) {
		ServiceCost cost2=repository.findById(id).get();
		if(cost2!=null) {
			return cost2;
		}
		else
		return null;
		
	}
}
