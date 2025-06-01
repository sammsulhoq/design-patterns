package creational;

import creational.abstractFactory.*;

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
    }
}
