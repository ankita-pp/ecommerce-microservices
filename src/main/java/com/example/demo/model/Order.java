package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@Field("_id")
	private String orderId;
	private String userId;
	private List<String> productIds;
	private OrderStatus orderStatus;
	private LocalDateTime createdDateTime;
	private LocalDateTime cancelledDateTime;
	private LocalDateTime deliveredDateTime;
	private BigDecimal orderPrice;
}
