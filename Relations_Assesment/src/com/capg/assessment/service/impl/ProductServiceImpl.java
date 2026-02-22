package com.capg.assessment.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capg.assessment.entity.Product;
import com.capg.assessment.service.ProductService;
import com.capg.assessment.util.JPAUtil;

public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(String name, double price) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Product product = new Product(name, price);
            em.persist(product);

            tx.commit();
            System.out.println("Product added successfully.");

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error while adding product: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Product getProductById(Long productId) {

        EntityManager em = JPAUtil.getEntityManager();
        Product product = null;

        try {
            product = em.find(Product.class, productId);
        } catch (Exception e) {
            System.out.println("Error while fetching product: " + e.getMessage());
        } finally {
            em.close();
        }

        return product;
    }

    @Override
    public void deleteProduct(Long productId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Product product = em.find(Product.class, productId);

            if (product != null) {
                em.remove(product);
                tx.commit();
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found with ID: " + productId);
            }

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error while deleting product: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}