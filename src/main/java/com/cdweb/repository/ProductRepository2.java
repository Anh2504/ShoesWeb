package com.cdweb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cdweb.model.Product;

public interface ProductRepository2 extends PagingAndSortingRepository<Product, Integer>{
	//ArrayList<Product> findAllById(int id, Pageable page);
	
	@Query("SELECT p FROM Product p WHERE price = 1190000")
	public ArrayList<Product> ff();
	
	@Query("SELECT p FROM Product p WHERE id between 1 and 12")
	public ArrayList<Product> findNext1();
	
	@Query("SELECT p FROM Product p WHERE id between 13 and 24")
	public ArrayList<Product> findNext2();
	
	@Query("SELECT p FROM Product p WHERE id between 25 and 36")
	public ArrayList<Product> findNext3();
	
	@Query("SELECT p FROM Product p WHERE id between 37 and 48")
	public ArrayList<Product> findNext4();
	
	@Query("SELECT p FROM Product p WHERE id between 49 and 60")
	public ArrayList<Product> findNext5();
}
