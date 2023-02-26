package com.cdweb.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdweb.model.OrderProduct;
import com.cdweb.model.OrderProductId;

public interface OrderProductRepository  extends CrudRepository<OrderProduct, OrderProductId> {

}
