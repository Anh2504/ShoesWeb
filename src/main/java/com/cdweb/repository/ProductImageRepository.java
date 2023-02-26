package com.cdweb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdweb.model.ProductImage;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage,Long>{
	ProductImage findById(long id);
}
