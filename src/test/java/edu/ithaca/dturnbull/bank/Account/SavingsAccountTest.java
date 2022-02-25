package edu.ithaca.dturnbull.bank.Account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void getBalanceTest() throws InsufficientFundsException {
        SavingsAccount bankAccount = new SavingsAccount("a@b.com", 200, 200, 10.0);
        assertEquals(200, bankAccount.getBalance(), 0.001);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException {
        SavingsAccount bankAccount = new SavingsAccount("a@b.com", 200, 300, 10.0);
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
    void withdrawLimitTest() throws InsufficientFundsException {
        SavingsAccount bankAccount = new SavingsAccount("a@b.com", 500, 300, 10.0);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance(), 0.001);

        // Overdrawn
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));

        // Negative number withdrawn
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-100));

        // Too many decimal places
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(100.999));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(100.001));

        // Balance does not change when an excepetion is thrown
        assertEquals(200, bankAccount.getBalance());

        // Hanging zeros are not accounted for
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200));
    }

    @Test
    void transferTest() throws InsufficientFundsException {
        SavingsAccount bankAccount = new SavingsAccount("a@b.com", 200, 500, 10.0);
        SavingsAccount newAccount = new SavingsAccount("new@mail.com", 0, 200, 10.0);

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
        SavingsAccount bankAccount = new SavingsAccount("a@b.com", 0.00, 100, 0.5);
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
    void isEmailValidTest() {
        assertTrue(SavingsAccount.isEmailValid("a@b.com")); // Valid Email Address
        assertFalse(SavingsAccount.isEmailValid("")); // Empty String

        // @ symbol
        assertFalse(SavingsAccount.isEmailValid("ab@c@mail.com"));
        assertFalse(SavingsAccount.isEmailValid("abcmail.com"));
        assertFalse(SavingsAccount.isEmailValid("abc@"));
        assertFalse(SavingsAccount.isEmailValid("@mail.com"));

        // Special Characters
        assertFalse(SavingsAccount.isEmailValid("abc-@mail.com")); // No special characters are permitted just before the @
                                                                // symbol
        assertFalse(SavingsAccount.isEmailValid("abc#def@mail.com")); // The character # is not permitted in a valid email
                                                                   // address before the @
        assertFalse(SavingsAccount.isEmailValid("abc.def@mail'archive.com")); // The character ' is not permitted in a
                                                                           // valid email address after the @

        // Domain Suffix
        assertFalse(SavingsAccount.isEmailValid("abcd@mail.c")); // There must be two characters in the suffix of the
                                                                 // domain
        assertTrue(SavingsAccount.isEmailValid("abcd@mail.cc")); // Valid Email Address

        assertTrue(SavingsAccount.isEmailValid("abc_def@mail.com")); // Valid Email Address
        assertFalse(SavingsAccount.isEmailValid(".abcd@mail.com")); // Cannot start with a special character

    }

    @Test
    void constructorTest() {
        SavingsAccount bankAccount = new SavingsAccount("a@b.com", 200,200,10);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);

        // check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("", 100,200,10));
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("a@b.com", 100.001,200,10));
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("a@b.com", 100.999,200,10));
        assertThrows(IllegalArgumentException.class, () -> new SavingsAccount("a@b.com", -100.00,200,10));

        // Hanging zeros are not acounted for
        SavingsAccount testAccoount1 = new SavingsAccount("a@b.com", 200.010,200,10);
        assertEquals("a@b.com", testAccoount1.getEmail());
        assertEquals(200.01, testAccoount1.getBalance(), 0.001);

        SavingsAccount testAccoount2 = new SavingsAccount("a@b.com", 200.990,200,10);
        assertEquals("a@b.com", testAccoount2.getEmail());
        assertEquals(200.99, testAccoount2.getBalance(), 0.001);
    }

    @Test
    void isNumberValidTest() {
        // checks to see if a double has two decimals or less
        assertTrue(SavingsAccount.isNumberValid(100));
        assertTrue(SavingsAccount.isNumberValid(100.1));
        assertTrue(SavingsAccount.isNumberValid(100.11));
        assertFalse(SavingsAccount.isNumberValid(100.111));

        // amount is a positive number
        assertTrue(SavingsAccount.isNumberValid(10));
        assertFalse(SavingsAccount.isNumberValid(-10));
        assertFalse(SavingsAccount.isNumberValid(-100));
    }
}