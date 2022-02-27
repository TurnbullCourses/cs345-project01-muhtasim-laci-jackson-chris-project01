package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
//import edu.ithaca.dturnbull.bank.Account.Account;
import edu.ithaca.dturnbull.bank.Customer.Customer;

import java.util.Scanner;
import java.util.Random;


public abstract class AbstractTeller {
    protected String username;
    protected String password;
    protected boolean confirmed;
    protected Customer currentCustomer;


    public boolean login(String username, String password){
        if (this.username.equals(username)){
            if (this.password.equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }


    public int accountPin(){
        System.out.println("Create 4 digit pin");
        Scanner input2 = new Scanner(System.in);
        int pin = input2.nextInt();
        input2.close();
        return pin;
    }
    

    public int accountNumber(){
        Random random = new Random();
        int accountNum = (int)(random.nextInt()*5000);

        return accountNum;
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








    


    



    
}
