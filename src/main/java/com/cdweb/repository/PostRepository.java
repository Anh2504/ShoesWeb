package com.cdweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdweb.model.Post;

public interface PostRepository extends CrudRepository<Post,Integer>{

}
