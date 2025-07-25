package com.oftenshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.AdminOrderedProductDTO;
import com.oftenshopping.DTO.AdminSignupDTO;
import com.oftenshopping.entity.Admin;
import com.oftenshopping.service.AdminService;

import jakarta.mail.MessagingException;

@CrossOrigin("*")
@RestController
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("/adminSignup")
	public void adminSignup(@RequestBody AdminSignupDTO adminDto) throws MessagingException {
		service.emailadminSignup(adminDto);
		System.out.println(adminDto);
	}

	@GetMapping("/approved")
	public void approved(@RequestParam  Long id) {
	    service.approved(id);
	}

	@GetMapping("/rejected")
	public void rejected(@RequestParam  Long id) {
		service.rejected(id);
	}
	
	@GetMapping("/changePasswordotp")
	public void changePassword(@RequestParam String email) {
	    service.changePasswordotp(email);
	}

	@GetMapping("/getByCompanyEmail")
	public Admin getByCompanyEmail(@RequestParam String email) {
		return service.getByCompanyEmail(email);
	}
	
	@GetMapping("/getOrderedProducts")
	public List<AdminOrderedProductDTO> getOrderedProducts (@RequestParam Long id){
		return service.getOrderedProducts(id);
	}
	
	@GetMapping("/confirmOrder")
	public void confrimOrder(@RequestParam Long id) {
		service.confrimOrder(id);
	}
}
