package com.oftenshopping.service;

import java.util.List;
import java.util.Optional;

import com.oftenshopping.DTO.DeliveryConfirmedProductDTO;
import com.oftenshopping.DTO.DeliverySignupDTO;
import com.oftenshopping.entity.DeliveryPerson;
import com.oftenshopping.entity.Orders;

import jakarta.mail.MessagingException;

public interface DeliveryPersonService {

	Optional<DeliveryPerson> getByDeliveryEmail(String email);

	void deliverySignup(DeliverySignupDTO deliveryDto) throws MessagingException;

	void approved(Long id);

	void rejected(Long id);

	List<DeliveryConfirmedProductDTO> getConfirmProduct(String email);

	void deliveryOtp(Long id);

	String verifyDeliveryOtp(Long otp, Long orderId);

	String deliverd(Long orderId);

	String outForDelivered(Long orderId);

	void deliveryPerChangePasswordotp(String email);
}
