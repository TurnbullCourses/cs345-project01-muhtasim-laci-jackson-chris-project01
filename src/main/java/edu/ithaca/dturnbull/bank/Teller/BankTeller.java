package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Customer.Customer;

public class BankTeller extends AbstractTeller {


    
    public BankTeller(){

    }



    @Override
    public void createAccount(Customer existCustomer, int accountType){
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

    public Customer createAccount(int customerId, String password, int accountType){
        Customer customer = new Customer(customerId, password);
        createAccount(customer, accountType);

        return customer;

    }
    
}
