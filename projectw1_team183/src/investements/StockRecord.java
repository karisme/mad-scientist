package investements;

import java.util.Objects;

public class StockRecord {
    private String stockID;
    private Double stockPrice;

    public StockRecord(String ID, Double price){
        this.stockID = ID;
        this.stockPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockRecord)) return false;
        StockRecord that = (StockRecord) o;
        return Objects.equals(stockID, that.stockID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockID);
    }

    @Override
    public String toString() {
        String printed = this.stockID + ": $" + this.stockPrice;
        return printed;
    }

    public void setPrice(double price) {
        this.stockPrice = price;
    }

    public String getStockID() {
        return this.stockID;
    }
}
    // pray for me

