package investements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


// point of this class is almost like a big ass Data Definition from racket.
// For S&P 500 top 25 by market cap as of 10/10/2018 using https://www.slickcharts.com/sp500
// Also allows you to pull Data from a stock of your choice.


public class StockData extends Observable {
    Scanner reader = new Scanner(System.in);
    protected Map<StockRecord, String> myStocks = new HashMap<>();
    protected List<String> ListOfStock = new ArrayList<>();

    protected String APPL = "https://api.iextrading.com/1.0/stock/AAPL/price";
    protected String MSFT = "https://api.iextrading.com/1.0/stock/MSFT/price";
    protected String AMZN = "https://api.iextrading.com/1.0/stock/AMZN/price";
    protected String BRKB = "https://api.iextrading.com/1.0/stock/BKR.B/price";
    protected String JPM  = "https://api.iextrading.com/1.0/stock/JPM/price";
    protected String FB   = "https://api.iextrading.com/1.0/stock/FB/price";

    protected String APPLID = "AAPL";
    protected String MSFTID = "MSFT";
    protected String AMZNID = "AMZN";
    protected String BRKBID = "BRK.B";
    protected String JPMID = "JPM";
    protected String FBID = "FB";



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


    /// YAHOO FINANCE SEARCH APPEND STOCK ID TO FINANCE URL
//    public String searchAndReturnStockPrice(String URL) throws IOException {
//        java.net.URL url = new URL(URL);
//        URLConnection urlConnection = url.openConnection();
//
//        InputStreamReader iStream = new InputStreamReader(urlConnection.getInputStream());
//        BufferedReader big = new BufferedReader(iStream);
//
//        String line = big.readLine();
//        String result = "not found";
//        while (line != null) {
//            if (line.contains("</span><div class=")) {
//                int target = line.indexOf("</span><div class=") - 10;
//                int decimal = line.indexOf(".", target);
//                int start = decimal;
//                while (line.charAt(start) != '>') {
//                    start--;
//                }
//                result = "$" + line.substring(start + 1, decimal + 3);
//            }
//            line = big.readLine();
//        }
//        return result;
//    }





// uses IEX Trading

    protected String stockPriceThroughAPI(String URL) throws IOException {
        java.net.URL url = new URL(URL);
        URLConnection urlConnection = url.openConnection();

        InputStreamReader iStream = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader big = new BufferedReader(iStream);

        String line = big.readLine();
        String result = line;
        return result;
    }




    // finessed https://beginnersbook.com/2013/12/how-to-serialize-hashmap-in-java/
    protected void saveStocks() {   ///LOOOOOOADING
        try {
            FileOutputStream boss = new FileOutputStream("stockMap.ser");
            ObjectOutputStream sheesh = new ObjectOutputStream(boss);
            sheesh.writeObject(myStocks);

            sheesh.close();
            boss.close();

            System.out.println("I did it Mom!");
            {

            }
        }
         catch (Exception e) {
             System.out.println("bro");
             e.printStackTrace();
            }
        System.out.println();
        }


    protected String getStockName(int place) {
        String placement = ListOfStock.get(place - 1);
        return placement.substring(2);
    }

}




