package structural.adapter;

// Simulates external XML source
public class StockDataXMLProvider {
    public String getStockDataXML() {
        return "<stock><symbol>GOOG</symbol><price>2750</price></stock>";
    }
}
