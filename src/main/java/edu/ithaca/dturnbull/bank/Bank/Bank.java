package edu.ithaca.dturnbull.bank.Bank;

import java.util.ArrayList;
import java.util.List;

import edu.ithaca.dturnbull.bank.Teller.AbstractTeller;
import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Admin.BankAdmin;
import edu.ithaca.dturnbull.bank.Customer.Customer;

public class Bank {

    private List<AbstractAccount> accounts;
    private List<AbstractTeller> tellers;
    private List<BankAdmin> admins;
    private List<Customer> customers;
    private int nextId;

    public Bank(){
        accounts = new ArrayList<>();
        tellers = new ArrayList<>();
        admins = new ArrayList<>();
        customers = new ArrayList<>();
        nextId = 0;
    }

    public void addAccount(AbstractAccount account){
        accounts.add(account);
    }

    public void addTeller(AbstractTeller teller){
        tellers.add(teller);
    }

    public void addAdmin(BankAdmin admin){
        admins.add(admin);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        nextId++;
    }

    public List<AbstractAccount> getAccounts(){
        return accounts;
    }

    public List<AbstractTeller> getTellers(){
        return tellers;
    }

    public List<BankAdmin> getAdmins(){
        return admins;
    }

    public List<Customer> getCustomers(){
        return customers;
    }


    
}
