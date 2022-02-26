package com.cdweb.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.model.Product;
import com.cdweb.repository.ProductRepository;

@Service("productservice")
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Transactional
	public ArrayList<Product> findAll(){
		return productRepository.findAll();
	}
	@Transactional
	public Product findById(int id) {
		return productRepository.findById(id);
	}
	
}
