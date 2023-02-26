package com.cdweb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.model.OrderProduct;
import com.cdweb.repository.OrderProductRepository;

@Service()
public class OrderProductService {
	
	  @Autowired OrderProductRepository orderProductRepository;
	  
	  @Transactional public OrderProduct save(OrderProduct orderProduct) { return
	  orderProductRepository.save(orderProduct); }
	 
}
