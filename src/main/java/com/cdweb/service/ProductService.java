package com.cdweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.model.Category;
import com.cdweb.model.Product;
import com.cdweb.repository.CategoryRepository;
import com.cdweb.repository.ProductRepository;

@Service("productservice")
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	public Product findById(long id) {
		return productRepository.findById(id);
	}
	@Transactional
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}
	@Transactional
	public List<Product> findBySexContainingAndCategory(String sex, Category category) {
		return productRepository.findBySexContainingAndCategory(sex, category);
	}

	@Transactional
	public List<Product> findByNameContaining(String name) {
		return productRepository.findByNameContaining(name);
	}
	
	@Transactional
	public List<Product> findTop5ByNameContaining(String name) {
		return productRepository.findTop5ByNameContaining(name);
	}

	// paging method
	@Transactional
	public Page<Product> findAll(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size);
		return productRepository.findAll(pageable);
	}

	// paging method
	@Transactional
	public Page<Product> findAllBySexContainingAndCategory(String sex, Category category, int page, int size) {
		PageRequest pageable = PageRequest.of(page, size);

		return productRepository.findAllBySexContainingAndCategory(sex, category, pageable);
	}

	// search paging method
	@Transactional
	public Page<Product> findAllByNameContaining(String name, int page, int size) {
		PageRequest pageable = PageRequest.of(page, size);

		return productRepository.findAllByNameContaining(name, pageable);
	}

	@Transactional
	public int getTotalPage(List<Product> productList, int pageSize) {

		int temp = productList.size() % pageSize;
		int totalPage;
		if (temp == 0) {
			totalPage = productList.size() / pageSize;
		} else {
			totalPage = (productList.size() / pageSize) + 1;
		}
		return totalPage;
	}

//	@Transactional
//	public int getTotalPage(String sex, long categoryId) {
//		Category category = categoryRepository.findById(categoryId);
//		List<Product> productList = productRepository.findBySexContainingAndCategory(sex,category);
//		int temp = productList.size() % 4;
//		int totalPage;
//		if (temp == 0) {
//			totalPage = productList.size() / 4;
//		} else {
//			totalPage = (productList.size() / 4) + 1;
//		}
//		return totalPage;
//	}
}
