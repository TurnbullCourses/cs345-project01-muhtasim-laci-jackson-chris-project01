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
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
        if(isNumberValid(startingBalance)){
            this.balance = startingBalance;
        }
        else{
            throw new IllegalArgumentException("Value: " + startingBalance + " is an invalid starting balance, cannot create account");
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
        if (isNumberValid(amount)) {    
            if (amount <= balance){
                balance -= amount;
                balance = Math.round(balance * 100.0) / 100.0; // Multiply by 100 and round to cut off all 
            }                                                  // decimals past the hundreths place. Divide by 100
            else {                                             // to make sure the number has two decimasl again
                throw new InsufficientFundsException("Not enough money");
            }
        }else{
            throw new IllegalArgumentException("Amount to withdraw is invalid");
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
            Boolean valid = true;
            String prefix = email.split("@")[0].toString();
    
            if (prefix == "") {
                return false;
            }
    
            if (prefix.startsWith(".") || prefix.startsWith("!") || prefix.startsWith("#") || prefix.startsWith("'")) {
                return false;
            }
    
            if (prefix.contains("@")) {
                return false;
            }
    
            if (prefix.endsWith("-")) {
                return false;
            }        
    
            if (prefix.contains("#")) {
                return false;
            }
        
            if (email.indexOf('@') == -1){
                return false;
            } 
    
            if (email.endsWith("@")) {
                return false;
            }
    
            //check domain
            String domain = email.split("@")[1].toString();
    
            if (!domain.contains(".")) {
                return false;
            }
    
            if (domain.contains("@")) {
                return false;
            }
    
            if (domain == "") {
                return false;
            }
            
            String domainLastPortion = domain.split("\\.")[1].toString();
            if (domain.contains("#") || domain.contains("'")) {
                return false;
            }
    
            if (domainLastPortion.length() < 2) {
                return false;
            }
    
            return valid;
        }

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
        return (decimalPlaces <= 2); // Check to see if decimal places is less than 2
    }

    public static Double add(Double num1, Double num2){
        Double value = num1 + num2;
        return value;

    }
}