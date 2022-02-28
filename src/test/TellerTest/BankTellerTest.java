package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Teller.BankTeller;

public class BankTellerTest {

    @Test
    void loginTest(){
        BankTeller bankTeller = new BankTeller();
        bankTeller.login("MWaowski123", "Gatorade749!");
        assertFalse(bankTeller.login("MikeW", "Powerade947!"));
        bankTeller.createAccount(); 
    }

    
    @Test
    void createAccountTest(){
        BankTeller bankTeller = new BankTeller();
        bankTeller.createAccount()
        
        
        
    }
    

    @Test
    void withdrawTest() throws InsufficientFundsException {
        BankTeller bankAccount = new BankAccount("a@b.com", 200);
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
        BankTeller bankAccount = new BankAccount("a@b.com", 200);
        BankTeller newAccount = new BankAccount("new@mail.com", 0);

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
        BankTeller bankAccount = new BankAccount("a@b.com", 0.00);
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
    void getBalanceTest() throws InsufficientFundsException {
        BankTeller bankAccount = new BankAccount("a@b.com", 200);
        assertEquals(200, bankAccount.getBalance(), 0.001);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance(), 0.001);
    }
    
}
