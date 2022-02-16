package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class Account {
    public static void main(){
        Account obj1 = new Account();
        obj1.accountNumber();
    }

    public void accountNumber(){
        System.out.println("Create Account pin");
        Scanner input1 = new Scanner(System.in);
        int accountNum = input1.nextInt();
        input1.close();
        System.out.println("Create 4 digit pin");
        Scanner input2 = new Scanner(System.in);
        int pin = input2.nextInt();
        input1.close();
        input2.close();
    }


    
}
