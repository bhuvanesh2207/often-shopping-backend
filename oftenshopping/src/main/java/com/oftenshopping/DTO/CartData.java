package com.oftenshopping.DTO;

public class CartData {
	private String customerEmail;
	private Long productId;
	private int quantity;

	public CartData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartData(String customerEmail, Long productId, int quantity) {
		super();
		this.customerEmail = customerEmail;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartData [customerEmail=" + customerEmail + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	

}
