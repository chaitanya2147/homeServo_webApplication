package com.jsp.homeServo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeServo.dto.Work;
import com.jsp.homeServo.repository.WorkRepository;
@Repository
public class WorkDao {
	@Autowired
	private WorkRepository repository;

	public Work saveWork(Work work) {
		return repository.save(work);
		
	}
	
	public Work updateWork(Work work) {
		if(repository.findById(work.getId()).isPresent()) {
			
			Work db=repository.findById(work.getId()).get();
			if(work.getAddress()==null)
				work.setAddress(db.getAddress());
			if(work.getCost()==null) 
				work.setCost(db.getCost());
			if(work.getCustomer()==null)
				work.setCustomer(db.getCustomer());
			if(work.getType()==null)
				work.setType(db.getType());
			if(work.getVendors()==null)
				work.setVendors(db.getVendors());
			if(work.getStartDate()==null)
				work.setStartDate(db.getStartDate());
			if(work.getEndDate()==null)
				work.setEndDate(db.getEndDate());
			
			return repository.save(work);
			
		}
		else 
		{
			return null;	
			
		}
	}
	
	public Work getWorkById(int id) {
		if(repository.findById(id).isPresent()) {
			Work work=repository.findById(id).get();
			return work;
		}
		else
		return null;
	}
	
	public List<Work>listOfWorks(){
		List<Work>list=repository.ListOfWorks();
		if(list!=null)
		return list;
		else
			return null;
	}
	
}
