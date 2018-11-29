package observers;

import investements.StockRecord;

import java.util.Observable;
import java.util.Observer;

public class StockTracker implements Observer {
    private int counter;

    @Override
    public void update(Observable o, Object arg) {
        StockRecord stock = (StockRecord) arg;

        System.out.println();
        System.out.println(((StockRecord) stock).getStockID() + " has been successfully added.");
        System.out.println();

        counter++;
    }

    public int getCounter() {
        return this.counter;
    }
}
