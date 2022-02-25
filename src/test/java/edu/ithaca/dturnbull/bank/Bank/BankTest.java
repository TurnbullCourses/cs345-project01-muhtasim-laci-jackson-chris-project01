package edu.ithaca.dturnbull.bank.Bank;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.BankAdmin.BankAdmin;
import edu.ithaca.dturnbull.bank.Customer.Customer;
import edu.ithaca.dturnbull.bank.Teller.AbstractTeller;
import edu.ithaca.dturnbull.bank.Teller.BankTeller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    void loginTest(){
        Bank bank = new Bank();

        Customer customer = new Customer(0, "password");
        bank.addCustomer(customer);
        Customer customerTest = bank.customerLogIn(0, "password");
        assertEquals(customer, customerTest);

        AbstractTeller teller = new BankTeller(0, "password");
        bank.addTeller(teller);
        AbstractTeller tellerTest = bank.tellerLogIn(0, "password");
        assertEquals(teller, tellerTest);

        BankAdmin admin = new BankAdmin(0, "password");
        bank.addAdmin(admin);
        BankAdmin adminTest = bank.adminLogIn(0, "password");
        assertEquals(admin, adminTest);

    }
    
}
