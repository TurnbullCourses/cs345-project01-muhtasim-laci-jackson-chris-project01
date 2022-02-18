package edu.ithaca.dturnbull.bank.BankAdmin;

import java.util.List;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Bank.Bank;

public class BankAdmin {

    private Bank bank;

    public BankAdmin(){
        bank = new Bank();
    }
    
    /**
     * Gets an array of all the accounts in the Bank
     * @return an array of all the accoutns in the bank
     */
    private List<AbstractAccount> getAllAccounts(){
        return bank.getAccounts(); //need to make Bank class
    }

    /**
     * Gets the total money of all the accounts in the bank
     * @return the total money in the bank
     */
    public double sumAllAccounts(){
        double total = 0.0;
        List<AbstractAccount> accounts = this.getAllAccounts();
        for (int i = 0; i < accounts.size(); i++){
            total = total + accounts.get(i).getBalance();
        }
        return total;
    }
}
