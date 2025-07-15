package com.oftenshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.CartData;
import com.oftenshopping.DTO.CartItemDTO;
import com.oftenshopping.service.CartService;

@CrossOrigin("*")
@RestController
public class CartController {
	
	@Autowired
	CartService service;
	
	@PostMapping(value = "/addToCart", consumes = "application/json", produces = "application/json")
	public String addtocart(@RequestBody CartData data) {
		service.addtocart(data);
		return "success";
	}
	
	@GetMapping("/viewCart")
    public List<CartItemDTO> viewCart(@RequestParam String email) {
        return service.getCartItems(email);
    }
	
	 @PostMapping("/updateCartItem")
	    public String updateCartItem(@RequestBody CartData data) {
	        service.updateCartItem(data);
	        return "success";
	    }
}
