package com.oftenshopping.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oftenshopping.entity.Cart;
import com.oftenshopping.entity.CartItem;
import com.oftenshopping.entity.Product;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	Optional<CartItem> findByCartAndProduct(Cart cart, Product product);
}
