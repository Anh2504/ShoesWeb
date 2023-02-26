package com.cdweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdweb.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
