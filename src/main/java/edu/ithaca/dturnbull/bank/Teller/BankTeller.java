package edu.ithaca.dturnbull.bank.Teller;


public class BankTeller extends AbstractTeller {

    
    public BankTeller(){

    }

    @Override
    public boolean login(String username, String password){
        if (this.username.equals(username)){
            if (this.password.equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public void createAccount(){
        
    }
    
}
