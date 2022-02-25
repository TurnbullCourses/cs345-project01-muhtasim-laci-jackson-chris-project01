package edu.ithaca.dturnbull.bank.BankAdmin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.Bank.Bank;
import edu.ithaca.dturnbull.bank.Teller.BankTeller;

public class BankAdminTest {

    @Test
    void sumAllAccountsTest(){ //cannot test yet since other required classes do not exist
        Bank bank = new Bank();
        BankAdmin admin = new BankAdmin(0);
        BankTeller teller = new BankTeller();
        teller.createAccount();
        assertEquals(0.0, admin.sumAllAccounts()); //equivalence case - make sure amount is zero
        //deposit money
        
        //make sure correct amount
        //make another accoutn and deposit money
        //make sure correct amount in bank
        
        
        
    }
    
}
