package com.cdweb.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="OrderTest")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "price")
	private long price;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetail;
	
	public Order() {
		
	}

	public Order(long price) {
		
		
		this.price = price;
	}

	

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
