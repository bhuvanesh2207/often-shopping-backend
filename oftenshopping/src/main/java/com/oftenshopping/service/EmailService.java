package com.oftenshopping.service;

import com.oftenshopping.DTO.AdminSignupDTO;

import jakarta.mail.MessagingException;

public interface EmailService {

	void processSignup(AdminSignupDTO adminDto) throws MessagingException;

	void rejected(Long id);	

	void approved(Long id);

	void sendOtpMail(String email, String otp);

	
}
