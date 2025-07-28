package com.oftenshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.AdminOrderedProductDTO;
import com.oftenshopping.DTO.AdminSignupDTO;
import com.oftenshopping.entity.Admin;
import com.oftenshopping.entity.DeliveryPerson;
import com.oftenshopping.entity.OrderItem;
import com.oftenshopping.entity.Orders;
import com.oftenshopping.entity.Product;
import com.oftenshopping.repository.AdminRepository;
import com.oftenshopping.repository.DeliveryPersonRepository;
import com.oftenshopping.repository.OrdersRepository;

import jakarta.mail.MessagingException;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	AdminRepository admRepo;

	@Autowired
	OtpService otpService;

	@Autowired
	EmailService eservice;

	@Autowired
	OrdersRepository ordersRepo;

	@Autowired
	DeliveryPersonRepository delRepo;

	@Override
	public void emailadminSignup(AdminSignupDTO adminDto) throws MessagingException {
		eservice.processSignup(adminDto);
	}

	@Override
	public Admin getByCompanyEmail(String email) {
		return admRepo.getByCompanyEmail(email);
	}

	@Override
	public void approved(Long id) {
		eservice.approved(id);
	}

	@Override
	public void rejected(Long id) {
		eservice.rejected(id);
	}

	@Override
	public void changePasswordotp(String email) {

		Admin admin = admRepo.getByCompanyEmail(email);
		// Call OTP generation from OtpService
		String otp = otpService.generatedOtp(email);

		// Call EmailService to send email
		eservice.sendOtpMail(admin.getCompanyEmail(), otp);
	}

	@Override
	public List<AdminOrderedProductDTO> getOrderedProducts(Long id) {
		List<Orders> allOrders = ordersRepo.findAll();
		List<AdminOrderedProductDTO> result = new ArrayList<>();

		for (Orders order : allOrders) {
			for (OrderItem item : order.getItems()) {
				Product product = item.getProduct();
				if (product.getAdmin() != null && product.getAdmin().getId().equals(id)) {
					AdminOrderedProductDTO dto = new AdminOrderedProductDTO(product.getProductName(),
							product.getProductImage(), product.getPrice(), item.getQuantity(), order.getId(),
							order.getOrdertime(), order.getAddress());
					result.add(dto);
				}
			}
		}
		return result;
	}

	@Override
	public void confrimOrder(Long id) {
	    Optional<Orders> optionalOrder = ordersRepo.findById(id);
	   

	    Orders order = optionalOrder.get();
	    List<DeliveryPerson> personList = delRepo.findAll();

	    Random random = new Random();
	    DeliveryPerson assignedPerson = null;

	    while (assignedPerson == null && !personList.isEmpty()) {
	        int index = random.nextInt(personList.size());
	        DeliveryPerson tempPerson = personList.get(index);

	        
	        Optional<DeliveryPerson> validPerson = delRepo.findById(tempPerson.getId());
	        if (validPerson.isPresent()) {
	            assignedPerson = validPerson.get();
	        } else {
	            personList.remove(index); 
	        }
	    }

	    if (assignedPerson == null) {
	        throw new RuntimeException("No valid delivery person found.");
	    }

	    order.setStatus("CONFIRMED");
	    order.setDeliveryPerson(assignedPerson);
	    ordersRepo.save(order);
	}
}