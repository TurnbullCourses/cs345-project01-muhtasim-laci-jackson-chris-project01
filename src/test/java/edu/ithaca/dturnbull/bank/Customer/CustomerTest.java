package edu.ithaca.dturnbull.bank.Customer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void constructorTest(){
        Customer customer1= new Customer(12345, "PASSwORD!!!");
        assertEquals(12345,customer1.getid());
        assertEquals("PASSWORD!!!", custumer.getpassword());
        Customer customer2 = new Customer(54321, "!!!DROwSSAP");
        assertEquals(54321,customer2.getid());
        assertEquals("!!!DROwSSAP", customer2.getpassword());
    }
}
