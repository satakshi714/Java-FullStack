package com.capg.assessment.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    @SequenceGenerator(name = "prod_seq", sequenceName = "PROD_SEQ", allocationSize = 1)
    private Long productId;

    private String productName;
    private double price;

    public Product() {}

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    // getters and setters
}