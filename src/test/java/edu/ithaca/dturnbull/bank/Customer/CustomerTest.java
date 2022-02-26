package edu.ithaca.dturnbull.bank.Customer;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void constructorTest(){
        Customer customer1= new Customer(12345, "PASSwORD!!!");
        assertEquals(12345,customer1.getid());
        assertEquals("PASSwORD!!!", customer1.getPassword());
        Customer customer2 = new Customer(54321, "!!!DROwSSAP");
        assertEquals(54321,customer2.getid());
        assertEquals("!!!DROwSSAP", customer2.getPassword());
    }

    @Test
    void customerTest() throws InsufficientFundsException{
        Customer customer= new Customer(12345, "PASSwORD!!!");
        CheckingAccount checkingAccount= new CheckingAccount(150);
        SavingsAccount savingsAccount = new SavingsAccount(100, 100, 10);
        customer.setCheckingAccount(checkingAccount);
        customer.setSavingsAccount(savingsAccount);
        assertEquals(savingsAccount, customer.getSavingsAccount());
        assertEquals(checkingAccount, customer.getCheckingAccount());
        assertEquals(150.0, customer.getCheckingBalance());
        assertEquals(100.0, customer.getSavingsBalance());
        customer.depositCheckingAccount(50);
        customer.depositSavingsAccount(50);
        assertEquals(200.0, customer.getCheckingBalance());
        assertEquals(150.0, customer.getSavingsBalance());
        customer.withdrawCheckingAccount(50);
        customer.withdrawSavingsAccount(50);
        assertEquals(150.0, customer.getCheckingBalance());
        assertEquals(100.0, customer.getSavingsBalance());
    }
}
