package com.capg.assessment.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("crmPU");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get EntityManager
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Close EntityManagerFactory
    public static void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}