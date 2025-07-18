package com.oftenshopping.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
	private Long customerId;
	private String paymentId;
	private LocalDateTime ordertime;
	private Double totAmount;
	private String address;
	private List<OrderItemDTO> items;

	public OrderDTO() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDateTime getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(LocalDateTime ordertime) {
		this.ordertime = ordertime;
	}

	public Double getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(Double totAmount) {
		this.totAmount = totAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderDTO [customerId=" + customerId + ", paymentId=" + paymentId + ", ordertime=" + ordertime
				+ ", totAmount=" + totAmount + ", address=" + address + ", items=" + items + "]";
	}

	public OrderDTO(Long customerId, String paymentId, LocalDateTime ordertime, Double totAmount, String address,
			List<OrderItemDTO> items) {
		super();
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.ordertime = ordertime;
		this.totAmount = totAmount;
		this.address = address;
		this.items = items;
	}

}
