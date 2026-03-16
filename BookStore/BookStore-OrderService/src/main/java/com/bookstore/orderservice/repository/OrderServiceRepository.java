package com.bookstore.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.orderservice.model.Order;

public interface OrderServiceRepository extends JpaRepository<Order, Long>{

}
