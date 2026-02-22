package com.capg.assessment.service;

import com.capg.assessment.entity.Product;

public interface ProductService {

    // Add new product
    void addProduct(String name, double price);

    // Find product by Id
    Product getProductById(Long productId);

    // Delete product
    void deleteProduct(Long productId);
}