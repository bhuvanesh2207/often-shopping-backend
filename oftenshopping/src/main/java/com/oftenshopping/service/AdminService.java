package com.oftenshopping.service;

import com.oftenshopping.DTO.AdminSignupDTO;
import com.oftenshopping.entity.Admin;

import jakarta.mail.MessagingException;

public interface AdminService {

	Admin getByCompanyEmail(String emial);

	void emailadminSignup(AdminSignupDTO adminDto) throws MessagingException;

	void rejected(Long id);

	void approved(Long id);

	void changePasswordotp(String email);


}
