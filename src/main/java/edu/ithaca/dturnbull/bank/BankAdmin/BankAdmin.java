package edu.ithaca.dturnbull.bank.BankAdmin;

import java.util.List;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;

public class BankAdmin {

    private int adminId;
    private String password;

    public BankAdmin(int adminId, String password){
        this.adminId = adminId;
        this.password = password;
    }

    /**
     * Gets the total money of all the accounts in the bank
     * @return the total money in the bank
     */
    public double sumAllAccounts(List<AbstractAccount> accounts){
        double total = 0.0;
        for (int i = 0; i < accounts.size(); i++){
            total = total + accounts.get(i).getBalance(); //get all accounts from list
        }
        return total;
    }

    /**
     * Get the id of the admin
     * @return id of admin
     */
    public int getId(){
        return adminId;
    }

    /**
     * get password of admin
     * @return password of admin
     */
    public String getPassword(){
        return password;
    }
}
