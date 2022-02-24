package edu.ithaca.dturnbull.bank.TellerTest;

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

    
    
    void createAccountTest(){
        //Bank teller creates customers account
        
        
        
    }
    
    

    
    
}
