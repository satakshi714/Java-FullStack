package com.capg.assessment.service;

import com.capg.assessment.entity.Address;
import com.capg.assessment.entity.Customer;

public interface CustomerService {

    // Register a new customer
    void registerCustomer(String name, String email, String phone);

    // Add address to existing customer
    void addAddressToCustomer(Long customerId, Address address);

    // Find customer by id
    Customer getCustomerById(Long customerId);

    // Delete customer
    void deleteCustomer(Long customerId);
}