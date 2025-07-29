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

	    if (orderDTO.getStatus() == null || orderDTO.getStatus().trim().isEmpty()) {
	        orders.setStatus("PENDING");
	    } else {
	        orders.setStatus(orderDTO.getStatus().trim());
	    }

	    List<OrderItem> orderItems = new ArrayList<>();
	    for (OrderItemDTO itemDto : orderDTO.getItems()) {
	        Product product = productRepo.findById(itemDto.getProductId())
	                .orElseThrow(() -> new RuntimeException("Product not found: " + itemDto.getProductId()));

	        OrderItem orderItem = new OrderItem();
	        orderItem.setProduct(product);
	        orderItem.setQuantity(itemDto.getQuantity());
	        orderItem.setOrders(orders);
	        orderItems.add(orderItem);
	    }

	    orders.setItems(orderItems);
	    orderRepo.save(orders);
	    System.out.println("Final saved status: " + orders.getStatus());
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
	            itemDTO.setProductId(product.getId()); 
	            itemDTOs.add(itemDTO);
	        }

	        OrderDTO dto = new OrderDTO();
	        dto.setPaymentId(order.getPaymentId());
	        dto.setOrdertime(order.getOrdertime());
	        dto.setTotAmount(order.getTotAmount());
	        dto.setItems(itemDTOs);
	        dto.setStatus(order.getStatus());
	        dto.setAddress(order.getAddress()); 

	        orderDTOs.add(dto);
	    }

	    return orderDTOs;
	}


}
