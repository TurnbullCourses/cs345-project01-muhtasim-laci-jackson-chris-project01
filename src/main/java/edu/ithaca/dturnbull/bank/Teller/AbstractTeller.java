package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
<<<<<<< HEAD
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
//import edu.ithaca.dturnbull.bank.Account.Account;
=======
>>>>>>> 3a9e8211de162fac9841c8a8a4482655651e4470
import edu.ithaca.dturnbull.bank.Customer.Customer;




public abstract class AbstractTeller {
<<<<<<< HEAD

    protected int id;
    protected String password;

    private boolean checkAmount(double amount, AbstractAccount account){
        boolean pass = false;
        if (amount > 0 && amount < account.getBalance()){
            pass = true;
        }
        return pass;
    }

    /**
    * @post @return balance of checking or savings account
    */
    public abstract double getBalance(AbstractAccount account);

        /**
     * @post reduces the balance of checking or savings account by @param amount if amount is 
     * non-negative and smaller than balance
     */
    public abstract void withdraw(double amount, AbstractAccount account) throws InsufficientFundsException;
    
        /**
    * @post increases the balance by @param amount if amount is non-negative
    */
    public abstract void deposit(double amount, AbstractAccount account) throws InsufficientFundsException;

    /**
     * @post reduces the balance by @param amount if amount is non-negative and smaller than balance
     * increases the balance of @param transferee 
     */
    public abstract void transfer(int accountNumberTo, double amount, AbstractAccount transferee);











    

=======
    protected int id;
    protected String password;


    abstract AbstractAccount createAccount(Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal);
    public int getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }
>>>>>>> 3a9e8211de162fac9841c8a8a4482655651e4470

    



}
