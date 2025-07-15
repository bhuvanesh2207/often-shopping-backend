package com.oftenshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.AdminSignupDTO;
import com.oftenshopping.entity.Admin;
import com.oftenshopping.repository.AdminRepository;

import jakarta.mail.MessagingException;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	AdminRepository admRepo;

	@Autowired
	OtpService otpService;

	@Autowired
	EmailService eservice;

	@Override
	public void emailadminSignup(AdminSignupDTO adminDto) throws MessagingException {
		eservice.processSignup(adminDto);
	}

	@Override
	public Admin getByCompanyEmail(String email) {
		return admRepo.getByCompanyEmail(email);
	}

	@Override
	public void approved(Long id) {
		eservice.approved(id);
	}

	@Override
	public void rejected(Long id) {
		eservice.rejected(id);
	}

	@Override
	public void changePasswordotp(String email) {

		Admin admin = admRepo.getByCompanyEmail(email);
		// Call OTP generation from OtpService
		String otp = otpService.generatedOtp(email);

		// Call EmailService to send email
		eservice.sendOtpMail(admin.getCompanyEmail(), otp);
	}
	
}
