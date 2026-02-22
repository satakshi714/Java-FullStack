package com.capg.assessment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.dao.LeadDAO;
import com.capg.assessment.entity.Lead;
import com.capg.assessment.util.JPAUtil;

public class LeadDAOImpl implements LeadDAO {

    @Override
    public void save(Lead lead) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(lead);
        tx.commit();
        em.close();
    }

    @Override
    public Lead findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Lead lead = em.find(Lead.class, id);
        em.close();
        return lead;
    }

    @Override
    public void update(Lead lead) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(lead);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(Lead lead) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.merge(lead));
        tx.commit();
        em.close();
    }
}