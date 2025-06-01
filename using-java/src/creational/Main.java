package creational;

import creational.abstractFactory.*;
import creational.builder.*;
import creational.factory.* ;
import creational.prototype.*;

public class Main {
    public static void main(String[] args) {
        // Testing ABSTRACT FACTORY pattern
        System.out.println("Modern Furniture:");
        FurnitureShowroom modern = new FurnitureShowroom(new ModernFurnitureFactory());
        modern.showcase();

        System.out.println("\nVictorian Furniture:");
        FurnitureShowroom victorian = new FurnitureShowroom(new VictorianFurnitureFactory());
        victorian.showcase();

        System.out.println("\nArtDeco Furniture:");
        FurnitureShowroom artDeco = new FurnitureShowroom(new ArtDecoFurnitureFactory());
        artDeco.showcase();
        System.out.println("\n\n");

        // Testing BUILDER pattern
        House simpleHouse = new House.HouseBuilder(4, 2, true)
                .withPlumbing()
                .withElectricity()
                .build();

        System.out.println("Simple House:");
        simpleHouse.describe();

        System.out.println("\nLuxury Villa:");
        // Luxury House with more features
        House luxuryVilla = new House.HouseBuilder(6, 8, true)
                .withGarage()
                .withSwimmingPool()
                .withGarden()
                .withHeating()
                .withPlumbing()
                .withElectricity()
                .build();

        luxuryVilla.describe();
        System.out.println("\n\n");

        // Testing FACTORY METHOD pattern
        Logistics road = new RoadLogistics();
        Logistics sea = new SeaLogistics();

        System.out.println("Road Logistics:");
        road.planDelivery();

        System.out.println("\nSea Logistics:");
        sea.planDelivery();
        System.out.println("\n\n");

        // Testing PROTOTYPE pattern
        Address address = new Address("New York", "10001");
        Person original = new Person("Alice", 30, address);

        System.out.println("Original:");
        original.print();

        System.out.println("\nCloning...");
        Person cloned = original.clone();

        // Modify clone
        cloned.setName("Bob");
        cloned.print();

        System.out.println("\nOriginal remains unchanged:");
        original.print();
        System.out.println("\n\n");
    }
}
