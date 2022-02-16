package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class Account {
    public static void main(){
        Account obj1 = new Account();
        obj1.accountNumber();
    }

    public int accountNumber(){
        System.out.println("Create 6 digit Account Number");
        Scanner input1 = new Scanner(System.in);
        int accountNum = input1.nextInt();
        input1.close();

        return accountNum;
    }

    public int accountPint(){
        System.out.println("Create 4 digit pin");
        Scanner input2 = new Scanner(System.in);
        int pin = input2.nextInt();
        input2.close();
        return pin;
    }




    
}
