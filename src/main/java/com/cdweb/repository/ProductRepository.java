package com.cdweb.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


import com.cdweb.model.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{
	ArrayList<Product> findAll();
	Product findById(int id);
}
