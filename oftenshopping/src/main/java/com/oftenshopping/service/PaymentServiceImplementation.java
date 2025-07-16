package com.oftenshopping.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.PaymentDTO;
import com.oftenshopping.entity.Customer;
import com.oftenshopping.entity.Payment;
import com.oftenshopping.repository.CustomerRepository;
import com.oftenshopping.repository.PaymentRepository;

@Service
public class PaymentServiceImplementation implements PaymentService{

	@Autowired
	PaymentRepository repo;

	@Autowired
	CustomerRepository cusrepo;
	
	@Override
	public void savePayment(PaymentDTO payDto) {
		Payment payment = new Payment();
		payment.setAmount(payDto.getAmount());
		payment.setEmail(payDto.getEmail());
		payment.setPaymentId(payDto.getPaymentId());
		payment.setPaymentDate(LocalDateTime.now());

		Customer customer = cusrepo.findByEmail(payDto.getEmail());
		payment.setCustomer(customer);
		repo.save(payment);
	}
	
	
}
