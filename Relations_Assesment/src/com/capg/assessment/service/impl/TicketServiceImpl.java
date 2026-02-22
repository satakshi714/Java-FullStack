package com.capg.assessment.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.entity.Order;
import com.capg.assessment.entity.SupportTicket;
import com.capg.assessment.service.TicketService;
import com.capg.assessment.util.JPAUtil;

public class TicketServiceImpl implements TicketService {

    @Override
    public void raiseTicket(Long orderId, String issueDescription) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Order order = em.find(Order.class, orderId);

            if (order != null) {
                SupportTicket ticket = new SupportTicket(issueDescription);
                ticket.setOrder(order);

                em.persist(ticket);
                tx.commit();
                System.out.println("Support ticket raised successfully.");
            } else {
                System.out.println("Order not found with ID: " + orderId);
            }

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while raising ticket: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public SupportTicket getTicketById(Long ticketId) {

        EntityManager em = JPAUtil.getEntityManager();
        SupportTicket ticket = null;

        try {
            ticket = em.find(SupportTicket.class, ticketId);
        } catch (Exception e) {
            System.out.println("Error while fetching ticket: " + e.getMessage());
        } finally {
            em.close();
        }

        return ticket;
    }

    @Override
    public void deleteTicket(Long ticketId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            SupportTicket ticket = em.find(SupportTicket.class, ticketId);

            if (ticket != null) {
                em.remove(ticket);
                tx.commit();
                System.out.println("Ticket deleted successfully.");
            } else {
                System.out.println("Ticket not found with ID: " + ticketId);
            }

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while deleting ticket: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}