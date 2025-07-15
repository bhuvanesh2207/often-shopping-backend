package com.oftenshopping.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.OtpValidateDTO;
import com.oftenshopping.DTO.SetPasswordDTO;
import com.oftenshopping.entity.Admin;
import com.oftenshopping.entity.Otp;
import com.oftenshopping.repository.AdminRepository;
import com.oftenshopping.repository.OtpRepository;

@Service
public class OtpServiceImplementation implements OtpService {

	@Autowired
	AdminRepository admRepo;

	@Autowired
	OtpRepository otpRepo;
	
	@Autowired
	EmailService eservice;
	@Override
	public String generatedOtp(String email) {
		
	    Admin admin = admRepo.getByCompanyEmail(email);

	    if (admin == null) {
	        throw new RuntimeException("Admin not found for email: " + email);
	    }

	    // Generate OTP
	    SecureRandom random = new SecureRandom();
	    int num = 100000 + random.nextInt(900000);
	    String otp = String.valueOf(num);

	    // Save OTP
	    Otp ot = new Otp();
	    ot.setEmail(admin.getCompanyEmail());
	    ot.setOtp(otp);
	    otpRepo.save(ot);
	    
	    eservice.sendOtpMail(admin.getCompanyEmail(), otp);
	    return otp;
	}

	@Override
	public boolean verifyOtp(OtpValidateDTO otpdto) {
		Otp otp = otpRepo.findByEmail(otpdto.getEmail());
		SetPasswordDTO setpass = new SetPasswordDTO();
		if (otp != null && otp.getOtp().equals(otpdto.getOtp())) {
			 otpRepo.delete(otp); //deleting otp after verification
			return true;
		} else {
			throw new RuntimeException("Invalid OTP");
		}
	}

	public void resetPasswordForEmail(SetPasswordDTO setpass) {
		Admin admin = admRepo.getByCompanyEmail(setpass.getEmail());

		if (admin == null) {
			throw new RuntimeException("Admin not found with email: " + setpass.getEmail());
		}

		String newpas = setpass.getNewPassword();
		admin.setPassword(newpas);
		admRepo.save(admin);
	}

}
