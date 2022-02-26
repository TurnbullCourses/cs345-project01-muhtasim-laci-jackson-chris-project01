package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

import edu.ithaca.dturnbull.bank.Bank.Bank;
import edu.ithaca.dturnbull.bank.BankAdmin.BankAdmin;
import edu.ithaca.dturnbull.bank.Customer.Customer;
import edu.ithaca.dturnbull.bank.Teller.AbstractTeller;
import edu.ithaca.dturnbull.bank.Teller.BankTeller;

public class UserInterface {

    //initial objects needed
    private static Scanner in = new Scanner(System.in);
    private static Bank bank = new Bank();
    private static int nextId = 0; //for customer Id's

    private static void loginState(){
        boolean login = false;
        while (!login){
            System.out.println("Are you a customer, teller, or admin (0, 1, 2)?");
            try{
                int response = in.nextInt();
                if (response > 2 || response < 0){
                    throw new Exception();
                }
                System.out.println("Please enter your userId:");
                try{
                    int id = in.nextInt();
                    System.out.println("Please enter your password:");
                    try{
                        String password = in.next();
                        if (response == 0){
                            try{
                                Customer customer = bank.customerLogIn(id, password);
                                if (customer == null){
                                    throw new Exception();
                                }
                                else{
                                    customerState(customer);
                                    login = true;
                                }
                            }
                            catch(Exception e){
                                System.out.println("I am sorry, that is not a valid login.");
                            }
                        }
                        else if (response == 1){
                            try{
                                BankTeller teller = bank.tellerLogIn(id, password);
                                if (teller == null){
                                    throw new Exception();
                                }
                                else{
                                    tellerState(teller);
                                    login = true;
                                }
                            }
                            catch(Exception e){
                                System.out.println("I am sorry, that is not a valid login.");
                            }
                        }
                        else{
                            try{
                                BankAdmin admin = bank.adminLogIn(id, password);
                                if (admin == null){
                                    throw new Exception();
                                }
                                else{
                                    adminState(admin);
                                    login = true;
                                }
                            }
                            catch(Exception e){
                                System.out.println("I am sorry, that is not a valid login.");
                            }
                        }
                    }
                    catch(Exception e){
                        System.out.println("That is not a valid password.");
                    }
                    
                }
                catch(Exception e){
                    System.out.println("That is not a valid id.");
                }
            }
            catch(Exception e){
                System.out.println("That is not a valid input.");
            }
        }
    }

    private static void customerState(Customer customer, int choice){
        boolean done = false;
        while(!done){
            if (choice == 0){
                System.out.println(customer.getBalance());
            }
            else if (choice == 1){
                System.out.println("Which account would you like to deposit into? (0 for savings, 1 for checkings)");
                try{
                    int account = in.nextInt();
                    System.out.println("How much would you like to deposit?");
                    try{
                        double amount = in.nextDouble();
                        customer.deposit(amount, account);
                    }
                    catch(Exception e){
                        System.out.println("Invalid Amount");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid account");
                }
            }
            else if (choice == 2){
                System.out.println("Which account would you like to withdraw from? (0 for savings, 1 for checkings)");
                try{
                    int account = in.nextInt();
                    System.out.println("How much would you like to withdraw?");
                    try{
                        double amount = in.nextDouble();
                        customer.withdraw(amount, account);
                    }
                    catch(Exception e){
                        System.out.println("Invalid Amount");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid account");
                }
            }
            else if (choice == 3){
                System.out.println("Which account would you like to transfer from? (0 for savings, 1 for checkings)");
                try{
                    int account = in.nextInt();
                    System.out.println("How much would you like to trasfer?");
                    try{
                        double amount = in.nextDouble();
                        System.out.println("Enter the id of the customer you wish to transfer the money to");
                        try{
                            int transferId = in.nextInt();
                            customer.transfer(amount, account, transferId);
                        }
                        catch(Exception e){
                                System.out.println("Invalid id or invalid ammount");
                        }
                    }
                    catch(Exception e){
                        System.out.println("Invalid amount");
                    }
                }
                catch(Exception e){
                    System.out.println("Invalid account");
                }
            }
            else{
                done = true;
            }
        }
    }

    private static void customerState(Customer customer){
        boolean done = false;
        while(!done){
            System.out.println("Options:\n0\tCheck Balance\n1\tDeposit\n2\tWithdraw\n3\tTransfer\n4\tExit");
            try{
                int choice = in.nextInt();
                if(choice > 4 || choice < 0){
                    throw new Exception();
                }
                customerState(customer, choice);
                done = true;
            }
            catch(Exception e){
                System.out.println("That is not a valid input");
            }
        }        
    }

    private static void createAccountState(BankTeller teller){
        
    }

    private static void tellerState(BankTeller teller){
        boolean done = false;
        while(!done){
            System.out.println("Options:\n0\tCheck Balance\n1\tDeposit\n2\tWithdraw\n3\tTransfer\n4\tCreate Account\n5\tExit");
            try{
                int choice = in.nextInt();
                if(choice > 5 || choice < 0){
                    throw new Exception();
                }
                if (choice < 4){
                    System.out.println("Enter customer's id");
                    try{
                        int customerId = in.nextInt();
                        Customer customer = bank.getCustomers().get(customerId);
                        customerState(customer, choice);
                    }
                    catch(Exception e){
                        System.out.println("Invalid ID");
                    }
                }
                else if (choice == 4){
                    createAccountState(teller);
                }
                else{
                    done = true;
                }
            }
            catch(Exception e){
                System.out.println("That is not a valid input");
            }
        }
    }

    private static void adminState(BankAdmin admin){
        boolean done = false;
        while(!done){
            System.out.println("Options:\n0\tGet Total Balance\n1\tExit");
            try{
                int choice = in.nextInt();
                if (choice < 0 || choice > 1){
                    throw new Exception();
                }
                if (choice == 0){
                    System.out.println(admin.sumAllAccounts(bank.getAccounts()));
                }
                else{
                    done = true;
                }
            }
            catch(Exception e){
                System.out.println("That is not a valid input");
            }
        }
    }

    public static void main(String[] args) {        

        //initialize with one teller, one admin, and one customer - can make more customers if needed if making accounts
        BankAdmin intialAdmin = new BankAdmin(0, "password");
        bank.addAdmin(intialAdmin);
        BankTeller intialTeller = new BankTeller(0, "password");
        bank.addTeller(intialTeller);
        Customer intialCustomer = new Customer(nextId, "password");
        nextId++;
        bank.addCustomer(intialCustomer);

        //go to state to login
        loginState();

        //close scanner
        in.close();
    }
}
