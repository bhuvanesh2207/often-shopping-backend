package com.oftenshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oftenshopping.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

}
