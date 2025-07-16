package com.oftenshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.AddressDTO;
import com.oftenshopping.entity.Address;
import com.oftenshopping.service.AddressService;

@CrossOrigin("*")
@RestController
public class AddressController {
	
	@Autowired
	AddressService service;
	
	@PostMapping("/addAddress")
	public void addAddress(@RequestBody AddressDTO addressDto) {
		service.addAddress(addressDto);
	}
	
	//getting all address of the customer
	@GetMapping("/getAddress")
	public List<Address> getAddresses(@RequestParam Long customerId) {
	    return service.getAddress(customerId);
	}
	
	@GetMapping("/removeAddress")
	public void removeAddress(Long id) {
		service.removeAddress(id);
	}

}
