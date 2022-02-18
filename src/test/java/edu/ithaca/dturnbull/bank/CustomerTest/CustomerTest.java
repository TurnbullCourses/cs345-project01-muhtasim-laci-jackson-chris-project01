package edu.ithaca.dturnbull.bank.CustomerTest;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Customer.Customer;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void loginTest(){
        Customer customer = new Customer("USERName1", "PASSwORD!!!!!");
        assertFalse(customer.login("USERName1", "password!!!!!"));
        assertFalse(customer.login("USeRName1", "PASSwORD!!!!!"));
        assertTrue(customer.login("USERName1", "PASSwORD!!!!!"));
    }
    
}
