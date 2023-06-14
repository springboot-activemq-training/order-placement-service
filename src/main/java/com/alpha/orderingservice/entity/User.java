package com.alpha.orderingservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_data")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userName;
    private String password;
}
