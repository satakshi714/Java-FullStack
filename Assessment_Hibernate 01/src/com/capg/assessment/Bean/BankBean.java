package com.capg.assessment.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "bank_database")
public class BankBean {

	@Id
    private int accno;
    private String name;
    private long mobile;
    private double balance;

    
    //just declaring an empty default constructor for better understanding.
    public BankBean() {
    	
    }

    public BankBean(int accno, String name, long mobile, double balance) {
        this.accno = accno;
        this.name = name;
        this.mobile = mobile;
        this.balance = balance;
    }

    public int getAccno() {
    	return accno; 
    	}
    
    public void setAccno(int accno) {
    	this.accno = accno; 
    	}

    public String getName() {
    	return name; 
    	}
    
    public void setName(String name) {
    	this.name = name; 
    	}

    public long getMobile() {
    	return mobile; 
    	}
    public void setMobile(long mobile) {
    	this.mobile = mobile; 
    	}

    public double getBalance() {
    	return balance; 
    	}
    public void setBalance(double balance) {
    	this.balance = balance; 
    	}
}
