package com.alpha.orderingservice.service.impl;

import com.alpha.orderingservice.model.Order;
import com.alpha.orderingservice.service.OrderService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
//    @Qualifier()
    private JmsTemplate jmsTemplate;



    @Override
    public Order createOrder(Order order) throws JMSException {

        ActiveMQTopic topic =  new ActiveMQTopic("order-topic");
        ActiveMQQueue queue = new ActiveMQQueue("order-queue");

        jmsTemplate.convertAndSend(queue, order);
        order.setStatus("success");

        jmsTemplate.convertAndSend(topic, order);

        return order;
    }
}
