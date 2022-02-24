package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Customer.Customer;

public class BankTeller extends AbstractTeller {
    protected String username;
    protected String password;
    protected boolean confirmed;
    protected Customer currentCustomer;
    protected AbstractAccount checkingsAccount;
    protected AbstractAccount savingsAccount;


    
    public BankTeller(){
        confirmed = false;

    }   

    public boolean createAccount(){
        Customer customer = new Customer(username, password, checkingsAccount, savingsAccount); 
        



        return false;
        
        

    }



     


    
}
