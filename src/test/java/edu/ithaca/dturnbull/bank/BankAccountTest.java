package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
    }

    @Test 
    void transferTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        BankAccount newAccount = new BankAccount("new@mail.com", 0);

        bankAccount.transfer(100, newAccount); 

        assertEquals(100, newAccount.getBalance()); //valid transfer - assures initial account had money withdrawn correctly
        assertEquals(100, bankAccount.getBalance()); //valid transfer - assures transfer account had money added correctly

        assertThrows(InsufficientFundsException.class, ()-> bankAccount.transfer(500, newAccount)); // transfer amount is greater than balance - border case <0

        assertThrows(IllegalArgumentException.class, ()-> bankAccount.transfer(5.87654, newAccount)); // transfer amount has more than 2 decimals
    }



    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));   // valid email address
        assertFalse( BankAccount.isEmailValid(""));         // empty string

        
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

    @Test 
    void freezeAndUnfreezeTest() {


        
    }


}