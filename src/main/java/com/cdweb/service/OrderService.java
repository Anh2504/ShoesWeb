package com.cdweb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.model.Order;
import com.cdweb.repository.OrderRepository;

@Service()
public class OrderService {
	
	  @Autowired OrderRepository orderRepository;
	  
	  @Transactional public Order save(Order order) { return
	  orderRepository.save(order); }
	 
	  @Transactional
	  public Order findById(long id) {
		  return orderRepository.findById(id);
	  }
}
