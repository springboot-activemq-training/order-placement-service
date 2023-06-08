package com.alpha.orderingservice.payload;

import lombok.Data;

@Data
public class OrderPayload {
    private String productName;
    private Integer quantity;
    private Double price;
}
