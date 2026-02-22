package com.capg.assessment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.dao.TicketDAO;
import com.capg.assessment.entity.SupportTicket;
import com.capg.assessment.util.JPAUtil;

public class TicketDAOImpl implements TicketDAO {

    @Override
    public void save(SupportTicket ticket) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(ticket);
        tx.commit();
        em.close();
    }

    @Override
    public SupportTicket findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        SupportTicket ticket = em.find(SupportTicket.class, id);
        em.close();
        return ticket;
    }

    @Override
    public void delete(SupportTicket ticket) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.merge(ticket));
        tx.commit();
        em.close();
    }
}