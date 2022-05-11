package com.cdweb.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdweb.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	ArrayList<Product> findAll();
	Product findById(int id);
}
