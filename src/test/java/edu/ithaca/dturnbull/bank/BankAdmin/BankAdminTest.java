package edu.ithaca.dturnbull.bank.BankAdmin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Bank.Bank;
import edu.ithaca.dturnbull.bank.Teller.BankTeller;

public class BankAdminTest {

    @Test
    void sumALlAccountsTest(){
        Bank bank = new Bank();
        
        BankAdmin admin = new BankAdmin(0, "password");
        bank.addAdmin(admin);
        BankTeller teller = new BankTeller(0, "password");
        bank.addTeller(teller);

        assertEquals(0, admin.sumAllAccounts(bank.getAccounts())); //make sure no money
        bank.createNewAccount(teller, 0, "password", 0, 0, 0, 500);
        bank.createNewAccount(teller, bank.getCustomers().get(0), 1, 1000, 1, 200);
        assertEquals(700, admin.sumAllAccounts(bank.getAccounts())); //all money in one customer
        bank.createNewAccount(teller, 1, "password", 0, 0, 0, 1000);
        bank.createNewAccount(teller, 2, "password", 0, 0, 0, 1);
        assertEquals(1701, admin.sumAllAccounts(bank.getAccounts())); //all money in multiple customers
    }
    
}
