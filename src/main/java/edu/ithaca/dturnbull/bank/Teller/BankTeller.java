package edu.ithaca.dturnbull.bank.Teller;

import java.util.List;

import edu.ithaca.dturnbull.bank.Account.AbstractAccount;
import edu.ithaca.dturnbull.bank.Account.CheckingAccount;
import edu.ithaca.dturnbull.bank.Account.InsufficientFundsException;
import edu.ithaca.dturnbull.bank.Account.SavingsAccount;
import edu.ithaca.dturnbull.bank.Customer.Customer;

public class BankTeller extends AbstractTeller {

    public BankTeller(int id, String password){
        this.id = id;
        this.password = password;

    }

    public AbstractAccount createAccount(Customer existCustomer, int accountType, double withdrawLimit, double percentInt, double startBal){
        if(accountType == 0){
            CheckingAccount account = new CheckingAccount(startBal);
            existCustomer.setCheckingAccount(account);
            return account;
        }
        else if(accountType == 1){
            SavingsAccount account = new SavingsAccount(startBal, withdrawLimit, percentInt);
            existCustomer.setSavingsAccount(account);
            return account;
        }
        else{
            existCustomer.setCheckingAccount(new CheckingAccount(startBal));
            existCustomer.setSavingsAccount(new SavingsAccount(startBal, withdrawLimit, percentInt));
            return null;
        }
    }

    public Customer createAccount(int customerId, String password, int accountType, double withdrawLimit, double percentInt, double startBal){
        Customer customer = new Customer(customerId, password);
        createAccount(customer, accountType, withdrawLimit, percentInt, startBal);
        return customer;
    }

    @Override
    public double getBalance(AbstractAccount account) {
        double balance = account.getBalance();
        return balance;
    }

    @Override
    public void withdraw(double amount, AbstractAccount account) throws InsufficientFundsException {
        account.withdraw(amount);
    }

    @Override
    public void deposit(double amount, AbstractAccount account) throws InsufficientFundsException {
        account.deposit(amount);
    }

    @Override
    public void transfer(AbstractAccount account, double amount, AbstractAccount transferee) throws InsufficientFundsException {  
        if (isNumberValid(amount) == true){
            if (amount <= account.getBalance()){
                account.transfer(amount, transferee);
            }
            else {
                throw new InsufficientFundsException("Not enough money in the account.");
            }
        }
        else {
            throw new IllegalArgumentException("Amount to withdraw is invalid.");
        }
    }



}
