package com.example.demo.controller;

import com.example.demo.dto.OrderDetails;
import com.example.demo.model.Order;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.common.ConstantAttributes.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final AuthenticationService authenticationService;

    @GetMapping(GET_ORDER_FOR_USER)
    public List<Order> getOrdersByUserId(@RequestHeader boolean isAuthenticated, @PathVariable String userId) {
        authenticationService.isAuthenticated(isAuthenticated, userId);
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
