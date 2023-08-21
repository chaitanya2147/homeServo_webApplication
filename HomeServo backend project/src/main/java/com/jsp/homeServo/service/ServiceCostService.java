package com.jsp.homeServo.service;

import java.util.Date;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.homeServo.dao.CustomerDao;
import com.jsp.homeServo.dao.ServiceCostDao;
import com.jsp.homeServo.dao.VendorDao;
import com.jsp.homeServo.dao.WorkDao;
import com.jsp.homeServo.dto.Customer;
import com.jsp.homeServo.dto.ServiceCost;
import com.jsp.homeServo.dto.Vendor;
import com.jsp.homeServo.dto.Work;
import com.jsp.homeServo.exception.NoSuchElementFoundByCustomerException;
import com.jsp.homeServo.exception.NoSuchElementFoundByVendorException;
import com.jsp.homeServo.exception.NoSuchElementFoundForCostException;
import com.jsp.homeServo.exception.NoSuchElementFoundForWork;
import com.jsp.homeServo.util.ResponseStructure;
@Service
public class ServiceCostService {

	@Autowired
	private ServiceCostDao dao;
	@Autowired
	private VendorDao vendorDao;
	@Autowired
	private WorkDao workDao;
	@Autowired
	private ServiceCost cost;
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<ServiceCost>>saveCost(int v_id,int w_id){
		Vendor vendor=vendorDao.getVendorById(v_id);
		if(vendor!=null) {
			Work work=workDao.getWorkById(w_id);
			if(work!=null) {
				double costPerDay=vendor.getCostPerDay();
				
				Date start=work.getStartDate();
				Date end=work.getEndDate();
				
				Duration duration=Duration.between(start.toInstant(), end.toInstant());
				int days=(int) duration.toDays();
				cost.setDays(days);
				cost.setTotalAmount(days*costPerDay);
				
				ServiceCost cost2=dao.saveServiceCost(cost);
				List<ServiceCost> list=new ArrayList<ServiceCost>();
				list.add(cost2);
				list.addAll(vendor.getCosts());
				
				vendor.setCosts(list);
				vendorDao.updateVendor(vendor);
				workDao.updateWork(work);
				
				ResponseStructure<ServiceCost> structure=new ResponseStructure<ServiceCost>();
				structure.setData(cost2);
				structure.setMessage("cost saved successfully");
				structure.setStatus(HttpStatus.CREATED.value());
				
				return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
				
				
			}
			else
				throw new NoSuchElementFoundForWork("no work found based on vendor");
		}
		else
			throw new NoSuchElementFoundByVendorException("no vendor found based on id provided");
	}
	
	public ResponseEntity<ResponseStructure<ServiceCost>> payment(int c_id, ServiceCost cost){
		Customer customer=customerDao.getCustomerById(c_id);
		if(customer!=null) {
			ServiceCost cost2=dao.getServiceCost(cost.getId());
			
			if(cost2!=null) {
				ResponseStructure<ServiceCost> structure=new ResponseStructure<>();
				structure.setData(dao.payServiceCost(cost));
				structure.setMessage("payment saved succefully");
				structure.setStatus(HttpStatus.FOUND.value());
				
				return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.FOUND);
			}
			else 
				
				throw new NoSuchElementFoundForCostException("no cost present right now");
		}
			
		else 
			throw new NoSuchElementFoundByCustomerException("No Customer found ");
				
			}

		}