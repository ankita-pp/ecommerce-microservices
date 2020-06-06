package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String>, CustomOrderRepository {
    List<Order> findAllByUserId(String userId);
}
