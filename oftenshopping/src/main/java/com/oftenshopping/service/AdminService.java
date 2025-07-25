package com.oftenshopping.service;

import java.util.List;

import com.oftenshopping.DTO.AdminOrderedProductDTO;
import com.oftenshopping.DTO.AdminSignupDTO;
import com.oftenshopping.entity.Admin;

import jakarta.mail.MessagingException;

public interface AdminService {

	Admin getByCompanyEmail(String emial);

	void emailadminSignup(AdminSignupDTO adminDto) throws MessagingException;

	void rejected(Long id);

	void approved(Long id);

	void changePasswordotp(String email);

	List<AdminOrderedProductDTO> getOrderedProducts(Long id);

	void confrimOrder(Long id);
}
