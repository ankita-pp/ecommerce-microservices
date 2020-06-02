package com.example.demo.repository;

import com.example.demo.model.OrderStatus;

public interface CustomOrderRepository {
	public void updateOrderStatus(String orderId, OrderStatus orderStatus);
}
