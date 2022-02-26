package edu.ithaca.dturnbull.bank.Customer;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;

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

    /**
     * get total balance accross all accounts
     * @return
     */
    public double getBalance(){
        return balance;
    }

    public int getid(){
        return customerId;
    }

    public String getPassword(){
        return password;
    }

    public void setCheckingsAccount(CheckingAccount checkingAccount){
        if (this.checkingAccount == null){
            this.checkingAccount = checkingAccount;
            this.balance = this.balance + checkingAccount.getBalance();
        }
    }

    public void setSavingsAccount(SavingsAccount savingsAccount){
        if (this.checkingAccount == null){
            this.savingsAccount = savingsAccount;
            this.balance = this.balance + savingsAccount.getBalance();
        }
    }

    public AbstractAccount getSavingsAccount(){
        return savingsAccount;
    }

    public AbstractAccount getCheckingAccount(){
        return checkingAccount;
    }
    
}
