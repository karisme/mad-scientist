package model;

import java.util.Objects;

public class StockRecord {
    private String stockID;
    private String stockURL;

    public StockRecord(String ID, String URL){
        this.stockURL = URL;
        this.stockID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockRecord that = (StockRecord) o;
        return Objects.equals(stockID, that.stockID) &&
                Objects.equals(stockURL, that.stockURL);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stockID, stockURL);
    }

}
    // pray for me

