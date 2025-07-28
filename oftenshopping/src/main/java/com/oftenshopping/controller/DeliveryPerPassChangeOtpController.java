package com.oftenshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.service.DeliveryPerPassChangeOtpService;

@CrossOrigin("*")
@RestController
public class DeliveryPerPassChangeOtpController {

	@Autowired
	DeliveryPerPassChangeOtpService service;
}
