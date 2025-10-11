package com.chris.cmarket_order_service.Order.Repository;

import com.chris.cmarket_order_service.Order.Model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    Optional<OrderModel> findByUuid(String uuid);
}
