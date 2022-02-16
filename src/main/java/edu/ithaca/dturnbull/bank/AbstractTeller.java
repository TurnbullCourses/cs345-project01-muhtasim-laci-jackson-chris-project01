package edu.ithaca.dturnbull.bank;

public abstract class AbstractTeller {
    protected String username;
    protected String password;
    protected boolean confirmed;
    protected Customer currentCustomer;


    
    public abstract boolean login(String username, String password);

    public abstract void createAccount();



    
}
