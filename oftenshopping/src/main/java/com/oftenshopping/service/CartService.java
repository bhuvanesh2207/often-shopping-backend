package com.oftenshopping.service;

import java.util.List;

import com.oftenshopping.DTO.CartData;
import com.oftenshopping.DTO.CartItemDTO;

public interface CartService {

	void addtocart(CartData data);

	List<CartItemDTO> getCartItems(String email);

	void updateCartItem(CartData data);
}
