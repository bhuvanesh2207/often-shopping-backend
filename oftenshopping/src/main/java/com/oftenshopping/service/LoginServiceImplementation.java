package com.oftenshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.LoginDataDTO;
import com.oftenshopping.DTO.LoginResponseDTO;
import com.oftenshopping.entity.Admin;
import com.oftenshopping.entity.Customer;
import com.oftenshopping.entity.DeliveryPerson;

@Service
public class LoginServiceImplementation implements LoginService {

	@Autowired
	AdminService adService;

	@Autowired
	CustomerService cusService;

	@Autowired
	DeliveryPersonService delService;

	@Override
	public LoginResponseDTO signin(LoginDataDTO loginData) {
		Admin admin = adService.getByCompanyEmail(loginData.getEmail());
		Customer cus = cusService.getByEmail(loginData.getEmail());
		Optional<DeliveryPerson> del = delService.getByDeliveryEmail(loginData.getEmail());
		if (admin != null && admin.getCompanyEmail().equals(loginData.getEmail())
				&& admin.getPassword().equals(loginData.getPassword())) {
			System.out.println("Admin login: id=" + admin.getId() + ", email=" + admin.getCompanyEmail());
			return new LoginResponseDTO("admin", admin.getId(), admin.getCompanyEmail());

		} else if (cus != null && cus.getEmail().equals(loginData.getEmail())
				&& cus.getPassword().equals(loginData.getPassword())) {

			return new LoginResponseDTO("customer", cus.getId(), cus.getEmail());
		} else if (del.isPresent() && del.get().getEmail().equals(loginData.getEmail())
		        && del.get().getPassword().equals(loginData.getPassword())) {
		    return new LoginResponseDTO("delivery", del.get().getId(), del.get().getEmail());
		}

		return null;
	}
}