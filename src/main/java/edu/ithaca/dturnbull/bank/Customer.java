package edu.ithaca.dturnbull.bank;

public class Customer {

    private String username;
    private String password;
    private double balance;

    public Customer(String username, String password){
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }

    /**
     * Method to login to a particular customer's information
     * @param username - the username to the customer
     * @param password password to the customer
     * @return boolean indicating if they match or not
     */
    public boolean login(String username, String password){
        return true;
    }

    public double getBalance(){
        return balance;
    }
    
}
