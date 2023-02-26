package com.cdweb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	private Account account = new Account();
	private List<Product> productList = new ArrayList<Product>();
	private List<Integer> productAmountList = new ArrayList<Integer>();

	public void addToCart(Product product) {
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

	public List<Integer> getProductAmountList() {
		return productAmountList;
	}

	public void setProductAmountList(List<Integer> productAmountList) {
		this.productAmountList = productAmountList;
	}
	
}
