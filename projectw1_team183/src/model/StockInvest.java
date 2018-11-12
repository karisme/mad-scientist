package model;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



// variation of https://www.youtube.com/watch?v=UVqjMbYlCFs

public class StockInvest extends StockData {
    private Random generate = new Random();
    private String currentStock;
    private int customerNumber = generate.nextInt(99999) + 10000;   //https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java how to random from:
    private double portfolioBalance;


    public void setup(double amount) {
        this.portfolioBalance = amount;
        this.startInvest();
    }


    // TODO: Figure out how to implement the ting.
    private void startInvest() {
        System.out.println("Hello Customer" + this.customerNumber + ". This is your balance: $" + portfolioBalance);
        try {
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
                this.currentStock = name;
                System.out.println(name);

            } catch (IndexOutOfBoundsException e) {
                System.out.println();
            }

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                stockAction(APPL, 1);
            } else if (choice == 2) {
                stockAction(MSFT, 2);
            } else if (choice == 3) {
                stockAction(AMZN, 3);
            } else if (choice == 4) {
                stockAction(BRKB, 4);
            } else if (choice == 5) {
                stockAction(JPM, 5);
            } else if (choice == 6) {
                stockAction(FB, 6);
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


    private void stockAction(String URL, int stockPlace) throws IOException {
        Scanner pick = new Scanner(System.in);
        String stockPrice = searchAndReturnStockPrice(URL);
        System.out.println(stockPrice);
        System.out.println("Would you like to buy this stock? [Yes] [No]");
        String decision = pick.nextLine();
        if (decision.equals("Yes")) {
            buyAndRecordStock(stockPrice, stockPlace, URL);
        }
    }

    //finesses the whole ting while also avoiding the errors nd dat
    private void buyAndRecordStock(String stockPrice, int stockPlace, String URL) {
        double price = Double.parseDouble(stockPrice.substring(1));
        if (price <= this.portfolioBalance) {
            this.portfolioBalance = this.portfolioBalance - price;
            StockRecord stock = new StockRecord("",URL);
            recordStock(stock, getStockName(stockPlace));  // TODO
            System.out.println("Successfully purchased Stock and added it to portfolio.");
            System.out.println("Your new balance is: " + this.portfolioBalance);
        } else {
            System.out.println("You can't afford the ting.");
        }
    }

    private void recordStock(StockRecord stock, String name) {
 //       myStocks.put(stock,name);
    }
}

