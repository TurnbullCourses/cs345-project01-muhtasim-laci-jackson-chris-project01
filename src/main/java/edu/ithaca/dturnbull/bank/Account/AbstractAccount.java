package edu.ithaca.dturnbull.bank.Account;

import java.util.List;

public abstract class AbstractAccount {
    String email;
    double balance;
    List<String> history;

    /**
    * @post @return balance
    */
    public double getBalance(){
        return balance;
    }
    
    /**
    * @post @return email
    */
    public String getEmail(){
        return email;
    }

    /**
    * @post increases the balance by @param amount if amount is non-negative
    */
    public void deposit(double amount) throws IllegalArgumentException{
        if (isNumberValid(amount)) {
            balance += amount;
            balance = Math.round(balance * 100.0) / 100.0;
            appendTransaction(amount, "deposit");
        } else {
            throw new IllegalArgumentException("Amount to deposit is invalid");
        }
    }

    /**
     * @post reduces the balance by @param amount if amount is non-negative and smaller than balance
     */
    abstract void withdraw(double Amount)throws InsufficientFundsException;

    /**
     * @post reduces the balance by @param amount if amount is non-negative and smaller than balance
     * increases the balance of @param transferee 
     */
    abstract void transfer(double amount, AbstractAccount transferee)  throws InsufficientFundsException;

    /**
     * @post checks to see if the @param email is valid
     */
    public void appendTransaction(double amount, String action){
        this.history.add(toString(amount, action))
    }
    
    public String toString(double amount, String action){
        if (action.equals("deposit")){
            return "Deposited " + amount; 
        }else if(action.equals("withdraw")){
            return "Withdrew " + amount;
        }
        return action + amount;
    }

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
}
