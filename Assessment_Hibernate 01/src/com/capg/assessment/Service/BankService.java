package com.capg.assessment.Service;

import java.util.List;

public interface BankService {

    void createAccount(int accno, String name, long mobile, double balance);
    double showBalance(int accno);
    void deposit(int accno, double amount);
    void withdraw(int accno, double amount);
    void fundTransfer(int fromAcc, int toAcc, double amount);
    List<String> printTransactions(int accno);
}
