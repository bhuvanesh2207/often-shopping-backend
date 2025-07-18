package com.oftenshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oftenshopping.DTO.OrderDTO;
import com.oftenshopping.entity.Orders;
import com.oftenshopping.service.OrdersService;

@CrossOrigin("*")
@RestController
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@PostMapping("/createOrder")
	public void createOrder(@RequestBody OrderDTO order) {
		System.out.println("Received order: " + order);
		service.createOrder(order);
	}
	
	@GetMapping("/listOfOrders")
	public List<Orders> listOfOrders (Long id) {
		return service.listOfOrders(id);
	}
}
