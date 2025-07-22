package com.oftenshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.CustomerDTO;
import com.oftenshopping.entity.Customer;
import com.oftenshopping.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("/customerSignup")
	public String customerSignUp(@RequestBody CustomerDTO custdto) {
		service.customerSignUp(custdto);
		return "success";
	}
	
	@GetMapping("/getCustomerByEmail")
	public Customer getCustomerByEmail(@RequestParam String email) {
		return service.getByEmail(email);
	}
}
