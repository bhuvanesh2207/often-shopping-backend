package com.oftenshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.DeliveryConfirmedProductDTO;
import com.oftenshopping.DTO.DeliverySignupDTO;
import com.oftenshopping.entity.Customer;
import com.oftenshopping.entity.CustomerDeliveryOtp;
import com.oftenshopping.entity.DeliveryPerson;
import com.oftenshopping.entity.OrderItem;
import com.oftenshopping.entity.Orders;
import com.oftenshopping.entity.Product;
import com.oftenshopping.repository.CustomerDeliveryOtpRepository;
import com.oftenshopping.repository.CustomerRepository;
import com.oftenshopping.repository.DeliveryPersonRepository;
import com.oftenshopping.repository.OrdersRepository;

import jakarta.mail.MessagingException;

@Service
public class DeliveryPersonServiceImplementation implements DeliveryPersonService {

	@Autowired
	DeliveryPersonRepository repo;

	@Autowired
	EmailService eservice;

	@Autowired
	OrdersRepository ordersRepo;

	@Autowired
	CustomerRepository cusRepo;

	@Autowired
	CustomerDeliveryOtpRepository delOtpRepo;

	@Override
	public void deliverySignup(DeliverySignupDTO deliveryDto) throws MessagingException {
		eservice.processDeliverySignup(deliveryDto);
	}

	@Override
	public void approved(Long id) {
		eservice.delapproved(id);
	}

	@Override
	public void rejected(Long id) {
		eservice.delrejected(id);
	}

	@Override
	public Optional<DeliveryPerson> getByDeliveryEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<DeliveryConfirmedProductDTO> getConfirmProduct(String email) {
		Optional<DeliveryPerson> person = repo.findByEmail(email);

		if (person.isEmpty()) {
			throw new RuntimeException("Delivery person not found with email: " + email);
		}

		List<Orders> orders = ordersRepo.findByDeliveryPersonId(person.get().getId());
		List<DeliveryConfirmedProductDTO> dtoList = new ArrayList<>();

		for (Orders order : orders) {
			for (OrderItem item : order.getItems()) {
				Product product = item.getProduct();

				DeliveryConfirmedProductDTO dto = new DeliveryConfirmedProductDTO(order.getId(), order.getOrdertime(),
						order.getTotAmount(), order.getStatus(), product.getId(), product.getProductName(),
						product.getProductImage(), item.getQuantity(), order.getAddress());
				dtoList.add(dto);
			}

		}

		return dtoList;
	}

	@Override
	public void deliveryOtp(Long id) {
		Optional<Orders> orderOptional = ordersRepo.findById(id);

		Orders order = orderOptional.get();

		Customer customer = order.getCustomer();

		String email = customer.getEmail();

		// Generate 6-digit OTP
		Random random = new Random();
		int otp = random.nextInt(900000) + 100000;
		String otpStr = String.valueOf(otp);

		CustomerDeliveryOtp delotp = new CustomerDeliveryOtp();
		delotp.setOtp(otpStr);
		delotp.setOrderId(id);

		delOtpRepo.save(delotp);

		// Send email
		eservice.sendDeliveryOtpEmail(email, otpStr);

	}

	@Override
	public String verifyDeliveryOtp(Long otp, Long orderId) {
		Optional<CustomerDeliveryOtp> otpOptional = delOtpRepo.findByOrderId(orderId);

		if (otpOptional.isPresent()) {
			CustomerDeliveryOtp storedOtp = otpOptional.get();

			if (storedOtp.getOtp().equals(String.valueOf(otp))) {
				return "OTP verified successfully!";
			} else {
				return "Invalid OTP!";
			}
		} else {
			return "OTP not found for this order.";
		}
	}

	@Override
	public String deliverd(Long orderId) {
		Optional<Orders> order = ordersRepo.findById(orderId);
		Orders exsistOrder = order.get();
		exsistOrder.setStatus("DELIVERED");
		ordersRepo.save(exsistOrder);
		return "DELIVERED SUCCESSFULLY....";
	}

	@Override
	public String outForDelivered(Long orderId) {
		Optional<Orders> order = ordersRepo.findById(orderId);
		Orders exsistOrder = order.get();
		exsistOrder.setStatus("OUT FOR DELIVERED");
		ordersRepo.save(exsistOrder);
		return "OUT FOR DELIVERY SUCCESSFULLY....";
	}

}
