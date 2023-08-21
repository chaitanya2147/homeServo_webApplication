package com.jsp.homeServo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeServo.dto.Address;
import com.jsp.homeServo.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	AddressRepository repository;
	
	public Address updateAddress(Address address) {
		Address db=repository.findById(address.getId()).get();
		if(db!=null) {
			if(address.getD_no()==null) {
				address.setD_no(db.getD_no());
			}
			
			if(address.getDistrict()==null) {
				address.setDistrict(db.getDistrict());
			}
			if(address.getLandmark()==null) {
				address.setLandmark(db.getLandmark());
			}
			if(address.getPinCode()==0) {
				address.setPinCode(db.getPinCode());
			}
			if(address.getState()==null) {
				address.setState(db.getState());
			}
			if(address.getStreet()==null) {
				address.setStreet(db.getStreet());
			}
			repository.save(address);
			return address;
		}
		else
			return null;
	}
	
	public Address getAddressById(int id) {
		Address address=repository.findById(id).get();
		if(address!=null) {
			return address;
		}
		else {
			return null;
		}
	}

}




