package com.oftenshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.repository.DeliveryPerPassChangeOtpRepository;

@Service
public class DeliveryPerPassChangeOtpServiceImplementation implements DeliveryPerPassChangeOtpService{
	
	@Autowired
	DeliveryPerPassChangeOtpRepository repo;
}
