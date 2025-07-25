package com.oftenshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oftenshopping.DTO.OrderDTO;
import com.oftenshopping.DTO.OrderItemDTO;
import com.oftenshopping.entity.Customer;
import com.oftenshopping.entity.OrderItem;
import com.oftenshopping.entity.Orders;
import com.oftenshopping.entity.Product;
import com.oftenshopping.repository.CustomerRepository;
import com.oftenshopping.repository.OrdersRepository;
import com.oftenshopping.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class OrdresServiceImplementation implements OrdersService {

	@Autowired
	OrdersRepository orderRepo;

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CustomerRepository cusRepo;

	@Override
	@Transactional 
	public void createOrder(OrderDTO orderDTO) {
		 Customer customer = cusRepo.findById(orderDTO.getCustomerId())
			        .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + orderDTO.getCustomerId()));
		Orders orders = new Orders();
		orders.setCustomer(customer);
		orders.setAddress(orderDTO.getAddress());
		orders.setOrdertime(orderDTO.getOrdertime());
		orders.setPaymentId(orderDTO.getPaymentId());
		orders.setTotAmount(orderDTO.getTotAmount());
		orders.setStatus(orderDTO.getStatus());
		// Create a list for the OrderItem 
		List<OrderItem> orderItems = new ArrayList<>();

		// Loop over each OrderItemDTO
		for (OrderItemDTO itemDto : orderDTO.getItems()) {
			OrderItem orderItem = new OrderItem();

			// Fetch the Product entity from the database
			Product product = productRepo.findById(itemDto.getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found: " + itemDto.getProductId()));

			orderItem.setProduct(product);
			orderItem.setQuantity(itemDto.getQuantity());
			orderItem.setOrders(orders);

			// Adding order item to the list
			orderItems.add(orderItem);
		}

		// Attach all order items to the order
		orders.setItems(orderItems);

		// Save the order
		orderRepo.save(orders);
		System.out.println(orders.getAddress());
	}


	@Override
	public List<OrderDTO> listOfOrders(Long customerId) {
	    List<Orders> orders = orderRepo.findByCustomerId(customerId);

	    List<OrderDTO> orderDTOs = new ArrayList<>();

	    for (Orders order : orders) {
	        List<OrderItemDTO> itemDTOs = new ArrayList<>();

	        for (OrderItem item : order.getItems()) {
	            Product product = item.getProduct();
	            OrderItemDTO itemDTO = new OrderItemDTO();
	            itemDTO.setQuantity(item.getQuantity());
	            itemDTO.setProductId(product.getId()); // ✅ Include productId
	            itemDTOs.add(itemDTO);
	        }

	        OrderDTO dto = new OrderDTO();
	        dto.setPaymentId(order.getPaymentId());
	        dto.setOrdertime(order.getOrdertime());
	        dto.setTotAmount(order.getTotAmount());
	        dto.setItems(itemDTOs);
	        dto.setAddress(order.getAddress()); // or fetch actual Address object if needed

	        orderDTOs.add(dto);
	    }

	    return orderDTOs;
	}


}
