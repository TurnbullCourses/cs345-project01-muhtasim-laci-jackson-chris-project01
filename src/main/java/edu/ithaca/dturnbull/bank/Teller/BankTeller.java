package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;
import edu.ithaca.dturnbull.bank.Customer.Customer;

public class BankTeller extends AbstractTeller {

    
    public BankTeller(int id, String password){
        this.id = id;
        this.password = password;

    }



    @Override
    public void createAccount(Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal){
        if(accountType == 0){
            existCustomer.setCheckingsAccount(new CheckingAccount(startBal));
        }
        else if(accountType == 1){
            existCustomer.setSavingsAccount(new SavingsAccount(startBal, withdrawLimit, percentInt));
        }
        else{
            existCustomer.setCheckingsAccount(new CheckingAccount(startBal));
            existCustomer.setSavingsAccount(new SavingsAccount(startBal, withdrawLimit, percentInt));
        }

        
    }

    public Customer createAccount(int customerId, String password, int accountType, double withdrawLimit, double percentInt, double startBal){
        Customer customer = new Customer(customerId, password);
        createAccount(customer, accountType, withdrawLimit, percentInt, startBal);

        return customer;
    }

   
    
}
