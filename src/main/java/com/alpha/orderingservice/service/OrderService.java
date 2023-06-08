package com.alpha.orderingservice.service;

import com.alpha.orderingservice.dto.OrderDto;
import com.alpha.orderingservice.entity.Order;
import com.alpha.orderingservice.payload.OrderPayload;

import javax.jms.JMSException;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order placeOrder(OrderPayload orderPayload);

    void deleteOrder(Long id);
}
