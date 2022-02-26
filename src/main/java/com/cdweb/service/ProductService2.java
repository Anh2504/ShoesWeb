package com.cdweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.model.Product;
import com.cdweb.repository.ProductRepository2;

@Service("productservice2")
public class ProductService2 {
	@Autowired
	ProductRepository2 productRepository2;
	
	@Transactional
	public ArrayList<Product> ff(){
		return productRepository2.ff();
	}
	
	@Transactional
	public ArrayList<Product> findNext1(){
		return productRepository2.findNext1();
	}
	
	@Transactional
	public ArrayList<Product> findNext2(){
		return productRepository2.findNext2();
	}
	
	@Transactional
	public ArrayList<Product> findNext3(){
		return productRepository2.findNext3();
	}
	
	@Transactional
	public ArrayList<Product> findNext4(){
		return productRepository2.findNext4();
	}
	
	@Transactional
	public ArrayList<Product> findNext5(){
		return productRepository2.findNext5();
	}
}
