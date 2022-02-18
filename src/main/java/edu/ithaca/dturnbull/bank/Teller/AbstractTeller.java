package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Customer.Customer;

public abstract class AbstractTeller {
    protected String username;
    protected String password;
    protected boolean confirmed;
    protected Customer currentCustomer;


    
    public abstract boolean login(String username, String password);

    public abstract void createAccount();



    
}
