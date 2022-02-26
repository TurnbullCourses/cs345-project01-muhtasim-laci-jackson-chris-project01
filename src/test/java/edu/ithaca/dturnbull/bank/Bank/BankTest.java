package edu.ithaca.dturnbull.bank.Bank;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.BankAdmin.BankAdmin;
import edu.ithaca.dturnbull.bank.Customer.Customer;
import edu.ithaca.dturnbull.bank.Teller.AbstractTeller;
import edu.ithaca.dturnbull.bank.Teller.BankTeller;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void loginTest(){
        Bank bank = new Bank();

        Customer customer = new Customer(0, "password");
        bank.addCustomer(customer);
        Customer customerTest = bank.customerLogIn(0, "password");
        assertEquals(customer, customerTest);
        assertEquals(null, bank.customerLogIn(2, "password"));
        assertEquals(null, bank.customerLogIn(0, "wrong"));

        AbstractTeller teller = new BankTeller(0, "password");
        bank.addTeller(teller);
        AbstractTeller tellerTest = bank.tellerLogIn(0, "password");
        assertEquals(teller, tellerTest);
        assertEquals(null, bank.tellerLogIn(2, "password"));
        assertEquals(null, bank.tellerLogIn(0, "wrong"));

        BankAdmin admin = new BankAdmin(0, "password");
        bank.addAdmin(admin);
        BankAdmin adminTest = bank.adminLogIn(0, "password");
        assertEquals(admin, adminTest);
        assertEquals(null, bank.adminLogIn(2, "password"));
        assertEquals(null, bank.adminLogIn(0, "wrong"));

    }

    @Test
    void createNewAccountTest(){ //this is more of an integration test than a unit test
        Bank bank = new Bank();

        Customer customer = new Customer(0, "password");
        bank.addCustomer(customer);

        BankTeller teller = new BankTeller(0, "password");
        bank.addTeller(teller);

        assertEquals(null, customer.getCheckingAccount()); //account should not exist
        bank.createNewAccount(teller, customer, 0, 0, 0, 500); //make checking account
        assertEquals(500, customer.getCheckingAccount().getBalance()); // should have 500 balance in new accounts
        assertEquals(500, customer.getBalance()); //should only have 500 accross all accounts as well

        assertEquals(null, customer.getSavingsAccount());
        bank.createNewAccount(teller, customer, 1, 1000, 5, 500);
        assertEquals(500, customer.getSavingsAccount().getBalance());
        assertEquals(1000, customer.getBalance());

        bank.createNewAccount(teller, 1, "password", 0, 0, 0, 200);
        Customer customer1 = bank.customerLogIn(1, "password");
        assertEquals(customer1.getCheckingAccount().getBalance(), 200); //make sure customer was created in right spot and has correct balance
        bank.createNewAccount(teller, 1, "password", 1, 500, 2, 200);
        assertEquals(customer1.getSavingsAccount().getBalance(), 200); //make sure that a new customer is not created and a new account is made
        assertEquals(customer1.getBalance(), 400);

    }
    
}
