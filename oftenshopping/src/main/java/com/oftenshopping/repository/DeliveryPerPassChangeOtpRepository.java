package com.oftenshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oftenshopping.entity.DeliveryPerPassChangeOtp;

public interface DeliveryPerPassChangeOtpRepository extends JpaRepository<DeliveryPerPassChangeOtp, Long>{

	DeliveryPerPassChangeOtp findByEmail(String deliveryEmail);

}
