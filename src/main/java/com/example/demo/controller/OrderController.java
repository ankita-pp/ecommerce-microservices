package com.example.demo.controller;

import static com.example.demo.common.ConstantAttributes.ADD_ORDER;
import static com.example.demo.common.ConstantAttributes.CANCEL_ORDER;
import static com.example.demo.common.ConstantAttributes.GET_ORDER_DETAILS_BY_ORDER_ID;
import static com.example.demo.common.ConstantAttributes.GET_ORDER_DETAILS_BY_USER_ID;
import static com.example.demo.common.ConstantAttributes.GET_ORDER_FOR_USER;

import com.example.demo.dto.OrderDetails;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@GetMapping(GET_ORDER_FOR_USER)
	public List<Order> getOrdersByUserId(@PathVariable String userId) {
		return orderService.getAllOrdersByUserId(userId);
	}

	@GetMapping(GET_ORDER_DETAILS_BY_USER_ID)
	public List<OrderDetails> getOrderDetailsByUserId(@PathVariable String userId) {
		return orderService.getOrderDetailsForUser(userId);
	}

	@GetMapping(GET_ORDER_DETAILS_BY_ORDER_ID)
	public OrderDetails getOrderDetailsByOrderId(@PathVariable String orderId) {
		return orderService.getOrderDetailsForOrder(orderId);
	}

	@PostMapping(ADD_ORDER)
	public String addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	@PutMapping(CANCEL_ORDER)
	public String canceOrder(@PathVariable String orderId) {
		return orderService.cancelOrder(orderId);
	}



}
