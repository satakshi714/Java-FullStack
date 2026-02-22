package com.capg.assessment.dao;

import com.capg.assessment.entity.Product;

public interface ProductDAO {

    void save(Product product);

    Product findById(Long id);

    void delete(Product product);
}