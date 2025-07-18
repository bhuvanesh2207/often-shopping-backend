package com.oftenshopping.service;

import java.util.List;

import com.oftenshopping.DTO.OrderDTO;
import com.oftenshopping.entity.Orders;

public interface OrdersService {

	void createOrder(OrderDTO order);

	List<Orders> listOfOrders(Long id);


}
