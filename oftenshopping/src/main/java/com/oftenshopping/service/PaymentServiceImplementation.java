package com.oftenshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.repository.PaymentRepository;

@Service
public class PaymentServiceImplementation implements PaymentService{

	@Autowired
	PaymentRepository repo;

}
