package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RequiredArgsConstructor
public class CustomOrderRepositoryImpl implements CustomOrderRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public void updateOrderStatus(String orderId, OrderStatus orderStatus) {
        Query query = new Query().addCriteria(where("_id").is(orderId));

        Update update = new Update();
        update.set("orderStatus", orderStatus);
        mongoTemplate.update(Order.class).matching(query).apply(update).first();
    }
}
