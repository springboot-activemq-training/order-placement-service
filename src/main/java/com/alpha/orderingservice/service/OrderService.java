package com.alpha.orderingservice.service;

import com.alpha.orderingservice.model.Order;

import javax.jms.JMSException;

public interface OrderService {
    Order createOrder(Order order) throws JMSException;
}
