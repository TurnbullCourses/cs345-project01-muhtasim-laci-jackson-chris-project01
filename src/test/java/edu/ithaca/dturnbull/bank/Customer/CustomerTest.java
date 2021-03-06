package edu.ithaca.dturnbull.bank.Customer;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;
import edu.ithaca.dturnbull.bank.Bank.Bank;

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
    
    @Test
    void customerTransferTest() throws InsufficientFundsException{
        Bank bank = new Bank();
        CheckingAccount account1 = new CheckingAccount(100);
        CheckingAccount account2 = new CheckingAccount(100);
        SavingsAccount account3 = new SavingsAccount(100,100,10);
        SavingsAccount account4 = new SavingsAccount(100,100,10);
        Customer customer1 = new Customer(0, "password");
        Customer customer2 = new Customer(1, "word");
        customer1.setCheckingAccount(account1);
        customer2.setCheckingAccount(account2);
        customer1.setSavingsAccount(account3);
        customer2.setSavingsAccount(account4);
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);
        customer1.transferCheckingAccount(100, customer2);
        assertEquals(0, customer1.getCheckingBalance());
        assertEquals(200, customer2.getCheckingBalance());
        customer1.transferSavingsAccount(100, customer2);
        assertEquals(0, customer1.getSavingsBalance());
        assertEquals(200, customer2.getSavingsBalance());
    }
}
