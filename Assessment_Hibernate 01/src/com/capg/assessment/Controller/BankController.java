package com.capg.assessment.Controller;

import java.util.Scanner;

import com.capg.assessment.Service.BankService;
import com.capg.assessment.Service.BankServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankController {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);


        Scanner sc = new Scanner(System.in);
        BankService service = new BankServiceImpl();

        int choice;
        int cont = 1;

        while (cont == 1) {

            System.out.println("1.Create Account");
            System.out.println("2.Show Balance");
            System.out.println("3.Deposit");
            System.out.println("4.Withdraw");
            System.out.println("5.Fund Transfer");
            System.out.println("Enter choice:");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("Enter Account Number:");
                int acc = sc.nextInt();

                System.out.println("Enter Name:");
                String name = sc.next();

                System.out.println("Enter Mobile:");
                long mobile = sc.nextLong();

                System.out.println("Enter Initial Balance:");
                double balance = sc.nextDouble();

                service.createAccount(acc, name, mobile, balance);

                System.out.println("Account Created Successfully");
                break;

            case 2:
                System.out.println("Enter Account Number:");
                int accBal = sc.nextInt();

                double bal = service.showBalance(accBal);
                System.out.println("Your Account Balance is: " + bal);
                break;

            case 3:
                System.out.println("Enter Account Number:");
                int accDep = sc.nextInt();

                System.out.println("Enter Amount to Deposit:");
                double depAmount = sc.nextDouble();

                service.deposit(accDep, depAmount);
                System.out.println("Amount Deposited Successfully");
                break;

            case 4:
                System.out.println("Enter Account Number:");
                int accWith = sc.nextInt();

                System.out.println("Enter Amount to Withdraw:");
                double withAmount = sc.nextDouble();

                service.withdraw(accWith, withAmount);
                System.out.println("Amount Withdrawn Successfully");
                break;

            case 5:
                System.out.println("Enter From Account Number:");
                int fromAcc = sc.nextInt();

                System.out.println("Enter To Account Number:");
                int toAcc = sc.nextInt();

                System.out.println("Enter Amount to Transfer:");
                double transferAmount = sc.nextDouble();

                service.fundTransfer(fromAcc, toAcc, transferAmount);
                System.out.println("Fund Transferred Successfully");
                break;

            default:
                System.out.println("Invalid Choice");
        }


            System.out.println("Enter 1 to Continue or 0 to Exit");
            cont = sc.nextInt();
        }
    }
}
