package com.cdweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable{
	
	@Column(name="order_id")
	private long orderId;
	
	@Column(name="product_id")
	private long productId;
	
	public OrderProductId() {
		
	}

	public OrderProductId(long orderId, long productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	
	
}
