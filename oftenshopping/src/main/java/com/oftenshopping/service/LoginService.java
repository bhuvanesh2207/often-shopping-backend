package com.oftenshopping.service;

import com.oftenshopping.DTO.LoginDataDTO;
import com.oftenshopping.DTO.LoginResponseDTO;

public interface LoginService {

	LoginResponseDTO signin(LoginDataDTO loginData);

	 
}
