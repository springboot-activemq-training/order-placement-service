package com.alpha.orderingservice.controller;

import com.alpha.orderingservice.dto.OrderDto;
import com.alpha.orderingservice.entity.Order;
import com.alpha.orderingservice.payload.OrderPayload;
import com.alpha.orderingservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String getAllOrders( Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orderList", orders);
        return "orders";
    }

    @GetMapping("/orders/new")
    public String newOrder(Model model)  {
        OrderPayload payload = new OrderPayload();
        model.addAttribute("orderPayload", payload);
        return "place_order";
    }

    @PostMapping("/orders")
    public String placeOrder(@ModelAttribute("orderPayload") OrderPayload orderPayload) {
       orderService.placeOrder(orderPayload);
        return "redirect:/orders";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
       orderService.deleteOrder(id);
        return "redirect:/orders";
    }



}
