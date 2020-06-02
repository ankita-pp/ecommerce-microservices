package com.example.demo.repository;

import com.example.demo.model.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> ,CustomOrderRepository{
	public List<Order> findAllByUserId(String userId);
}
