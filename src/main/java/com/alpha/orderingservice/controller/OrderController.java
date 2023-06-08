package com.alpha.orderingservice.controller;

import com.alpha.orderingservice.model.Order;
import com.alpha.orderingservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
 //   /api/orders/create
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) throws JMSException {
        return orderService.createOrder(order);
    }


}
