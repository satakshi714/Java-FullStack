package com.capg.assessment.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.entity.Customer;
import com.capg.assessment.entity.Order;
import com.capg.assessment.entity.Product;
import com.capg.assessment.service.OrderService;
import com.capg.assessment.util.JPAUtil;

public class OrderServiceImpl implements OrderService {

    @Override
    public void placeOrder(Long customerId, List<Long> productIds) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }

            List<Product> products = new ArrayList<>();
            double totalAmount = 0;

            for (Long productId : productIds) {
                Product product = em.find(Product.class, productId);
                if (product != null) {
                    products.add(product);
                    totalAmount += product.getPrice();
                }
            }

            Order order = new Order();
            order.setOrderDate(new Date());
            order.setTotalAmount(totalAmount);
            order.setCustomer(customer);
            order.setProducts(products);

            em.persist(order);

            tx.commit();
            System.out.println("Order placed successfully. Total Amount = " + totalAmount);

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while placing order: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Order getOrderById(Long orderId) {

        EntityManager em = JPAUtil.getEntityManager();
        Order order = null;

        try {
            order = em.find(Order.class, orderId);
        } catch (Exception e) {
            System.out.println("Error while fetching order: " + e.getMessage());
        } finally {
            em.close();
        }

        return order;
    }

    @Override
    public void deleteOrder(Long orderId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Order order = em.find(Order.class, orderId);

            if (order != null) {
                em.remove(order);
                tx.commit();
                System.out.println("Order deleted successfully.");
            } else {
                System.out.println("Order not found with ID: " + orderId);
            }

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while deleting order: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}