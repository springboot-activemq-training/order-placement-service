package com.alpha.orderingservice.model;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String productName;
    private int quantity;
    private double price;
    private String status;
}
