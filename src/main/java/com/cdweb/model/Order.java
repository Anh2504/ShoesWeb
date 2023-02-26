package com.cdweb.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@OneToMany(mappedBy = "order")
	private Set<OrderProduct> listProduct = new HashSet<OrderProduct>();

	public Order() {

	}

	public Order(String userName, String email, String address, String city, Set<OrderProduct> listProduct) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.listProduct = listProduct;
	}

	public Set<OrderProduct> getListProduct() {
		return listProduct;
	}

	public void setListProduct(Set<OrderProduct> listProduct) {
		this.listProduct = listProduct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

}
