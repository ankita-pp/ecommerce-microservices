package com.example.demo.service;

import com.example.demo.dto.OrderDetails;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Order> getAllOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public String addOrder(Order order) {
        try {
            orderRepository.save(order);
            return "Order placed successfully..!";
        } catch (Exception e) {
            return "Sorry....! please try again..!";
        }
    }

    public List<OrderDetails> getOrderDetailsForUser(String userId) {
        List<Order> orders = orderRepository.findAllByUserId(userId);
        if (orders != null) {
            return orders.stream().map(order ->
                    OrderDetails.builder()
                            .user(userRepository.findUserById(order.getUserId()))
                            .product(order.getProductIds().stream()
                                    .map(productId -> productRepository.findById(productId)
                                            .orElse(null))
                                    .collect(Collectors.toList()))
                            .orderPrice(order.getOrderPrice())
                            .createdDateTime(order.getCreatedDateTime())
                            .cancelledDateTime(order.getCancelledDateTime())
                            .deliveredDateTime(order.getDeliveredDateTime())
                            .build()
            ).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public OrderDetails getOrderDetailsForOrder(String orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            return OrderDetails.builder()
                    .user(userRepository.findUserById(order.getUserId()))
                    .product(order.getProductIds().stream()
                            .map(productId -> productRepository.findById(productId)
                                    .orElse(null))
                            .collect(Collectors.toList()))
                    .orderPrice(order.getOrderPrice())
                    .createdDateTime(order.getCreatedDateTime())
                    .cancelledDateTime(order.getCancelledDateTime())
                    .deliveredDateTime(order.getDeliveredDateTime())
                    .build();
        } else {
            return null;
        }
    }

    public String cancelOrder(String orderId) {
        try {
            orderRepository.updateOrderStatus(orderId, OrderStatus.CANCELLED);

            log.info("Order cancelled..!");
            return "your order cancelled successfully..!";
        } catch (Exception e) {
            log.error("Error occurred in canceling order..!", e);
            return "Cancellation failed";
        }
    }
}
