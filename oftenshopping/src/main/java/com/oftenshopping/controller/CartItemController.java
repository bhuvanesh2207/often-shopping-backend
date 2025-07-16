package com.oftenshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.service.CartItemService;

@CrossOrigin("*")
@RestController
public class CartItemController {
	
	@Autowired
	CartItemService service;
	
	@GetMapping("/deleteCartItem")
	public void deleteCart(@RequestParam Long id) {
		service.deleteCart(id);
	}
	
	@GetMapping("/removeAfterPay")
	public void removeAfterPay(@RequestParam Long customerId) {
		service.removeAfterPay(customerId);
	}
}
