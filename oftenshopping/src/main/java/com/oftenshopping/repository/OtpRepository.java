package com.oftenshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oftenshopping.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long>{

	Otp findByEmail(String email);

}
