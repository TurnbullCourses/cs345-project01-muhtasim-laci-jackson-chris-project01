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

    /*
    * 
    */
    public double getBalance(){
        return balance;
    }
    /*
    * 
    */
    public int getid(){
        return customerId;
    }
    
    /*
    * 
    */
    public void setCheckingAccount(CheckingAccount checkingAccount){
        this.checkingAccount = checkingAccount;
    }
    
    /*
    * 
    */
    public void setSavingsAccount(SavingsAccount savingsAccount){
        this.savingsAccount = savingsAccount;
    }
    
    /*
    * 
    */
    public void depositSavingsAccount(double amount){
        if savingsAccount != null{
            savingsAccount.deposit(amount);
        }
    }
    
    /*
    * 
    */
    public void depositCheckingAccount(double amount){
        if checkingAccount != null{
            checkingAccount.deposit(amount);
        }
    }
    
    /*
    * 
    */
    public void withdrawSavingsAccount(double amount){
        if savingsAccount != null{
            savingsAccount.withdraw(amount);
        }
    }
    
    /*
    * 
    */
    public void withdrawCheckingAccount(double amount){
        if checkingAccount != null{
            checkingAccount.withdraw(amount);
        }
    }
    
    /*
    * 
    */
    public void transferSavingsAccount(double amount, int customerID){
        if savingsAccount != null{
            savingsAccount.transfer(amount, bank.getCustomers().get(id).getSavingsAccount());
        }
    }
    
    /*
    * @ amount
    */
    public void transferCheckingAccount(double amount, int customerID){
        if checkingAccount != null{
            checkingAccount.transfer(amount, bank.getCustomers().get(id).getCheckingAccount());
        }
    }

    /*
    * Get the balance from the savings account
    */
    public double getSavingsBalance(){
        if savingsAccount != null{
            return savingsAccount.getBalance()
        }
    }
    
    /*
    * Get the balance from the savings account
    */
    public double getCheckingBalance(){
        if checkingAccount != null{
            return checkingAccount.getBalance()
        }
    }    
}
