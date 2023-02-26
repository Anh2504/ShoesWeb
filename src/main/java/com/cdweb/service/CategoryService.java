package com.cdweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.model.Category;
import com.cdweb.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	  @Transactional public Category save(Category category) { return
	  categoryRepository.save(category); }
	 
	@Transactional
	public List<Category> findAll(){
		return categoryRepository.findAll();
		
	}
	
	@Transactional
	public Category findById(long id) {
		return categoryRepository.findById(id);
	}
}
