package com.oftenshopping.service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.AdminOtpValidateDTO;
import com.oftenshopping.DTO.DeliveryOtpValidateDTO;
import com.oftenshopping.DTO.DeliverySetPasswordDTO;
import com.oftenshopping.DTO.SetPasswordDTO;
import com.oftenshopping.entity.Admin;
import com.oftenshopping.entity.DeliveryPerPassChangeOtp;
import com.oftenshopping.entity.DeliveryPerson;
import com.oftenshopping.entity.Otp;
import com.oftenshopping.repository.AdminRepository;
import com.oftenshopping.repository.DeliveryPerPassChangeOtpRepository;
import com.oftenshopping.repository.DeliveryPersonRepository;
import com.oftenshopping.repository.OtpRepository;

@Service
public class OtpServiceImplementation implements OtpService {

	@Autowired
	AdminRepository admRepo;

	@Autowired
	OtpRepository otpRepo;
	
	@Autowired
	EmailService eservice;
	
	@Autowired
	DeliveryPerPassChangeOtpRepository delpassRepo;
	
	@Autowired
	DeliveryPersonRepository delPerRepo;
	
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
	public boolean verifyOtp(AdminOtpValidateDTO otpdto) {
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

	public String sendDeliveryPerChangePassword(String email) {
		Random random =  new Random();
		int otp = random.nextInt(900000) + 100000;
		String strOtp = String.valueOf(otp);
		

		DeliveryPerPassChangeOtp delPerpass = new DeliveryPerPassChangeOtp();
		delPerpass.setEmail(email);
		delPerpass.setOtp(strOtp);
		delpassRepo.save(delPerpass);
		
		eservice.passChangeOtp(email, strOtp);
		
		return strOtp;
		
	}

	@Override
	public boolean deliveryperOtpVerification(DeliveryOtpValidateDTO otpvalid) {
	    DeliveryPerPassChangeOtp otp = delpassRepo.findByEmail(otpvalid.getDeliveryEmail());
	    if (otp != null && otp.getOtp().equals(otpvalid.getOtp())) {
	        delpassRepo.delete(otp); 
	        return true;           
	    } else {
	        return false;          
	    }
	}

	@Override
	public void deliveryPerResetPassword(DeliverySetPasswordDTO setpass) {
		Optional<DeliveryPerson> delPerOtp = delPerRepo.findByEmail(setpass.getDeliveryEmail());
		
		DeliveryPerson delPer = delPerOtp.get();
		String newPass = setpass.getNewPassword();
		delPer.setPassword(newPass);
		delPerRepo.save(delPer);
	}

	
	
}