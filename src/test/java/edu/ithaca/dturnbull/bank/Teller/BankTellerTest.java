package edu.ithaca.dturnbull.bank.Teller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
//import edu.ithaca.dturnbull.bank.Teller.BankTeller;
import edu.ithaca.dturnbull.bank.Customer.Customer;



public class BankTellerTest {

    
    @Test
    void createAccountTest(){
        AbstractTeller bankTeller = new BankTeller(1454,"snowday303");
        Customer newCustomer = new Customer(4004, "poodles");

        AbstractAccount account = bankTeller.createAccount(newCustomer, 0, 500, 5, 0);

        assertEquals(0, account.getBalance());

        
    }
    

    @Test
    void withdrawAndGetBalanceTest() throws InsufficientFundsException {
        AbstractTeller teller = new BankTeller(1454,"snowday303");
        AbstractAccount bankAccount = new CheckingAccount(200.0);
            
        teller.withdraw(100.0, bankAccount);
        assertEquals(100, teller.getBalance(bankAccount), 0.001);

        // Overdrawn
        assertThrows(InsufficientFundsException.class, () -> teller.withdraw(300,bankAccount));

        // Negative number withdrawn
        assertThrows(IllegalArgumentException.class, () -> teller.withdraw(-100,bankAccount));

        // Too many decimal places
        assertThrows(IllegalArgumentException.class, () -> teller.withdraw(100.999,bankAccount));
        assertThrows(IllegalArgumentException.class, () -> teller.withdraw(100.001,bankAccount));

        // Balance does not change when an excepetion is thrown
        assertEquals(100, teller.getBalance(bankAccount));

        // Hanging zeros are not accounted for
        teller.withdraw(100.000,bankAccount);
        assertEquals(0, teller.getBalance(bankAccount));
    }
  
    @Test
    void transferTest() throws InsufficientFundsException {
        AbstractAccount bankAccount = new CheckingAccount(200);
        AbstractAccount newAccount = new CheckingAccount(0);
        AbstractTeller teller = new BankTeller(1454,"snowday303");

        teller.transfer(bankAccount,100, newAccount);

        assertEquals(100, newAccount.getBalance()); // valid transfer - assures initial account had money withdrawn
                                                    // correctly
        assertEquals(100, bankAccount.getBalance()); // valid transfer - assures transfer account had money added
                                                     // correctly

        assertThrows(InsufficientFundsException.class, () -> teller.transfer(bankAccount,500, newAccount)); // transfer amount
                                                                                                     // is greater than
                                                                                                     // balance - border
                                                                                                     // case <0

        assertThrows(IllegalArgumentException.class, () -> teller.transfer(bankAccount,5.87654, newAccount)); // transfer
                                                                                                       // amount has
                                                                                                  // more than 2
                                                                                                       // decimals
    }

    @Test
    void depositTest()throws InsufficientFundsException {

        AbstractTeller teller = new BankTeller(1454,"snowday303");
        AbstractAccount bankAccount = new CheckingAccount(0);

        teller.deposit(100.00,bankAccount);
        assertEquals(100, teller.getBalance(bankAccount));
    
        // Too many decimal places
        assertThrows(IllegalArgumentException.class, () -> teller.deposit(100.999,bankAccount));
        assertThrows(IllegalArgumentException.class, () -> teller.deposit(100.001,bankAccount));
    
        // Negative values
        assertThrows(IllegalArgumentException.class, () -> teller.deposit(-100,bankAccount));
        assertThrows(IllegalArgumentException.class, () -> teller.deposit(-10,bankAccount));
    
        // Balance does not change when errors are thrown
        assertEquals(100, teller.getBalance(bankAccount));
    
        // Hanging zeros are not accounted for
        teller.deposit(100.000,bankAccount);
        assertEquals(200, teller.getBalance(bankAccount));
    }

    @Test
    void isNumberValidTest() {
        // checks to see if a double has two decimals or less
        assertTrue(CheckingAccount.isNumberValid(100));
        assertTrue(CheckingAccount.isNumberValid(100.1));
        assertTrue(CheckingAccount.isNumberValid(100.11));
        assertFalse(CheckingAccount.isNumberValid(100.111));

        // amount is a positive number
        assertTrue(CheckingAccount.isNumberValid(10));
        assertFalse(CheckingAccount.isNumberValid(-10));
        assertFalse(CheckingAccount.isNumberValid(-100));
    }

    @Test
    void constructorTest() {
        AbstractTeller teller = new BankTeller(4004,"HeyHiHello10");

        assertEquals(4004, teller.getId(), 0.001);

        assertEquals("HeyHiHello10", teller.getPassword());

        assertNotEquals("NotPassword", teller.getPassword());

        assertNotEquals(0000, teller.getId());


        // check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount(100.001));
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount( 100.999));
        assertThrows(IllegalArgumentException.class, () -> new CheckingAccount( -100.00));

        // Hanging zeros are not acounted for
        CheckingAccount testAccoount1 = new CheckingAccount( 200.010);
    
        assertEquals(200.01, testAccoount1.getBalance(), 0.001);

        CheckingAccount testAccoount2 = new CheckingAccount( 200.990);
        
        assertEquals(200.99, testAccoount2.getBalance(), 0.001);
    }
}
