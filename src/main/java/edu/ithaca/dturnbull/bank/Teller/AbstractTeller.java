package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Customer.Customer;




public abstract class AbstractTeller {
    protected int id;
    protected String password;


    abstract void createAccount(Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal);
    public int getId(){
        return id;
    }

    public String getPassword(){
        return password;
    }

    



}
