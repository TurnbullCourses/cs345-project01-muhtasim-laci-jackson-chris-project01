package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
//import edu.ithaca.dturnbull.bank.Account.Account;
//import edu.ithaca.dturnbull.bank.Customer.Customer;
import edu.ithaca.dturnbull.bank.Customer.Customer;

//import java.util.Scanner;
//import java.util.Random;


public abstract class AbstractTeller {

    protected int id;
    protected String password;
   

    public int getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }

    abstract AbstractAccount createAccount(Customer existCustomer, int accountType, double withdrawLimit, double per, double startVal);
    /**
     * @post checks to see if the @param num is valid
     */
    public static boolean isNumberValid(double num) {
        if (num < 0) {
            return false;
        }
        String numString = Double.toString(num); // convert number to string
        int decimalIndex = numString.indexOf("."); // Find index of ".""
        int decimalPlaces = numString.length() - decimalIndex - 1; // Subtract total length by the index of ".".
                                                                   // Subtract by an extra 1 to account for index 0
        return (decimalPlaces <= 2); // Check to see if decimal places is less than 2
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
    public abstract void transfer(AbstractAccount account, double amount, AbstractAccount transferee) throws InsufficientFundsException;
    
}
