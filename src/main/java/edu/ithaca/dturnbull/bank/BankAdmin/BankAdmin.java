package edu.ithaca.dturnbull.bank.BankAdmin;

import java.util.List;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Bank.Bank;

public class BankAdmin {

    private int adminId;

    public BankAdmin(int adminId){
        this.adminId = adminId;
    }

    /**
     * Gets the total money of all the accounts in the bank
     * @return the total money in the bank
     */
    public double sumAllAccounts(List<AbstractAccount> accounts){
        double total = 0.0;
        for (int i = 0; i < accounts.size(); i++){
            total = total + accounts.get(i).getBalance();
        }
        return total;
    }
}
