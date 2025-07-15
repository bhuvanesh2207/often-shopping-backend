package com.oftenshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.EmailRequestDTO;
import com.oftenshopping.DTO.OtpValidateDTO;
import com.oftenshopping.DTO.SetPasswordDTO;
import com.oftenshopping.service.OtpService;

@CrossOrigin("*")
@RestController
public class OtpController {
	
	@Autowired
	OtpService service;
	
	@PostMapping("/generatedOtp")
	public String generatedOtp(@RequestBody EmailRequestDTO emailRequest) {
		System.out.println(emailRequest);
		return service.generatedOtp(emailRequest.getEmail());
	}
	
	@PostMapping("/verifyOtp")
	public void verifyOtp(@RequestBody OtpValidateDTO otpdto) {
		service.verifyOtp(otpdto);
	}
	
	@PostMapping("/setPassword")
	public void resetPasswordForEmail(@RequestBody SetPasswordDTO setpass) {
		service.resetPasswordForEmail(setpass);
	}
}
