package com.capg.assessment.DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.capg.assessment.Bean.BankBean;

import antlr.collections.List;

public class BankDAOImpl implements bankDAO {

    private static SessionFactory factory;

    static {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(BankBean.class)
                .buildSessionFactory();
    }

    @Override
    public void createAccount(int accno, String name, long mobile, double balance) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        BankBean bean = new BankBean(accno, name, mobile, balance);
        session.save(bean);

        tx.commit();
        session.close();
    }

    // keep other methods same

    @Override
    public double showBalance(int accno) {

        Session session = factory.openSession();
        BankBean bean = session.get(BankBean.class, accno);
        session.close();

        return bean.getBalance();
    }

    @Override
    public void deposit(int accno, double amount) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        BankBean bean = session.get(BankBean.class, accno);
        bean.setBalance(bean.getBalance() + amount);

        tx.commit();
        session.close();
    }

    @Override
    public void withdraw(int accno, double amount) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        BankBean bean = session.get(BankBean.class, accno);
        bean.setBalance(bean.getBalance() - amount);

        tx.commit();
        session.close();
    }

    @Override
    public void fundTransfer(int fromAcc, int toAcc, double amount) {

        withdraw(fromAcc, amount);
        deposit(toAcc, amount);
    }

    @Override
    public java.util.List printTransactions(int accno) {

        Session session = factory.openSession();

        List list = (List) session
                .createQuery("select transaction from transactions where accno=:a")
                .setParameter("a", accno)
                .list();

        session.close();
        return list == null ? new ArrayList<>() : (java.util.List) list;
    }
}
