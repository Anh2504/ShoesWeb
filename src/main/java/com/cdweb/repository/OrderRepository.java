package com.cdweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdweb.model.Order;
import com.cdweb.model.Product;

public interface OrderRepository  extends CrudRepository<Order,Long>  {
	Order findById(long id);
}
