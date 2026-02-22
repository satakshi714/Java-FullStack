package com.capg.assessment.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.entity.Address;
import com.capg.assessment.entity.Customer;
import com.capg.assessment.service.CustomerService;
import com.capg.assessment.util.JPAUtil;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void registerCustomer(String name, String email, String phone) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = new Customer(name, email, phone);
            em.persist(customer);

            tx.commit();
            System.out.println("Customer registered successfully.");

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error while registering customer: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void addAddressToCustomer(Long customerId, Address address) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer != null) {
                customer.setAddress(address);
                em.merge(customer);
                tx.commit();
                System.out.println("Address added to customer successfully.");
            } else {
                System.out.println("Customer not found with ID: " + customerId);
            }

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error while adding address: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) {

        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = null;

        try {
            customer = em.find(Customer.class, customerId);
        } catch (Exception e) {
            System.out.println("Error while fetching customer: " + e.getMessage());
        } finally {
            em.close();
        }

        return customer;
    }

    @Override
    public void deleteCustomer(Long customerId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer != null) {
                em.remove(customer);
                tx.commit();
                System.out.println("Customer deleted successfully.");
            } else {
                System.out.println("Customer not found with ID: " + customerId);
            }

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error while deleting customer: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}