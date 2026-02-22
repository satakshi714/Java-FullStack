package com.capg.assessment.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ord_seq")
    @SequenceGenerator(name = "ord_seq", sequenceName = "ORD_SEQ", allocationSize = 1)
    private Long orderId;

    private String orderDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order() {}

    public Order(String orderDate, String status) {
        this.orderDate = orderDate;
        this.status = status;
    }

    // getters and setters
}