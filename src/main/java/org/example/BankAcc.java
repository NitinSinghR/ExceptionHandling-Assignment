package org.example;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


class BankAcc {
    public static void main(String[] args) {
        int amount;
        String holderName = null;
        int accountNumber = 0;
        int balance = 0;

        Logger l = Logger.getLogger("com.api.jar");
        Scanner sc = new Scanner(System.in);

        try{
            l.info("Enter the Account Holders Name:");
            holderName = sc.next();
            l.info("Enter the Account Holders Number:");
            accountNumber = sc.nextInt();
            l.info("Enter the Balance:");
            balance = sc.nextInt();
        }catch(InputMismatchException e){
            l.log(Level.INFO,()->" "+e);
        }

        Bank b1 = new Bank(holderName, accountNumber, balance);

        while(true){
            l.info("choose a option");
            l.info("1.Deposit \n 2.Withdraw \n 3.Balance\n");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    l.info("Enter the Amount:\n");
                    amount = sc.nextInt();
                    b1.deposit(amount);
                    break;
                }
                case 2: {
                    l.info("Enter the Amount:\n");
                    amount = sc.nextInt();
                    b1.withdraw(amount);
                    break;
                }
                case 3: {
                    String e=String.valueOf(b1.getBalance());
                    l.info(e);
                    break;
                }
                default: {
                    sc.close();
                    throw new IllegalArgumentException("Enter correct option");
                }
            }
        }
    }
}
class Bank extends BankAcc {
    private String name;
    private int accNumber;
    private double balance;
    Logger l=Logger.getLogger("com.api.jar");

    public Bank(String userName, int accNumber, double balance) {
        this.name = userName;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
        String g="Hello  "+name+"\nYour current balance for account  "+accNumber+ "  is  "+balance;
        l.info(g);
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            l.info("Insufficient Balance for withdraw!!\n");
        }
        else {
            balance -= amount;
            String f="Hello  " + name + "\nYour current balance for account  " + accNumber + "  is  " + balance;
            l.info(f);
        }
    }


    public double getBalance() {

        return balance;
    }
}

