package com.oftenshopping.service;

import com.oftenshopping.DTO.AdminOtpValidateDTO;
import com.oftenshopping.DTO.SetPasswordDTO;

public interface OtpService {
	String generatedOtp(String email);

	boolean verifyOtp(AdminOtpValidateDTO otpdto);

	void resetPasswordForEmail(SetPasswordDTO setpass);

}