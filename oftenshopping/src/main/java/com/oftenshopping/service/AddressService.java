package com.oftenshopping.service;

import java.util.List;

import com.oftenshopping.DTO.AddressDTO;
import com.oftenshopping.entity.Address;

public interface AddressService {

	void addAddress(AddressDTO addressDto);

	List<Address> getAddress(Long customerId);

	void removeAddress(Long id);


}
