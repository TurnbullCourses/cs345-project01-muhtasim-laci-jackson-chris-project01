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
<<<<<<< HEAD
=======
    }

    @Test
    void fullAdminSystemTest(){
        //initital set up
        Bank bank = new Bank();
        BankAdmin initialAdmin = new BankAdmin(0, "password");
        bank.addAdmin(initialAdmin);
        BankTeller initialTeller = new BankTeller(0, "password");
        bank.addTeller(initialTeller);

        //teller must login
        BankTeller teller = bank.tellerLogIn(0, "password");
        assertEquals(initialTeller, teller);

        //use teller to create new accounts and new customers
        bank.createNewAccount(bank.getTellers().get(0), 0, "password", 0, 0, 0, 100);
        bank.createNewAccount(bank.getTellers().get(0), 1, "password", 1, 100, 1, 1000);
        bank.createNewAccount(bank.getTellers().get(0), bank.getCustomers().get(0), 1, 1000, 10, 500);

        //make sure money went in right spot
        assertEquals(100, bank.getCustomers().get(0).getCheckingBalance());
        assertEquals(500, bank.getCustomers().get(0).getSavingsBalance());
        assertEquals(1000, bank.getCustomers().get(1).getSavingsBalance());
        assertEquals(600, bank.getCustomers().get(0).getBalance());
        assertEquals(1000, bank.getCustomers().get(1).getBalance());

        //admin must login
        BankAdmin admin = bank.adminLogIn(0, "password");
        assertEquals(initialAdmin, admin);
        assertEquals(1600, admin.sumAllAccounts(bank.getAccounts()));

        //deposit some money
        bank.getCustomers().get(0).depositCheckingAccount(100);
        bank.getCustomers().get(1).depositSavingsAccount(50);

        //make sure money went in right spot
        assertEquals(200, bank.getCustomers().get(0).getCheckingBalance());
        assertEquals(1050, bank.getCustomers().get(1).getSavingsBalance());
        assertEquals(700, bank.getCustomers().get(0).getBalance());

        //make sure admin works
        assertEquals(1750, admin.sumAllAccounts(bank.getAccounts()));

>>>>>>> main
    }
    
}
