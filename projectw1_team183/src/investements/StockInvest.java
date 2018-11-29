package investements;

import observers.StockTracker;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



// variation of https://www.youtube.com/watch?v=UVqjMbYlCFs

public class StockInvest extends StockData {
    private Random generate = new Random();
    private StockTracker tracker = new StockTracker();
    private int customerNumber = generate.nextInt(99999) + 10000;   //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java how to random from:
    private double portfolioBalance;


    public void setup(double amount) {
        this.portfolioBalance = amount;
        this.startInvest();
    }

// TODO
    // TODO: Figure out how to implement the ting.
    private void startInvest() {
        System.out.println("Hello Customer" + this.customerNumber + ". This is your balance: $" + portfolioBalance);
        try {
            addObserver(tracker);
            pickStockList();
        } catch (IOException e) {
            System.out.println("Some weird ish happened, don't exactly know what but check connection and try again.");
        } catch (InputMismatchException e) {
            System.out.println("Pick the right option fam...");
            startInvest();
        }
    }

    public void pickStockList() throws IOException, InputMismatchException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please pick one of the following: ");
        printListOfStock();
        System.out.println();

        while (true) {
            int choice = reader.nextInt();
            try {
                String name = getStockName(choice);
                System.out.println(name);

            } catch (IndexOutOfBoundsException e) {
                System.out.println();
            }

            if (choice == 0) {
              //  saveStocks();
                System.out.println("Acquired " + tracker.getCounter() + " new stock(s).");
                break;
            } else if (choice == 1) {
                stockAction(APPL, 1, APPLID);
            } else if (choice == 2) {
                stockAction(MSFT, 2, MSFTID);
            } else if (choice == 3) {
                stockAction(AMZN, 3, AMZNID);
            } else if (choice == 4) {
                stockAction(BRKB, 4, BRKBID);
            } else if (choice == 5) {
                stockAction(JPM, 5, JPMID);
            } else if (choice == 6) {
                stockAction(FB, 6, FBID);
            } else if (choice == 7) {
                userFetchedStock();
            } else if (choice == 8) {
                // TODO
            } else {
                System.out.println("Pick again my g.");
            }
            System.out.println("Type another option. ");
        }

    }

    public void userFetchedStock() {
        System.out.print("Enter the name of the stock you would like to finesse: ");
        String stockName = reader.nextLine();
        System.out.print("Enter the stock ID for the stock you would like to finesse (make sure this is correct): ");
        String stockID = reader.nextLine();
        String URL = "https://api.iextrading.com/1.0/stock/" + stockID + "/price"; ;


        if (!myStocks.containsValue(stockName)) {
            try {
                makeChoice(URL,stockName,stockID);
            } catch (IOException e) {
                System.out.println("Wrong stock ID buddy. ");
            }


        } else {
            sellOrKeep();
        }
    }


    public void makeChoice(String URL, String stockName, String stockID) throws IOException {
        String stockPrice = stockPriceThroughAPI(URL);
        System.out.println("$" + stockPrice);
        System.out.println("Would you like to buy this stock? [Yes] [No]");
        String decision = reader.nextLine();

        if (decision.equals("Yes")) {
            StockRecord stock = new StockRecord(stockID,Double.parseDouble(stockPrice));
            buyAndRecordStock(stockPrice, stockName,stock);
        }
    }


    private void stockAction(String URL, int stockPlace, String iD) throws IOException {
        String stockName = getStockName(stockPlace);
        if (myStocks.containsValue(stockName)) {
            sellOrKeep();
        } else {
           makeChoice(URL,stockName,iD);
        }
    }

    //finesses the whole ting while also avoiding the errors nd dat
    private void buyAndRecordStock(String stockPrice, String stockName, StockRecord stock) {
        myStocks.put(stock, stockName);
        double price = Double.parseDouble(stockPrice);
        if (price <= this.portfolioBalance) {
            this.portfolioBalance = this.portfolioBalance - price;

            setChanged();
            notifyObservers(stock);

            System.out.println("Your new balance is: " + this.portfolioBalance);
        } else {
            System.out.println("You can't afford the ting.");
        }
    }

    private void sellOrKeep() {
        System.out.println("You already have the Stock.");
    }

}

