package com.capg.assessment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.dao.CustomerDAO;
import com.capg.assessment.entity.Customer;
import com.capg.assessment.util.JPAUtil;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public void save(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(customer);
        tx.commit();
        em.close();
    }

    @Override
    public Customer findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Customer customer = em.find(Customer.class, id);
        em.close();
        return customer;
    }

    @Override
    public void update(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(customer);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Customer customer) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.merge(customer));
        tx.commit();
        em.close();
    }
}