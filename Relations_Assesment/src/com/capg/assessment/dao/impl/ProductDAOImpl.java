package com.capg.assessment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.dao.ProductDAO;
import com.capg.assessment.entity.Product;
import com.capg.assessment.util.JPAUtil;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void save(Product product) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(product);
        tx.commit();
        em.close();
    }

    @Override
    public Product findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }

    @Override
    public void delete(Product product) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.merge(product));
        tx.commit();
        em.close();
    }
}