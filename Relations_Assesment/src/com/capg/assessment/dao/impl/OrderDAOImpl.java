package com.capg.assessment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.dao.OrderDAO;
import com.capg.assessment.entity.Order;
import com.capg.assessment.util.JPAUtil;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void save(Order order) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(order);
        tx.commit();
        em.close();
    }

    @Override
    public Order findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Order order = em.find(Order.class, id);
        em.close();
        return order;
    }

    @Override
    public void delete(Order order) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.merge(order));
        tx.commit();
        em.close();
    }
}