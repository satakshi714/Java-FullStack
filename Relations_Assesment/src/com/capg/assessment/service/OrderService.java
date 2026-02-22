package com.capg.assessment.service;

import java.util.List;
import com.capg.assessment.entity.Order;

public interface OrderService {

    // Place an order for a customer with selected products
    void placeOrder(Long customerId, List<Long> productIds);

    // Find order by Id
    Order getOrderById(Long orderId);

    // Delete order
    void deleteOrder(Long orderId);
}