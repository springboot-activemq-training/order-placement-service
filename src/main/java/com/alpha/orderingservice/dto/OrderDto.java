package com.alpha.orderingservice.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int id;
    private String productName;
    private int quantity;
    private double price;
    private String status;
}
