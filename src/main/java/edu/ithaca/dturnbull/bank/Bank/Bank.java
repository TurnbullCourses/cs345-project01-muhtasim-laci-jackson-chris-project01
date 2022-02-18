package edu.ithaca.dturnbull.bank.Bank;

import java.util.ArrayList;
import java.util.List;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Teller.AbstractTeller;
import edu.ithaca.dturnbull.bank.Admin.BankAdmin;

public class Bank {

    private List<AbstractAccount> accounts;
    private List<AbstractTeller> tellers;
    private List<BankAdmin> admins;

    public Bank(){
        accounts = new ArrayList<>();
        tellers = new ArrayList<>();
        admins = new ArrayList<>();
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

    public List<AbstractAccount> getAccounts(){
        return accounts;
    }

    public List<AbstractTeller> getTellers(){
        return tellers;
    }

    public List<BankAdmin> getAdmins(){
        return admins;
    }


    
}