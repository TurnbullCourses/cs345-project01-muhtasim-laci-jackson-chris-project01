package edu.ithaca.dturnbull.bank.Account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    @Test
    void getBalanceTest() throws InsufficientFundsException {
        CheckingAccount bankAccount = new CheckingAccount( 200);
        assertEquals(200, bankAccount.getBalance(), 0.001);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException {
        CheckingAccount bankAccount = new CheckingAccount(200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance(), 0.001);

        // Overdrawn
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));

        // Negative number withdrawn
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-100));

        // Too many decimal places
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(100.999));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(100.001));

        // Balance does not change when an excepetion is thrown
        assertEquals(100, bankAccount.getBalance());

        // Hanging zeros are not accounted for
        bankAccount.withdraw(100.000);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void transferTest() throws InsufficientFundsException {
        CheckingAccount bankAccount = new CheckingAccount( 200);
        CheckingAccount newAccount = new CheckingAccount(0);

        bankAccount.transfer(100, newAccount);

        assertEquals(100, newAccount.getBalance()); // valid transfer - assures initial account had money withdrawn
                                                    // correctly
        assertEquals(100, bankAccount.getBalance()); // valid transfer - assures transfer account had money added
                                                     // correctly

        assertThrows(InsufficientFundsException.class, () -> bankAccount.transfer(500, newAccount)); // transfer amount
                                                                                                     // is greater than
                                                                                                     // balance - border
                                                                                                     // case <0

        assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(5.87654, newAccount)); // transfer
                                                                                                       // amount has
                                                                                                       // more than 2
                                                                                                       // decimals
    }

    @Test
    void depositTest() {
        CheckingAccount bankAccount = new CheckingAccount( 0.00);
        bankAccount.deposit(100.00);
        assertEquals(100, bankAccount.getBalance());

        // Too many decimal places
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(100.999));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(100.001));

        // Negative values
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-100));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10));

        // Balance does not change when errors are thrown
        assertEquals(100, bankAccount.getBalance());

        // Hanging zeros are not accounted for
        bankAccount.deposit(100.000);
        assertEquals(200, bankAccount.getBalance());
    }

    

    @Test
    void constructorTest() {
        CheckingAccount bankAccount = new CheckingAccount( 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);

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
}