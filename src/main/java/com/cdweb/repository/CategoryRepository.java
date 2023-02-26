package com.cdweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdweb.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
	List<Category> findAll();
	Category findById(long id);
}
