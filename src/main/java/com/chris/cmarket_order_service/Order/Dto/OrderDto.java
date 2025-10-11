package com.chris.cmarket_order_service.Order.Dto;

import com.chris.cmarket_order_service.Order.Model.OrderModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {
    private String uuid;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("total_quantity")
    private int totalQuantity;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    public OrderDto(OrderModel model) {
        this.uuid = model.getUuid();
        this.userId = model.getUserId();
        this.totalQuantity = model.getTotalQuantity();
        this.totalPrice = model.getTotalPrice();
    }
}
