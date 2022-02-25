package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Customer.Customer;

public class BankTeller extends AbstractTeller {
    private int customerId;
    private String password;


    
    public BankTeller(){

    }



    @Override
    public void createAccount(Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal){
        if(accountType == 0){
            existCustomer.setCheckingsAccount(new CheckingsAccount());
        }
        else if(accountType == 1){
            existCustomer.setSavingsAccount(new SavingsAccount());
        }
        else{
            existCustomer.setCheckingsAccount(new CheckingAccount());
            existCustomer.setSavingsAccount(new SavingsAccount());
        }

        
    }

    public Customer createAccount(int customerId, String password, int accountType, double withdrawLimit, double percentInt, double startBal){
        Customer customer = new Customer(customerId, password);
        createAccount(customer, accountType);

        return customer;
    }
    
}
