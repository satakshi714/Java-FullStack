package com.capg.assessment.dao;

import com.capg.assessment.entity.Customer;

public interface CustomerDAO {

    void save(Customer customer);

    Customer findById(Long id);

    void update(Customer customer);

    void delete(Customer customer);
}