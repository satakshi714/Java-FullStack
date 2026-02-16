package com.capg.assessment.Service;

import java.util.List;

import com.capg.assessment.DAO.BankDAOImpl;
import com.capg.assessment.DAO.bankDAO;

public class BankServiceImpl implements BankService {

    private bankDAO dao = new BankDAOImpl();

    @Override
    public void createAccount(int accno, String name, long mobile, double balance) {
        dao.createAccount(accno, name, mobile, balance);
    }

    @Override
    public double showBalance(int accno) {
        return dao.showBalance(accno);
    }

    @Override
    public void deposit(int accno, double amount) {
        dao.deposit(accno, amount);
    }

    @Override
    public void withdraw(int accno, double amount) {
        dao.withdraw(accno, amount);
    }

    @Override
    public void fundTransfer(int fromAcc, int toAcc, double amount) {
        dao.fundTransfer(fromAcc, toAcc, amount);
    }

    @Override
    public List<String> printTransactions(int accno) {
        return dao.printTransactions(accno);
    }
}
