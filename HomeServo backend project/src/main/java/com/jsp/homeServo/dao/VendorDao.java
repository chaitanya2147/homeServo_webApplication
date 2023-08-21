package com.jsp.homeServo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeServo.dto.Vendor;
import com.jsp.homeServo.repository.VendorRepository;

@Repository
public class VendorDao {
@Autowired
private VendorRepository repository;

public Vendor saveVendor(Vendor vendor) {
	return repository.save(vendor);
}
public Vendor getVendorById(int id) {
	if(repository.findById(id).isPresent()) {
		Vendor vendor=repository.findById(id).get();
		return vendor;
	}
	else {
		return null;
	}
}
public Vendor updateVendor(Vendor vendor) {
	if(repository.findById(vendor.getId()).isPresent()) {
		Vendor db=repository.findById(vendor.getId()).get();
		if(vendor.getPassword()==null) {
			vendor.setPassword(db.getPassword());
		}
		
	}
	return repository.save(vendor);
}
public Vendor deleteVendor(int id) {
	Optional<Vendor> optional=repository.findById(id);
	if(optional.isPresent()) {
		repository.delete(optional.get());
		return optional.get();
	
	}
	else {
		return null;
	}
}
public List<Vendor>getAllVendors(){
	return repository.findAll();
}
public Vendor getVendorByEmail(String email) {
	Vendor vendor= repository.findByEmail(email);
	if(vendor!=null) {
		return vendor;
	}
	else {
		return null;
	}
}

public Vendor deleteVendorByEmail(String email) {
	Vendor vendor=repository.findByEmail(email);
	if(vendor!=null) {
		repository.delete(vendor);
	}
	return null;

}

}




















