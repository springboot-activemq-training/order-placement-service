package com.alpha.orderingservice.repository;

import com.alpha.orderingservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByProductName(String productName);

    @Query(value ="select * from order", nativeQuery = true)
    List<Order> findAllOrders();

}
