package com.oftenshopping.service;

import java.util.List;
import java.util.Optional;

import com.oftenshopping.DTO.CreateProductDTO;
import com.oftenshopping.DTO.UpdateProductDTO;
import com.oftenshopping.entity.Product;

public interface ProductService {

	void create(CreateProductDTO createDto);

	void update(UpdateProductDTO updDto);

	void delete(Long id);

	List<Product> getAllProducts(Long id);

	List<Product> searchProduct(String keyword);

	List<Product> viewAllProduct();

	List<Product> getProductById(Long id);

}
