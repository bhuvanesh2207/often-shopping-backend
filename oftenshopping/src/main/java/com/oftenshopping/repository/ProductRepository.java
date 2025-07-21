package com.oftenshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oftenshopping.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE " +
		       "LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Product> searchProduct(String keyword);

	List<Product> findByAdminId(Long id);

	List<Product> findAllById(Long id);

}
