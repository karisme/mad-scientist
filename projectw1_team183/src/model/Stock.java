package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

  public abstract class Stock {

    protected List<String> ListOfStock = new ArrayList<>();
    protected String APPL = "https://ca.finance.yahoo.com/quote/AAPL?p=AAPL&.tsrc=fin-srch";
    protected String MSFT = "https://ca.finance.yahoo.com/quote/MSFT?p=MSFT&.tsrc=fin-srch";
    protected String AMZN = "https://ca.finance.yahoo.com/quote/AMZN?p=AMZN&.tsrc=fin-srch";
    protected String BRKB = "https://ca.finance.yahoo.com/quote/BRK-B?p=BRK-B&.tsrc=fin-srch";
    protected String JPM  = "https://ca.finance.yahoo.com/quote/JPM?p=JPM&.tsrc=fin-srch";
    protected String FB   = "https://ca.finance.yahoo.com/quote/FB?p=FB&.tsrc=fin-srch";
//    protected String JNJ;
//    protected String XOM;
//    protected String GOOG;
//    protected String GOOGL;

//    public Stock(String name, String URL){
//        this.stockName = name;
//        this.stockURL = URL;
//    }

    //EFFECTS: initializes stock portfolio
    void setup(double i){}


    //EFFECTS: List either top 10 or top 25 stocks, or individual stock.
    abstract void printListOfStock() throws IOException;

    //EFFECTS: prints stock price of selected stock(s).
//     void searchAndPrint(String s) throws IOException{
//         System.out.println(ListOfStock);
//     }

     String getStockName(int place) {
        String placement = ListOfStock.get(place - 1);
        return placement.substring(2);
     }

}
