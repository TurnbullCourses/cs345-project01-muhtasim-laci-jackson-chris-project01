package edu.ithaca.dturnbull.bank.Teller;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
//import edu.ithaca.dturnbull.bank.Teller.BankTeller;



public class BankTellerTest {

    
    @Test
    void createAccountTest(){
        //Bank teller creates customers account
        
        
        
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
}
