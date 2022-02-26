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
<<<<<<< HEAD
=======

    }

    /**
     * get total balance accross all accounts
     * @return
     */
    public double getBalance(){
        return balance;
>>>>>>> origin/bankClassBranch
    }

    
    /** 
    * @return customer ID number
    */
    public int getid(){
        return customerId;
    }
<<<<<<< HEAD
    
    public String getpassword(){
        return password;
=======

    public String getPassword(){
        return password;
    }

    public void setCheckingsAccount(CheckingAccount checkingAccount){
        this.checkingAccount = checkingAccount;
        this.balance = this.balance + checkingAccount.getBalance();
    }

    public void setSavingsAccount(SavingsAccount savingsAccount){
        this.savingsAccount = savingsAccount;
        this.balance = this.balance + savingsAccount.getBalance();
    }

    public AbstractAccount getSavingsAccount(){
        return savingsAccount;
    }

    public AbstractAccount getCheckingAccount(){
        return checkingAccount;
>>>>>>> origin/bankClassBranch
    }
    
    
    /** 
    * @param checkingAccount associates a checking account to a customer
    */
    public void setCheckingAccount(CheckingAccount checkingAccount){
        this.checkingAccount = checkingAccount;
    }
    
    /** 
    * @param savingsAccount associates a savings account to a customer
    */
    public void setSavingsAccount(SavingsAccount savingsAccount){
        this.savingsAccount = savingsAccount;
    }
    
    /**
     * @param amount is amount to dpeosit
     */
    public void depositSavingsAccount(double amount){
        if savingsAccount != null{
            savingsAccount.deposit(amount);
        }
    }
    
    /**
     * @param amount is amount to dpeosit
     */
    public void depositCheckingAccount(double amount){
        if checkingAccount != null{
            checkingAccount.deposit(amount);
        }
    }
    
    /**
     * @param amount is amount to withdraw
     */
    public void withdrawSavingsAccount(double amount){
        if savingsAccount != null{
            savingsAccount.withdraw(amount);
        }
    }
    
    /**
     * @param amount is amount to withdraw
     */
    public void withdrawCheckingAccount(double amount){
        if checkingAccount != null{
            checkingAccount.withdraw(amount);
        }
    }
    
    /**
     * @param amount is amount to transfer
     * @param customerID is the customer to transfer to
     */
    public void transferSavingsAccount(double amount, int customerID){
        if savingsAccount != null{
            savingsAccount.transfer(amount, bank.getCustomers().get(id).getSavingsAccount());
        }
    }
    
    /**
     * @param amount is amount to transfer
     * @param customerID is the customer to transfer to
     */
    public void transferCheckingAccount(double amount, int customerID){
        if checkingAccount != null{
            checkingAccount.transfer(amount, bank.getCustomers().get(id).getCheckingAccount());
        }
    }

    /**
    * @return Get the balance from the savings account
    */
    public double getSavingsBalance(){
        if savingsAccount != null{
            return savingsAccount.getBalance()
        }
    }
    
    /**
    * @return Get the balance from the checking account
    */
    public double getCheckingBalance(){
        if checkingAccount != null{
            return checkingAccount.getBalance()
        }
    }    
}
