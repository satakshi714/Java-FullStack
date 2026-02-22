package com.capg.assessment.dao;

import com.capg.assessment.entity.Order;

public interface OrderDAO {

    void save(Order order);

    Order findById(Long id);

    void delete(Order order);
}