package com.chris.cmarket_order_service.OrderItems.Repository;

import com.chris.cmarket_order_service.OrderItems.Model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, Long> {
}
