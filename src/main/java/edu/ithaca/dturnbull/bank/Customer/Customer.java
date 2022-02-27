package edu.ithaca.dturnbull.bank.Customer;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;


public class Customer {
    private String password;
    private int customerId;
    private AbstractAccount savingsAccount;
    private AbstractAccount checkingAccount;

    public Customer(int customerId, String password){
        this.customerId = customerId;
        this.password = password;
        savingsAccount = null;
        checkingAccount = null;
    }

    
    /** 
    * @return customer ID number
    */
    public int getid(){
        return customerId;
    }
    /** 
    * @return customer password 
    */
    public String getPassword(){
        return password;
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
        if (savingsAccount != null){
            savingsAccount.deposit(amount);
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    /**
     * @param amount is amount to dpeosit
     */
    public void depositCheckingAccount(double amount){
        if (checkingAccount != null){
            checkingAccount.deposit(amount);
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    /**
     * @param amount is amount to withdraw
     * @throws InsufficientFundsException
     */
    public void withdrawSavingsAccount(double amount) throws InsufficientFundsException{
        if (savingsAccount != null){
            savingsAccount.withdraw(amount);
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    /**
     * @param amount is amount to withdraw
     * @throws InsufficientFundsException
     */
    public void withdrawCheckingAccount(double amount) throws InsufficientFundsException{
        if(checkingAccount != null){
            checkingAccount.withdraw(amount);
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    /**
     * @param amount is amount to transfer
     * @param customerID is the customer to transfer to
     * @throws InsufficientFundsException
     */
    public void transferSavingsAccount(double amount, Customer customer) throws InsufficientFundsException{
        if (savingsAccount != null){
            savingsAccount.transfer(amount, customer.getSavingsAccount());
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    /**
     * @param amount is amount to transfer
     * @param customerID is the customer to transfer to
     * @throws InsufficientFundsException
     */
    public void transferCheckingAccount(double amount, Customer customer) throws InsufficientFundsException{
        if (checkingAccount != null){
            checkingAccount.transfer(amount, customer.getCheckingAccount());
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }

    /**
    * @return Get the balance from the savings account
    */
    public double getSavingsBalance(){
        if (savingsAccount != null){
            return savingsAccount.getBalance();
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    /**
    * @return Get the balance from the checking account
    */
    public double getCheckingBalance(){
        if (checkingAccount != null){
            return checkingAccount.getBalance();
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
    
    public CheckingAccount getCheckingAccount(){
        if (checkingAccount != null){
            return (CheckingAccount) checkingAccount;
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }

    public SavingsAccount getSavingsAccount(){
        if (savingsAccount != null){
            return (SavingsAccount) savingsAccount;
        }else{
            throw new IllegalArgumentException("This account does not exist");
        }
    }
}
