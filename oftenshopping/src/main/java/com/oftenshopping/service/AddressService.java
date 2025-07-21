package com.oftenshopping.service;

import java.util.List;
import java.util.Optional;

import com.oftenshopping.DTO.AddressDTO;
import com.oftenshopping.entity.Address;

public interface AddressService {

	void addAddress(AddressDTO addressDto);

	List<Address> getAddress(Long customerId);

	void removeAddress(Long id);

	Optional<Address> getAddressById(Long id);


}
