package com.chris.cmarket_order_service.Order.Model;

import com.chris.cmarket_order_service.Common.Listener.ModelUuidListener;
import com.chris.cmarket_order_service.Common.Model.Contract.HasUuidModel;
import com.chris.cmarket_order_service.Order.Event.PlaceOrderEvent;
import com.chris.cmarket_order_service.OrderItems.Model.OrderItemModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners({ModelUuidListener.class})
public class OrderModel implements HasUuidModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String uuid;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "total_quantity")
    private Integer totalQuantity;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItemModel> orderItems;

    /**
     * Constructor to create new orderModel
     */
    public OrderModel(PlaceOrderEvent placeOrderEvent, BigDecimal totalPrice) {
        this.userId = placeOrderEvent.getUserId();
        this.totalPrice = totalPrice;
        this.totalQuantity = placeOrderEvent.getQuantity();
        this.uuid = placeOrderEvent.getUuid();
    }
}
