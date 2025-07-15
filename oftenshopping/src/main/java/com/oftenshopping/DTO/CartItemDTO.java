package com.oftenshopping.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class CartItemDTO {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String customerName;
	private String productName;
	private String productImage;
	private double price;
	private int quantity;

	public CartItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemDTO(Long id, String customerName, String productName, String productImage, double price,
			int quantity) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.productName = productName;
		this.productImage = productImage;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItemDTO [id=" + id + ", customerName=" + customerName + ", productName=" + productName
				+ ", productImage=" + productImage + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
