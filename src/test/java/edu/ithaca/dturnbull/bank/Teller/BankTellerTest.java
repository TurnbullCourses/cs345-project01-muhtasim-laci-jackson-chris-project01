package edu.ithaca.dturnbull.bank.Teller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
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
        //Bank teller creates customers account
        
        
        
    }
    

    @Test
    void withdrawTest() throws InsufficientFundsException {
        BankTeller bankAccount = new BankTeller("a@b.com", 200);
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

}
