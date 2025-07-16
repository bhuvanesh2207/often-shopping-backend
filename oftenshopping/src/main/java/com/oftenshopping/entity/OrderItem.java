package com.oftenshopping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long Id;
			
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Orders orders;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private Product product;
	
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long id, Orders orders) {
		super();
		Id = id;
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderItem [Id=" + Id + ", orders=" + orders + "]";
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	 
}
