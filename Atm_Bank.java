package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Bank_system {
    void checkBalance();
    void withdrawAmount(double withdrawBalance);
    void depositAmount(double depositBalance);
    void miniStatement();
    void moneyTransfer();
}

class Atm implements Bank_system {

    HashMap<Double, String> mini = new HashMap<>();
    Scanner s1 = new Scanner(System.in);
            double Balance = 20000;
   public void checkBalance() {

       System.out.println("Availeble balance is : "+ Balance);
   }
   public void withdrawAmount(double withdrawBalance) {

       double Atm_charge = 3.50;
       if(Balance > withdrawBalance) {
           if(withdrawBalance % 500 == 0) {
               mini.put(withdrawBalance, "withdraw");
               System.out.println("Collect Your Case : "+withdrawBalance);
               Balance = Balance - withdrawBalance - Atm_charge;
               System.out.println("Atm_Charge Is : "+Atm_charge);
               System.out.println("Available Balance is : "+Balance);
           }

           else {    // Do work is here

               System.out.println("Enter Multiple Of 500 Only : ");
               double withdraw = s1.nextDouble();
               withdrawAmount(withdraw);
               //System.exit(0);
           }
       }
       else {
           System.out.println("Your Balance is insufficient : ");
           System.exit(0);
       }

   }
   public void depositAmount(double depositBalance) {

       if(depositBalance % 100 == 0) {
           mini.put(depositBalance, "deposited");
           System.out.println("Deposited SuccessFully : "+depositBalance);
           Balance =  Balance + depositBalance;
           System.out.println("Available Balance is : "+Balance);
       }
       else {
           System.out.println("You Can Only Deposited Multiple Of 100 Only : ");
           System.exit(0);
       }

   }
   public void miniStatement() {

       for(Map.Entry<Double, String> m : mini.entrySet()) {

           System.out.println(m.getValue()+" : "+m.getKey());
       }

   }
   public void moneyTransfer() {

   }

}

public class Atm_Bank {
    public static void main(String[] args) {

        Bank_system b = new Atm();  // Refrance Of Interface
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome To The BankOfIndia : ");
        int Atm_number = 5161;
        double AccountNumber = 576210110010593d;
        double AadharNumber = 123456789123d;

        System.out.println("Please Select Option : ");
        System.out.println("How To Want The Money : ");
        System.out.println("1.ATM\n2.Branch\n3.AadhaarNumber : ");
        int opt = s.nextInt();
        if(opt == 1) {

            System.out.println("Select Your Language : ");
            System.out.println("1.English\n2.Hindi");
            int num = s.nextInt();
            if(num == 1) {

                while(true) {
                    System.out.println("1.CheckBalance\n2.withdrawAmount\n3.depositAmount\n4.miniStatement\n");
                    int num4 = s.nextInt();
                    if(num4 == 1) {
                        System.out.println("Enter AtmNumber : ");
                        int atm_no = s.nextInt();

                        if(Atm_number == atm_no) {
                            b.checkBalance();
                        }
                        else {
                            System.out.println("You Entered wrong Atm_Number you Cannot Check Balance : ");
                            System.exit(0);
                        }
                    }
                    else if (num4 == 2) {

                        System.out.println("Enter AtmNumber : ");
                        int atm_no = s.nextInt();

                        if(Atm_number == atm_no) {
                            System.out.println("How Many Withdraw The Money : ");
                            double withdrawBalance = s.nextDouble();
                            b.withdrawAmount(withdrawBalance);
                        }
                        else {
                            System.out.println("You Entered wrong Atm_Number You Can Not Withdraw The Money  : ");
                            System.exit(0);
                        }

                    }

                    else if (num4 == 3) {
                        System.out.println("Enter AtmNumber : ");
                        int atm_no = s.nextInt();
                        if(atm_no ==  Atm_number) {

                            System.out.println("How Many Rupees deposited : ");
                            double deposit = s.nextDouble();
                            b.depositAmount(deposit);
                        }
                        else {
                            System.out.println("You Entered Wrong Atm_Number You Cannot deposited : ");
                            System.exit(0);
                        }


                    }
                    else if (num4 == 4) {

                        System.out.println("Enter AtmNumber : ");
                        int atm_no = s.nextInt();
                        if(atm_no ==  Atm_number) {
                            b.miniStatement();
                        }
                        else {
                            System.out.println("You Entered Wrong Atm_Number You Cannot Recive miniStatement");
                            System.exit(0);
                        }

                    }

                    else {
                        System.out.println("You Choose Wrong Option You can Nothing any Operation : ");
                    }
                }
            }
            else if(num == 2) {
                System.out.println("Recently Hindi does not support  : ");
            }

            else {
                System.out.println("You Invalid Language Choose : ");
            }

        }    // First If Only writing code in about Atm
        else if(opt == 2 ){


            System.out.println("For Branch : ");
        }

        else if (opt == 3) {

            System.out.println("For Aadhaar : ");
        }
        else {
            System.out.println("You Select Wrong Option : ");
            System.exit(0);
        }

    }
}
