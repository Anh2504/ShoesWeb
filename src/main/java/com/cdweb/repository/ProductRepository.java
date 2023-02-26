package com.cdweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cdweb.model.Category;
import com.cdweb.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{
	List<Product> findAll();
	Product findById(long id);
	List<Product> findBySexContainingAndCategory(String sex, Category category);
	List<Product> findByName(String name);
	List<Product> findByNameContaining(String name);
	List<Product> findTop5ByNameContaining(String name);
	
	// paging method
	Page<Product> findAll(Pageable pageable);
	Page<Product> findAllBySexContainingAndCategory(String sex, Category category, Pageable pageable);
	Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
