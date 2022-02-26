package com.cdweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.model.ProductImage;
import com.cdweb.repository.ProductImageRepository;

@Service("productimageservice")
public class ProductImageService {
	@Autowired
	ProductImageRepository productImageRepository;
	
	@Transactional
	public ProductImage findById(int id) {
		return productImageRepository.findById(id);
	}
}
