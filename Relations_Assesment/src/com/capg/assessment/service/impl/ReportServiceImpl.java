package com.capg.assessment.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.capg.assessment.entity.SalesEmployee;
import com.capg.assessment.service.ReportService;
import com.capg.assessment.util.JPAUtil;

public class ReportServiceImpl implements ReportService {

    @Override
    public void getEmployeePerformance(Long employeeId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            SalesEmployee employee = em.find(SalesEmployee.class, employeeId);

            if (employee == null) {
                System.out.println("Employee not found with ID: " + employeeId);
                return;
            }

            // JPQL query to count leads assigned to employee
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(l) FROM Lead l WHERE l.employee.id = :empId", Long.class);

            query.setParameter("empId", employeeId);

            Long leadCount = query.getSingleResult();

            System.out.println("Employee Performance Report");
            System.out.println("----------------------------");
            System.out.println("Employee Name : " + employee.getName());
            System.out.println("Department    : " + employee.getDepartment());
            System.out.println("Total Leads   : " + leadCount);

            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error while generating report: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}