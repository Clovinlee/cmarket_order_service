package com.chris.cmarket_order_service.Order.Service;

import com.chris.cmarket_order_service.Order.Model.OrderModel;
import com.chris.cmarket_order_service.Order.Repository.OrderRepository;
import com.chris.cmarket_order_service.OrderItems.Model.OrderItemModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {
    private OrderRepository orderRepository;

    /**
     * @param uuid model uuid
     * @return optional order model
     */
    public Optional<OrderModel> getOrderByUuid(String uuid) {
        return this.orderRepository.findByUuid(uuid);
    }

    /**
     * @param orderModel      order model
     * @param orderItemModels order item models with order relation already set
     */
    public void saveModel(OrderModel orderModel, List<OrderItemModel> orderItemModels) {
        orderModel.setOrderItems(orderItemModels);

        this.orderRepository.save(orderModel);
    }
}
