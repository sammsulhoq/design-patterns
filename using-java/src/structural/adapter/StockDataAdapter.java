package structural.adapter;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.json.JSONObject;

// Adapter
public class StockDataAdapter {
    private final StockDataXMLProvider xmlProvider;

    public StockDataAdapter(StockDataXMLProvider xmlProvider) {
        this.xmlProvider = xmlProvider;
    }

    public String getStockDataAsJSON() {
        try {
            String xml = xmlProvider.getStockDataXML();

            // Parse XML string into DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

            String symbol = doc.getElementsByTagName("symbol").item(0).getTextContent();
            String price = doc.getElementsByTagName("price").item(0).getTextContent();

            JSONObject json = new JSONObject();
            json.put("symbol", symbol);
            json.put("price", Double.parseDouble(price));

            return json.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error converting XML to JSON", e);
        }
    }
}
