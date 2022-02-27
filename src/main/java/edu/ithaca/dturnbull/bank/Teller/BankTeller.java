package edu.ithaca.dturnbull.bank.Teller;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;
import edu.ithaca.dturnbull.bank.Customer.Customer;

public class BankTeller extends AbstractTeller {

    
    public BankTeller(int id, String password){
        this.id = id;
        this.password = password;

    }



    @Override
    public AbstractAccount createAccount(Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal){
        if(accountType == 0){
            CheckingAccount account = new CheckingAccount(startBal);
            existCustomer.setCheckingAccount(account);
            return account;
        }
        else if(accountType == 1){
            SavingsAccount account = new SavingsAccount(startBal, withdrawLimit, percentInt);
            existCustomer.setSavingsAccount(account);
            return account;
        }
        else{
            existCustomer.setCheckingAccount(new CheckingAccount(startBal));
            existCustomer.setSavingsAccount(new SavingsAccount(startBal, withdrawLimit, percentInt));
            return null;
        }

        
    }

    public Customer createAccount(int customerId, String password, int accountType, double withdrawLimit, double percentInt, double startBal){
        Customer customer = new Customer(customerId, password);
        createAccount(customer, accountType, withdrawLimit, percentInt, startBal);
        return customer;
    }

}
