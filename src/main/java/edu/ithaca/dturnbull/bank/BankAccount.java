package edu.ithaca.dturnbull.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }
    /**
    * @post increases the balance by amount if amount is non-negative
    */
    public void deposit(double amount) {
        if (isNumberValid(amount)) {
            balance += amount;
            balance = Math.round(balance * 100.0) / 100.0;
        } else {
            throw new IllegalArgumentException("Amount to deposit is invalid");
        }
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

    public void transfer(double amount, BankAccount transferAccount) throws InsufficientFundsException{ //EDIT - throws both types of exceptions based on condition, changed variable name to transferAccount
        if (isNumberValid(amount) == true && amount < balance){
            balance -= amount;
            transferAccount.balance += amount;
        }
        else if (amount > balance){
            throw new InsufficientFundsException("Not enough money!");
        }
        else{
            throw new IllegalArgumentException("You can't deposit an amount with more than 2 decimal places");
            }
        }


    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }
    //test
    /**
     * @post checks to see if the number is valid
     */
    public static boolean isNumberValid(double num) {
        if (num < 0) {
            return false;
        }
        String numString = Double.toString(num); // convert number to string
        int decimalIndex = numString.indexOf("."); // Find index of ".""
        int decimalPlaces = numString.length() - decimalIndex - 1; // Subtract total length by the index of ".".
                                                                   // Subtract by an extra 1 to account for index 0
        return (decimalPlaces > 2); // Check to see if decimal places is less than 2
    }
}