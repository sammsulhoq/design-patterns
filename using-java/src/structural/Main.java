package structural;

import structural.adapter.*;
import structural.bridge.*;
import structural.composite.*;
import structural.decorator.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Testing COMPOSITE pattern
        Product phone = new Product("Smartphone", 700);
        Product charger = new Product("Charger", 50);
        Product headphones = new Product("Headphones", 150);
        Product book = new Product("Book", 30);

        Box accessoryBox = new Box("Accessory Box");
        accessoryBox.add(charger);
        accessoryBox.add(headphones);

        Box mainBox = new Box("Main Box");
        mainBox.add(phone);
        mainBox.add(accessoryBox);
        mainBox.add(book);

        System.out.println("Total order price for Main Box: $" + mainBox.getPrice());
        System.out.println("Total order price for Accessory Boz: $" + accessoryBox.getPrice());
        System.out.println("\n\n");

        // Testing ADAPTER pattern
        StockDataXMLProvider xmlProvider = new StockDataXMLProvider();

            // Adapter to convert XML to JSON
        StockDataAdapter adapter = new StockDataAdapter(xmlProvider);

            // 3rd-party analytics consumer
        StockDataJSONConsumer analyticsLib = new StockDataJSONConsumer();

            // Convert XML to JSON and pass to analytics library
        String jsonData = adapter.getStockDataAsJSON();
        analyticsLib.processStockData(jsonData);
        System.out.println("\n\n");

        // Testing BRIDGE pattern
        Shape redCircle = new Circle(new Red());
        Shape blueSquare = new Square(new Blue());
        Shape greenTriangle = new Triangle(new Green());

        redCircle.draw();
        blueSquare.draw();
        greenTriangle.draw();
        System.out.println("\n\n");

        // Testing DECORATOR pattern
        Notifier emailNotifier = new EmailNotifier(List.of("alice@example.com", "bob@example.com"));
        Notifier facebookNotifier = new FacebookDecorator(emailNotifier, "alice.fb");
        Notifier slackNotifier = new SlackDecorator(facebookNotifier, "alerts");
        Notifier multiNotifier = new SMSDecorator(slackNotifier, "+123456789");
        multiNotifier.send("🔥 CRITICAL: Server is down!");
        System.out.println("\n\n");
    }
}
