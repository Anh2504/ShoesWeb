package com.cdweb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	private Account account;
	private List<Product> productList;

	public Cart() {

	}

	public Cart(Account account, List<Product> productList) {
		this.account = account;
		this.productList = productList;
	}
	
	public void addToCart(Product product) {
		productList = new ArrayList<Product>();
		productList.add(product);
	}
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
