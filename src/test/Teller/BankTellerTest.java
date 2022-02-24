package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class BankTellerTest {

    @Test
    void loginTest(){
        BankTeller bankTeller = new BankTeller();
        bankTeller.login("MWaowski123", "Gatorade749!");
        assertFalse(bankTeller.login("MikeW", "Powerade947!"));
        bankTeller.createAccount(); 
    }

    
    
    void createAccountTest(){
        
        
        
        
    }
    
    

    
    
}
