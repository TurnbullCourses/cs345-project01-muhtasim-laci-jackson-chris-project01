package edu.ithaca.dturnbull.bank.Account;

public abstract class AbstractAccount {
    String email;
    double balance;

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
    public static boolean isEmailValid(String email){
        Boolean valid = true;
        String prefix = email.split("@")[0].toString();

        if (prefix.equals("")) {
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

        if (domain.equals("")) {
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
