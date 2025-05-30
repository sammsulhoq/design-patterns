package structural;

import structural.composite.*;

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
    }
}
