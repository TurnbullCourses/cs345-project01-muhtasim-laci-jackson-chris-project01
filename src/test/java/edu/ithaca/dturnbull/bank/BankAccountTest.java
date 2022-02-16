package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        assertEquals(200, bankAccount.getBalance(), 0.001);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
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
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        BankAccount newAccount = new BankAccount("new@mail.com", 0);

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
        BankAccount bankAccount = new BankAccount("a@b.com", 0.00);
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
        assertTrue(BankAccount.isEmailValid("a@b.com")); // Valid Email Address
        assertFalse(BankAccount.isEmailValid("")); // Empty String

        // @ symbol
        assertFalse(BankAccount.isEmailValid("ab@c@mail.com"));
        assertFalse(BankAccount.isEmailValid("abcmail.com"));
        assertFalse(BankAccount.isEmailValid("abc@"));
        assertFalse(BankAccount.isEmailValid("@mail.com"));

        // Special Characters
        assertFalse(BankAccount.isEmailValid("abc-@mail.com")); // No special characters are permitted just before the @
                                                                // symbol
        assertFalse(BankAccount.isEmailValid("abc#def@mail.com")); // The character # is not permitted in a valid email
                                                                   // address before the @
        assertFalse(BankAccount.isEmailValid("abc.def@mail'archive.com")); // The character ' is not permitted in a
                                                                           // valid email address after the @

        // Domain Suffix
        assertFalse(BankAccount.isEmailValid("abcd@mail.c")); // There must be two characters in the suffix of the
                                                              // domain
        assertTrue(BankAccount.isEmailValid("abcd@mail.cc")); // Valid Email Address

        assertTrue(BankAccount.isEmailValid("abc_def@mail.com")); // Valid Email Address
        assertFalse(BankAccount.isEmailValid(".abcd@mail.com")); // Cannot start with a special character

    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);

        // check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("a@b.com", 100.001));
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("a@b.com", 100.999));
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("a@b.com", -100.00));

        // Hanging zeros are not acounted for
        BankAccount testAccoount1 = new BankAccount("a@b.com", 200.010);
        assertEquals("a@b.com", testAccoount1.getEmail());
        assertEquals(200.01, testAccoount1.getBalance(), 0.001);

        BankAccount testAccoount2 = new BankAccount("a@b.com", 200.990);
        assertEquals("a@b.com", testAccoount2.getEmail());
        assertEquals(200.99, testAccoount2.getBalance(), 0.001);
    }

    @Test
    void isNumberValidTest() {
        // checks to see if a double has two decimals or less
        assertTrue(BankAccount.isNumberValid(100));
        assertTrue(BankAccount.isNumberValid(100.1));
        assertTrue(BankAccount.isNumberValid(100.11));
        assertFalse(BankAccount.isNumberValid(100.111));

        // amount is a positive number
        assertTrue(BankAccount.isNumberValid(10));
        assertFalse(BankAccount.isNumberValid(-10));
        assertFalse(BankAccount.isNumberValid(-100));
    }

    @Test
    void freezeAndUnfreezeTest() {

    }

    @Test
    void addTest(){
        assertEquals(55, BankAccount.addNums(25, 30));
        assertEquals(75, BankAccount.addNums(55, 20));
        assertEquals(100.10, BankAccount.addNums(100.00, 0.10));
        assertEquals(12.5, BankAccount.addNums(6.25,6.25));
        assertEquals(0, BankAccount.addNums(0, 0));
    }

}