package edu.ithaca.dturnbull.bank.Account;

public class SavingsAccount extends AbstractAccount{
    final double initialwithdrawLimit;
    private double withdrawLimit;
    private double percentInterest;
    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public SavingsAccount(String email, double startingBalance, double withdrawLimit, double percentInterest){
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
            throw new IllegalArgumentException("Starting Balance: " + startingBalance + " is invalid, cannot create account");
        }
        if (isNumberValid(withdrawLimit)){
            this.withdrawLimit = withdrawLimit;
            this.initialwithdrawLimit = withdrawLimit;
        }
        else{
            throw new IllegalArgumentException("Withdraw Limit: " + withdrawLimit + " is invalid, cannot create account");
        }
    }

    /**
     * @post reduces the balance by @param amount if amount is non-negative, smaller than balance and less than the withdraw limit.
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if (isNumberValid(amount)) { 
            if (amount <= withdrawLimit){    
                if (amount <= balance){
                    balance -= amount;
                    balance = Math.round(balance * 100.0) / 100.0; // Multiply by 100 and round to cut off all decimals past the 
                }else{                                             // hundreths place. Divide by 100 to make sure the number has two decimasl again                       
                    throw new InsufficientFundsException("Not enough money in the account.");
                }
            }else{
                throw new IllegalArgumentException("Amount to withdraw is greater than withdraw limit.");
            }
        }else{
            throw new IllegalArgumentException("Amount to withdraw is invalid.");
        }
    }

    /**
     * @post reduces the balance by @param amount if amount is non-negative, smaller than balance and withdrawLimit.
     * Deposits the same amount into @param transferee account.
     */
    public void transfer(double amount, SavingsAccount transferee) throws InsufficientFundsException {
        if (isNumberValid(amount)) { 
            if (amount <= withdrawLimit){    
                if (amount <= balance){
                    balance -= amount;
                    balance = Math.round(balance * 100.0) / 100.0;// Multiply by 100 and round to cut off all decimals past the
                    transferee.deposit(amount);                   // hundreths place. Divide by 100 to make sure the number has two decimasl again      
                }else{                                                              
                    throw new InsufficientFundsException("Not enough money in the account.");
                }
            }else{
                throw new IllegalArgumentException("Amount to withdraw is greater than withdraw limit.");
            }
        }else{
            throw new IllegalArgumentException("Amount to withdraw is invalid.");
        }
    }

    /**
     * @post changes the balance based on the interest and balance of the account
     */
    public double newBalance(){
        double interest = calculateInterest();
        balance +=interest;
        balance = Math.round(balance * 100.0) / 100.0; // Multiply by 100 and round to cut off all decimals past the
        return balance;                                // hundreths place. Divide by 100 to make sure the number has two decimasl again 
    }

    public double calculateInterest(){
        double interest = balance * percentInterest/100;
        interest = Math.round(interest * 100.0) / 100.0; // Multiply by 100 and round to cut off all decimals past the
        return interest;                                // hundreths place. Divide by 100 to make sure the number has two decimasl again 
    }
    
    public double getWithdrawLimit(){
        return withdrawLimit;
    }
    public void resetWithdrawLimit(){
        withdrawLimit = initialwithdrawLimit;
    }
}