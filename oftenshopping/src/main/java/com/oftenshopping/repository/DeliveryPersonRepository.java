package com.oftenshopping.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oftenshopping.entity.DeliveryPerson;
import com.oftenshopping.entity.Orders;


public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long>{

	Optional<DeliveryPerson> findByEmail(String email); 

	List<Orders> findByDeliveryPersonId(Long id);
}
