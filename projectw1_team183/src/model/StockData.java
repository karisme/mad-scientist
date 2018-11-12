package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

// point of this class is almost like a big ass Data Definition from racket.
// For S&P 500 top 25 by market cap as of 10/10/2018 using https://www.slickcharts.com/sp500
// Also allows you to pull Data from a stock of your choice.


public class StockData extends Stock {
    Scanner reader = new Scanner(System.in);
    protected Map<StockRecord, String> myStocks = new HashMap<>();

//    public StockData(String name, String URL) {
//        super(name, URL);
//    }

    public void printListOfStock() {
        ListOfStock.add("1. Apple");
        ListOfStock.add("2. Microsoft");
        ListOfStock.add("3. Amazon");
        ListOfStock.add("4. Berkshire Hathaway Inc.");
        ListOfStock.add("5. JP Morgan Stanley");
        ListOfStock.add("6. Facebook");
        ListOfStock.add("7. Add Other Stock");
        ListOfStock.add("8. My Portfolio");
        ListOfStock.add("0. Quit");

        for (String s : ListOfStock) {
            System.out.println(s);
        }
    }

    private void printStockName(StockRecord Stock) {
        System.out.println(myStocks.get(Stock));
    }

    public void userFetchedStock() {
        System.out.print("Enter the name of the stock you would like to finesse: ");
        String stockName = reader.nextLine();
        System.out.print("Enter the stock ID for the stock you would like to finesse (make sure this is correct): ");
        String stockID = reader.nextLine();
        String URL = "https://ca.finance.yahoo.com/quote/" + stockID + "?p=AMD&.tsrc=fin-srch";

        StockRecord newStock = new StockRecord(stockID, URL);
        if (!myStocks.containsKey(newStock)) {
            myStocks.put(newStock, stockName);
            printStockName(newStock);
            try {
                String price = searchAndReturnStockPrice(URL);
                System.out.println(price);
            } catch (IOException e) {
                System.out.println("Wrong stock ID buddy. ");
            }


        } else {
            System.out.println("Sorry bro, you already have the stock.");
        }
    }
    /// YAHOO FINANCE SEARCH APPEND STOCK ID TO FINANCE URL

    public String searchAndReturnStockPrice(String URL) throws IOException {
        java.net.URL url = new URL(URL);
        URLConnection urlConnection = url.openConnection();

        InputStreamReader iStream = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader big = new BufferedReader(iStream);

        String line = big.readLine();
        String result = "not found";
        while (line != null) {
            if (line.contains("</span><div class=")) {
                int target = line.indexOf("</span><div class=") - 10;
                int decimal = line.indexOf(".", target);
                int start = decimal;
                while (line.charAt(start) != '>') {
                    start--;
                }
                result = "$" + line.substring(start + 1, decimal + 3);
            }
            line = big.readLine();
        }
        return result;
    }

}
