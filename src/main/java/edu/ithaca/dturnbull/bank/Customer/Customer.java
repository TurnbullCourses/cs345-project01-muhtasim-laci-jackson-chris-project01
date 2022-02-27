package edu.ithaca.dturnbull.bank.Customer;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
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

    /** 
     * @return customer id
     */
    public int getid(){
        return customerId;
    }

    /**
     * gets customer password
     * @return the customer password
     */
    public String getPassword(){
        return password;
    }

    /**
     * sets the checking account parameter
     * @param checkingAccount checking account to add
     */
    public void setCheckingsAccount(CheckingAccount checkingAccount){
        if (this.checkingAccount == null){
            this.checkingAccount = checkingAccount;
            this.balance = this.balance + checkingAccount.getBalance();
        }
    }
    
    /**
     * sets the savings account parameter
     * @param savingsAccuont savings account to add
     */
    public void setSavingsAccount(SavingsAccount savingsAccount){
        if (this.savingsAccount == null){
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
    
    public void depositSavingsAccount(double amount){
        if (savingsAccount != null){
            savingsAccount.deposit(amount);
        }
    }
    
    /*
    * 
    */
    public void depositCheckingAccount(double amount){
        if (checkingAccount != null){
            checkingAccount.deposit(amount);
        }
    }
    
    /*
    * 
    */
    public void withdrawSavingsAccount(double amount) throws InsufficientFundsException{
        if (savingsAccount != null){
            savingsAccount.withdraw(amount);
        }
    }
    
    /*
    * 
    */
    public void withdrawCheckingAccount(double amount) throws InsufficientFundsException{
        if (checkingAccount != null){
            checkingAccount.withdraw(amount);
        }
    }
    
    /*
    * 
    */
    public void transferSavingsAccount(double amount, Customer customerToTransferTo) throws InsufficientFundsException{
        if (savingsAccount != null){
            savingsAccount.transfer(amount, customerToTransferTo.getSavingsAccount());
        }
    }
    
    /*
    * @ amount
    */
    public void transferCheckingAccount(double amount, Customer customerToTransferTo) throws InsufficientFundsException{
        if (checkingAccount != null){
            checkingAccount.transfer(amount, customerToTransferTo.getCheckingAccount());
        }
    }

    /*
    * Get the balance from the savings account
    */
    public double getSavingsBalance(){
        if (savingsAccount != null){
            return savingsAccount.getBalance();
        }
        return -1.0;
    }
    
    /*
    * Get the balance from the savings account
    */
    public double getCheckingBalance(){
        if (checkingAccount != null){
            return checkingAccount.getBalance();
        }
        return -1.0;
    }    
}
