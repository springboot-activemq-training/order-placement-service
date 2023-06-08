package com.alpha.orderingservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_data")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "product_name")
    private String productName; // product_name
    @Column(name = "quantity")
    private int quantity;
    private double price;
    private String status;

}
