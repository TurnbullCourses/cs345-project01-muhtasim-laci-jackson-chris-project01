package edu.ithaca.dturnbull.bank.Customer;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;

public class Customer {
    private String password;
    private double balance;
    private int customerId;
    private AbstractAccount savingsAccount;
    private AbstractAccount checkingAccount;

    public Customer(int customerId, String password){
        this.customerId = customerId;
        this.password = password;
        this.balance = 0.0;
        savingsAccount = null;
        checkingAccount = null;

    }

    public double getBalance(){
        return balance;
    }

    public int getid(){
        return customerId;
    }

    public void setCheckingsAccount(CheckingAccount checkingAccount){
        this.checkingAccount = checkingAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount){
        this.savingsAccount = savingsAccount;
        
    }
    
}
