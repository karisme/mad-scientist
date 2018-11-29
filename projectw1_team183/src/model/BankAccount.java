package model;


import exceptions.TooMuchMoneyException;
import exceptions.YouAreBrokeException;
import investements.StockInvest;

import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import java.text.DecimalFormat;

public class BankAccount {
    public double balance;
    protected String accountName;
    private Customer user;
    private ArrayList<String> accountHistory;
    Scanner reader = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat(".##");
    //from website


    public BankAccount(Customer user) {
        this.user = user;
        this.balance = 0.0;
        this.accountHistory = new ArrayList<>();
    }

    // REQUIRES: amount entered to be non-negative
    // MODIFIES: this
    // EFFECTS: adds deposit to customer's balance
    public void deposit() throws TooMuchMoneyException {
        System.out.print("How much would you like to deposit: ");
        double depositAmount = reader.nextDouble();
        if (depositAmount >= 1000000000) {
            throw new TooMuchMoneyException("Alert!", "This is an unsually high amount of cash!");
        }


        this.balance = this.balance + depositAmount;
        String record = "Deposit: " + depositAmount;
        accountHistory.add(record);

        System.out.println("Your new balance: $" + this.balance);
    }


    // EFFECTS: allows a customer to estimate earnings by entering period and monthly interest
    public void simulInvest() {
        System.out.println("How many months would you like to simulate (minimum 4 months): ");
        int months = reader.nextInt();
        if (months >= 4) {
            System.out.println("Expected return on investment in terms of percentage(monthly interest): ");
            double percentage = reader.nextDouble() / 100;

            int i = 0;
            double currentAmount = getBalance();
            //double estimation;

            while (i < months) {
                currentAmount = currentAmount * (1 + percentage);
                i++;
            }
            double profit = (currentAmount - getBalance());

            System.out.println("If you invest in a firm with your current balance for a period of " + months +
                    " months with an expected " + percentage * 100 + "% return on investment, you can expect to make $"
                    + df2.format(profit) + ".");

        } else {
            System.out.println("Pick a higher month.");
            simulInvest();
        }
    }

    // REQUIRES: amount withdrawn has to be less than or equal to balance
    // MODIFIES: this
    // EFFECTS: withdraws a certain amount from customer's balance.
    public void withdraw() throws YouAreBrokeException {
        System.out.println("How much would you like to withdraw: ");
        double withdrawAmount = reader.nextDouble();
        if (withdrawAmount <= this.balance) {
            this.balance = this.balance - withdrawAmount;
            String record = "Withdraw: " + withdrawAmount;
            accountHistory.add(record);
        } else {
            throw new YouAreBrokeException("Alert!", "You are broke, you don't have that money fam, you're not slick.");
        }



        System.out.println("Your new balance: $" + this.balance);

    }

    // getters nd ish...
    private double getBalance() {
        return this.balance;
    }
    public String getName () {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
        user.setName(accountName);
    }

    // EFFECTS: prints out an account summary and saves info to a text file.
    public void AccountHealth() {
        //Represents how much money I have
        System.out.println(getName() + "'s Account");
        System.out.println("Balance: " + this.balance);
        System.out.println(accountHistory);
        try {
            save();
        } catch (IOException e) {
            System.out.println("Error saving or reading, we dont know why lmao #bestProgammer");
        } finally {
            System.out.println("Go get that money!");
        }
    }

    // EFFECTS: Saves the class onto file nd dat. Reads the input frm the file innit.
    private void save() throws IOException{
        int i = 1;
        PrintWriter writer = new PrintWriter("recordfile.txt", "UTF-8");
        List<String> currentDateList;
        currentDateList = Files.readAllLines(Paths.get("currentdate.txt"));
        Date today = Calendar.getInstance().getTime();
        writer.println(today);
        writer.println(currentDateList.get(1));
        writer.println();

        for (String record : accountHistory) {

            record = i + ". " + record; i++;
            writer.println(record);
        }
        writer.close();
    }

//     setBankAccount(Customer user) {
//
//     }



    // REQUIRES: A bank account with at least x balance. (TBD)
    // MODIFIES: this
    // EFFECTS: allows customer to take a portion of their balance and create an investment portfolio (TBD).
    public void invest() {
        System.out.println("How much would you like to deposit into your Investment Portfolio: ");
        double amount = reader.nextDouble();
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
            StockInvest playStock = new StockInvest();
            String record = "Invested: $" + amount;
            accountHistory.add(record);
            playStock.setup(amount);

        } else {
            System.out.println("You don't have enough!");
        }

    }

}
