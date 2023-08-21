package com.jsp.homeServo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeServo.dao.AddressDao;
import com.jsp.homeServo.dto.Address;
import com.jsp.homeServo.exception.NoSuchElementFoundFOrAddressException;
import com.jsp.homeServo.util.ResponseStructure;
@RestController
public class AddressService {
	@Autowired
	AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address){
		Address address2=dao.getAddressById(address.getId());
		if(address2!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setData(dao.updateAddress(address));
			structure.setMessage("addresss updated succefully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundFOrAddressException("no address found ");
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		Address address=dao.getAddressById(id);
		if(address!=null) {
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("address fetched succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}
		else
			throw new NoSuchElementFoundFOrAddressException("no address found based on id");
	}
}


