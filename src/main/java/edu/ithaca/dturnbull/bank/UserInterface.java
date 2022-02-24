package edu.ithaca.dturnbull.bank;

import java.util.Scanner;


public class UserInterface {

    public static void main(String[] args) {
        //in the future teller will create the accout for the customer instead of just having accounts built in
        Customer customer1 = new Customer("name1", "password1" );
        boolean exit = false;
        Scanner reader = new Scanner(System.in);
        int in = -1;
        System.out.println("Welcome to the Bank! Please login");
        boolean login = false;
        while(!login){
            System.out.println("Username: ");
            String name = reader.nextLine();
            System.out.println("Password: ");
            String pswd = reader.nextLine();
            if (customer1.login(name, pswd)){
                login = true;
                System.out.println("Welcome!");
            }
            else{
                System.out.println("I am sorry the credentials are wrong");
            }
        }
        while (!exit) {
            boolean enter = false;
            boolean valid = false;
            while (!enter) {
                try {
                    System.out.println("Enter 1 for deposit, 2 for withdraw, and 3 for transfer, 4 for exit");
                    in = reader.nextInt();
                    if (in >= 1 && in <= 4) {
                        enter = true;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("That is not a valid input");
                }
            }
            if (in == 1) {
                while (!valid){
                    System.out.println("Enter amount to deposit: ");
                    double amount = reader.nextDouble();
                    BankAccount bankAccount = new BankAccount("a@b.com", 0.0);
                    try{
                        bankAccount.deposit(amount);
                        valid = true;
                        System.out.println("Transaction Completed");
                    }
                    catch(Exception e){
                        System.out.println("That is not a valid amount");
                    }
                }

            } else if (in == 2) {
                while (!valid){
                    System.out.println("Enter amount to withdraw: ");
                    double amount = reader.nextDouble();
                    BankAccount bankAccount = new BankAccount("a@b.com", 99999);
                    try{
                        bankAccount.withdraw(amount);
                        valid = true;
                        System.out.println("Transaction Completed");
                    }
                    catch(Exception e){
                        System.out.println("That is not a valid amount");
                    }
                }

            } else if (in == 3) {
                while (!valid){
                    System.out.println("Enter amount to transfer (Normally would also specify account to transfer to): ");
                    double amount = reader.nextDouble();
                    BankAccount bankAccount = new BankAccount("a@b.com", 99999);
                    BankAccount bankAccountTo = new BankAccount("c@d.com", 0.0);
                    try{
                        bankAccount.transfer(amount, bankAccountTo);
                        valid = true;
                        System.out.println("Transaction Completed");
                    }
                    catch(Exception e){
                        System.out.println("That is not a valid amount  or other account is invalid");
                    }
                }

            } else {
                reader.close();
                exit = true;
            }

        }
    }

}
