package edu.ithaca.dturnbull.bank.Bank;

import java.util.ArrayList;
import java.util.List;

import edu.ithaca.dturnbull.bank.Teller.AbstractTeller;
import edu.ithaca.dturnbull.bank.Teller.BankTeller;
import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.BankAdmin.BankAdmin;
import edu.ithaca.dturnbull.bank.Customer.Customer;

public class Bank {

    private List<AbstractAccount> accounts;
    private List<AbstractTeller> tellers;
    private List<BankAdmin> admins;
    private List<Customer> customers;

    public Bank(){
        accounts = new ArrayList<>();
        tellers = new ArrayList<>();
        admins = new ArrayList<>();
        customers = new ArrayList<>();
    }

    /**
     * login a customer based off of their id and password
     * @param id customer id
     * @param password customer password
     * @return the customer that was logged in
     */
    public Customer customerLogIn(int id, String password){
        Customer customer;
        try{
            customer = customers.get(id);
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
        if (customer.getPassword().equals(password)){
            return customer;
        }
        else{
            return null;
        }

    }

    public AbstractTeller tellerLogIn(int id, String password){
        AbstractTeller teller;
        try{
            teller = tellers.get(id);
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
        if (teller.getPassword().equals(password)){
            return teller;
        }
        else{
            return null;
        }
    }

    public BankAdmin adminLogIn(int id, String password){
        BankAdmin admin;
        try{
            admin = admins.get(id);
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
        if (admin.getPassword().equals(password)){
            return admin;
        }
        else{
            return null;
        }
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

    public void createNewAccount(BankTeller teller, Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal){

    }

    public void createNewAccount(BankTeller teller, int customerId, String password, int accountType, double withdrawLimit, double percentInt, double startBal){
        
    }


    
}
