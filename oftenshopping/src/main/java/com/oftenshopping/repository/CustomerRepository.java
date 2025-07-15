package com.oftenshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oftenshopping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByEmail(String email);
}
