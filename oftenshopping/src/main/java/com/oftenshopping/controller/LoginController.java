package com.oftenshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.LoginDataDTO;
import com.oftenshopping.DTO.LoginResponseDTO;
import com.oftenshopping.service.LoginService;

@CrossOrigin("*")
@RestController
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping("/signin")
	public LoginResponseDTO signin(@RequestBody LoginDataDTO loginData) {
		return service.signin(loginData);
	}
	
}
