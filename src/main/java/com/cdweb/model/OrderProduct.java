package com.cdweb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderProduct implements Serializable{
	@EmbeddedId
	private OrderProductId id;
	
	@ManyToOne()
	@MapsId("orderId")
	//@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne()
	@MapsId("productId")
	//@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name="amount")
	private int amount;
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public OrderProduct() {
		
	}

	public OrderProductId getId() {
		return id;
	}

	public void setId(OrderProductId id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
