package com.capg.assessment.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.entity.Customer;
import com.capg.assessment.entity.Lead;
import com.capg.assessment.entity.SalesEmployee;
import com.capg.assessment.service.LeadService;
import com.capg.assessment.util.JPAUtil;

public class LeadServiceImpl implements LeadService {

    @Override
    public void createLead(String name, String source, String contactInfo) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = new Lead(name, source, contactInfo);
            em.persist(lead);

            tx.commit();
            System.out.println("Lead created successfully.");

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while creating lead: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void assignLeadToEmployee(Long leadId, Long employeeId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = em.find(Lead.class, leadId);
            SalesEmployee employee = em.find(SalesEmployee.class, employeeId);

            if (lead != null && employee != null) {
                lead.setEmployee(employee);
                em.merge(lead);
                tx.commit();
                System.out.println("Lead assigned to employee successfully.");
            } else {
                System.out.println("Lead or Employee not found.");
            }

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while assigning lead: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void convertLeadToCustomer(Long leadId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead = em.find(Lead.class, leadId);

            if (lead != null) {

                Customer customer = new Customer();
                customer.setName(lead.getName());
                customer.setEmail(lead.getContactInfo());
                customer.setPhone("Not Available");

                em.persist(customer);
                em.remove(lead);

                tx.commit();
                System.out.println("Lead converted to Customer successfully.");
            } else {
                System.out.println("Lead not found.");
            }

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while converting lead: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Lead getLeadById(Long leadId) {

        EntityManager em = JPAUtil.getEntityManager();
        Lead lead = null;

        try {
            lead = em.find(Lead.class, leadId);
        } catch (Exception e) {
            System.out.println("Error while fetching lead: " + e.getMessage());
        } finally {
            em.close();
        }

        return lead;
    }
}