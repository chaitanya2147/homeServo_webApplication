package com.jsp.homeServo.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import com.jsp.homeServo.dto.Vendor;
	import com.jsp.homeServo.service.VendorService;
	import com.jsp.homeServo.util.ResponseStructure;

	@RestController
	public class VendorController {
		@Autowired
		VendorService service;
		
		@PostMapping("/vendor")
		public ResponseEntity<ResponseStructure<Vendor>> saveVendor(@RequestBody Vendor vendor) {
			return service.saveVendor(vendor);
		}
		
		@PutMapping("/vendor")
		public ResponseEntity<ResponseStructure<Vendor>> updateVendor(@RequestBody Vendor vendor) {
			return service.updateVendor(vendor);
		}
		
		@GetMapping("/vendor")
		public ResponseEntity<ResponseStructure<Vendor>> getVendorById(@RequestParam int id){
			return service.getVendorById(id);
		}
		
		@GetMapping("/vendor/login")
		public ResponseEntity<ResponseStructure<Vendor>> login(@RequestParam String email,@RequestParam String password){
			return service.login(email,password);
		}
		
		@DeleteMapping("/vendor")
		public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(@RequestParam int id){
			return service.deleteVendor(id);
		}
		
		@GetMapping("/allvendor")
		public ResponseEntity<ResponseStructure<List<Vendor>>> getAllVendors(@RequestParam int c_id){
			return service.getAllVendors(c_id);
		}

	}


