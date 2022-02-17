package edu.ithaca.dturnbull.bank;

public class BankAdmin {
    
    /**
     * Gets an array of all the accounts in the Bank
     * @return an array of all the accoutns in the bank
     */
    private Account[] getAllAccounts(){
        return Bank.getAllAccoutns(); //need to make Bank class
    }

    /**
     * Gets the total money of all the accounts in the bank
     * @return the total money in the bank
     */
    public double sumAllAccounts(){
        double total = 0.0;
        Account[] accounts = this.getAllAccounts();
        for (int i = 0; i < accounts.length; i++){
            total = total + accounts[i].getBalance();
        }
        return total;
    }
}
