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
    
}
