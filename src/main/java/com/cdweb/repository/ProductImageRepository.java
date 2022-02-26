package com.cdweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdweb.model.ProductImage;

public interface ProductImageRepository extends CrudRepository<ProductImage,Integer>{
	ProductImage findById(int id);
}
