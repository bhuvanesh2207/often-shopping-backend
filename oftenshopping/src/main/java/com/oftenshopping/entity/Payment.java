package com.oftenshopping.entity;

import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String paymentId;
	private String orderId;
	private int amount;
	private LocalDateTime paymentDate;
	private Instant paymentTimestamp;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(Long id, String email, String paymentId, String orderId, int amount, LocalDateTime paymentDate,
			Instant paymentTimestamp) {
		super();
		this.id = id;
		this.email = email;
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentTimestamp = paymentTimestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Instant getPaymentTimestamp() {
		return paymentTimestamp;
	}
	public void setPaymentTimestamp(Instant paymentTimestamp) {
		this.paymentTimestamp = paymentTimestamp;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", email=" + email + ", paymentId=" + paymentId + ", orderId=" + orderId
				+ ", amount=" + amount + ", paymentDate=" + paymentDate + ", paymentTimestamp=" + paymentTimestamp
				+ "]";
	}

	
}

