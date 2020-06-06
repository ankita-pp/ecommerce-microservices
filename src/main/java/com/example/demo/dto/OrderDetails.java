package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private User user;
    private List<Product> product;
    private LocalDateTime createdDateTime;
    private LocalDateTime cancelledDateTime;
    private LocalDateTime deliveredDateTime;
    private BigDecimal orderPrice;
}
