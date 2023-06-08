package com.alpha.orderingservice.service.impl;

import com.alpha.orderingservice.entity.Order;
import com.alpha.orderingservice.payload.OrderPayload;
import com.alpha.orderingservice.repository.OrderRepository;
import com.alpha.orderingservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();

    }

    @Override
    public Order placeOrder(OrderPayload orderPayload) {
        Order order = new Order();
        order.setProductName(orderPayload.getProductName());
        order.setQuantity(orderPayload.getQuantity());
        order.setPrice(orderPayload.getPrice());
        order.setStatus("PENDING");
        Order savedOrder = orderRepository.save(order);

        ActiveMQTopic topic = new ActiveMQTopic("order-topic");
        ActiveMQQueue queue = new ActiveMQQueue("order-queue");
        jmsTemplate.convertAndSend(queue, savedOrder);
        log.info("Sent to order queue");
        jmsTemplate.convertAndSend(topic, savedOrder);
        log.info("Sent to order topic");
        return savedOrder;

    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
