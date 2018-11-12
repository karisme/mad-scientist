package model;

import SavageMode.Robber;
import SavageMode.BankSafe;
import SavageMode.Security;
import exceptions.TooMuchMoneyException;
import exceptions.YouAreBrokeException;
import interfaces.Person;


import java.util.Scanner;

public class Customer implements Person {
    private String name;
    private BankAccount account = new BankAccount(this);
    private int age;
    private Scanner reader = new Scanner(System.in);


    public Customer(String name, int age) {
        setName(name);
        setAge(age);
    }

    // REQUIRES: the method to be called by a valid Customer
    // MODIFIES: Bank Account
    // EFFECTS: allows the customer to deposit, withdraw, and invest using funds from Bank Account
    public void userChoice() {
        while (true) {
            System.out.println();
            System.out.println("Please enter the number of the desired action: ");
            System.out.println("(1) Deposit");
            System.out.println("(2) Withdraw");
            System.out.println("(3) Invest");
            System.out.println("(4) Simulate Investment");
            System.out.println("(5) Exit");
            System.out.println("(6) Rob the bank.");
            String choice = reader.nextLine();
        try {
            if (choice.equals("1")) {
                 account.deposit();
                 } else if (choice.equals("2")) {
                 account.withdraw();
                 } else if (choice.equals("3")) {
                 account.invest();
                 } else if (choice.equals("4")) {
                account.simulInvest();
                } else if (choice.equals("5")) {
                account.AccountHealth();
                System.exit(0);
                } else if (choice.equals("6")) {
                initializeRobbery();
            }
        } catch (YouAreBrokeException e) {
            System.out.println("You don't got that kinda money!");
        } catch (TooMuchMoneyException e) {
            System.out.println("That is an unusually high amount of cash. Notifying authorities. You better run boi.");
            System.exit(0);
        }
        }
    }

    private void initializeRobbery() {
        System.out.println("Would you like to play as:");
        System.out.println("(1) The Thief");
        System.out.println("(2) The Security");
        String choice = reader.nextLine();


        if (choice.equals("1")) {
            BankSafe letsPlay = new Robber();
            letsPlay.startHeist();
        } else if (choice.equals("2")) {
            BankSafe safety = new Security();
            safety.startHeist();
        }

    }

//    setBankAccount() {
//
//    }

    public void setName(String name) {
        this.name = name;
        account.accountName = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //getters nd ish...
    public String getName() {
        return this.name;
    }
    public int getAge()     { return this.age; }


}
