package com.chris.cmarket_order_service.Order.Listener;

import com.chris.cmarket_order_service.Order.Event.PlaceOrderEvent;
import com.chris.cmarket_order_service.Order.Model.OrderModel;
import com.chris.cmarket_order_service.Order.Service.OrderService;
import com.chris.cmarket_order_service.OrderItems.Model.OrderItemModel;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class OrderListener {
    private OrderService orderService;

    @Transactional(rollbackOn = Throwable.class)
    @RetryableTopic(
            attempts = "1",                   // retry 1 time
            dltTopicSuffix = ".DLT"           // send to topic with this suffix if retries fail
    )
    @KafkaListener(topics = PlaceOrderEvent.TOPIC_NAME, groupId = "order_group-1")
    public void placeOrder(PlaceOrderEvent placeOrderEvent) throws Exception {
        Optional<OrderModel> orderModel = this.orderService.getOrderByUuid(placeOrderEvent.getUuid());

        // Do not process event if order uuid already exist
        if (orderModel.isPresent()) {
            log.info("Order already exists with uuid {}", placeOrderEvent.getUuid());
            return;
        }

        int quantity = placeOrderEvent.getQuantity();
        BigDecimal priceItem = placeOrderEvent.getPriceItem();
        BigDecimal totalPrice = priceItem.multiply(BigDecimal.valueOf(quantity));

        OrderModel order = new OrderModel(placeOrderEvent, totalPrice);

        OrderItemModel orderItemModel = new OrderItemModel(placeOrderEvent.getProductId(), quantity, priceItem);
        orderItemModel.setOrder(order);

        this.orderService.saveModel(order, List.of(orderItemModel));
    }
}