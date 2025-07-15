package com.oftenshopping.service;

import com.oftenshopping.DTO.CustomerDTO;
import com.oftenshopping.entity.Customer;

public interface CustomerService {

	void customerSignUp(CustomerDTO custdto);

	Customer getByEmail(String emial);
}
