package com.oftenshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.CartData;
import com.oftenshopping.DTO.CartItemDTO;
import com.oftenshopping.entity.Cart;
import com.oftenshopping.entity.CartItem;
import com.oftenshopping.entity.Customer;
import com.oftenshopping.entity.Product;
import com.oftenshopping.repository.CartItemRepository;
import com.oftenshopping.repository.CartRepository;
import com.oftenshopping.repository.CustomerRepository;
import com.oftenshopping.repository.ProductRepository;


@Service
public class CartServiceImplementatoin implements CartService{

	@Autowired
	CustomerRepository cusrepo;
	@Autowired
	ProductRepository prorepo;
	@Autowired
	CartRepository cartrepo;
	@Autowired
	CartItemRepository itemrepo;

	public void addtocart(CartData data) {

		System.out.println("Received CartData: " + data);
		
		Customer cus = cusrepo.findByEmail(data.getCustomerEmail());
	    if (cus == null)
	        throw new RuntimeException("Customer not found");

	    Product product = prorepo.findById(data.getProductId())
	        .orElseThrow(() -> new RuntimeException("Product not found"));

	    int quantity = data.getQuantity();


		// Handle missing cart (this is your missing piece!)
		Cart cart = cus.getCart();
		if (cart == null) {
			cart = new Cart();
			cart.setCustomer(cus); // set customer to cart
			cart = cartrepo.save(cart); // save and assign generated ID
			cus.setCart(cart); // link back to customer
			cusrepo.save(cus); // update customer record
		}

		Optional<CartItem> existing = itemrepo.findByCartAndProduct(cart, product);

		CartItem item;
		if (existing.isPresent()) {
			item = existing.get();
			item.setQuantity(item.getQuantity() + quantity);
		} else {
			item = new CartItem(cart, product, quantity);
		}

		itemrepo.save(item);
	}

	@Override
	public List<CartItemDTO> getCartItems(String email) {

	    // Step 1: Fetch customer by email
	    Customer customer = cusrepo.findByEmail(email);
	    if (customer == null) {
	        throw new RuntimeException("Customer not found for email: " + email);
	    }

	    // Step 2: Get customer's cart
	    Cart cart = customer.getCart();
	    if (cart == null || cart.getItems() == null) {
	        return new ArrayList<>(); // empty cart
	    }

	    // Step 3: Prepare DTO list
	    List<CartItemDTO> dtoList = new ArrayList<>();

	    for (CartItem item : cart.getItems()) {
	        Product product = item.getProduct();

	        CartItemDTO dto = new CartItemDTO(
	        	item.getId(),
	            customer.getName(),
	            product.getProductName(),
	            product.getProductImage(),
	            product.getPrice(),
	            item.getQuantity()
	        );

	        dtoList.add(dto);
	    }

	    return dtoList;
	}
	
	public void updateCartItem(CartData data) {
	    // Find customer by email (your frontend sends email, not username)
	    Customer customer = cusrepo.findByEmail(data.getCustomerEmail());
	    if (customer == null) {
	        throw new RuntimeException("Customer not found");
	    }

	    // Get customer's cart
	    Cart cart = customer.getCart();
	    if (cart == null) {
	        throw new RuntimeException("Cart not found");
	    }

	    // Find product by ID
	    Product product = prorepo.findById(data.getProductId())
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    // Find cart item by cart and product
	    Optional<CartItem> existingItem = itemrepo.findByCartAndProduct(cart, product);
	    if (!existingItem.isPresent()) {
	        throw new RuntimeException("CartItem not found");
	    }
	    CartItem item = existingItem.get();

	    int newQty = data.getQuantity();

	    if (newQty > 0) {
	        item.setQuantity(newQty);
	        itemrepo.save(item);
	    } else {
	        // Remove item from cart if quantity is zero or less
	        itemrepo.delete(item);
	    }
	}

}
