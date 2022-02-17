package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
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
