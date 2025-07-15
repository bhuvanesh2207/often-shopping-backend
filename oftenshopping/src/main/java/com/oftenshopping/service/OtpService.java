package com.oftenshopping.service;

import com.oftenshopping.DTO.OtpValidateDTO;
import com.oftenshopping.DTO.SetPasswordDTO;

public interface OtpService {
	String generatedOtp(String email);

	boolean verifyOtp(OtpValidateDTO otpdto);

	void resetPasswordForEmail(SetPasswordDTO setpass);

	

	

}
