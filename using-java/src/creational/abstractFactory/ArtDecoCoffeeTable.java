package creational.abstractFactory;

// Concrete Products
public class ArtDecoCoffeeTable implements CoffeeTable{
    @Override
    public void placeThings() {
        System.out.println("Placing items on an ArtDeco coffee table.");
    }
}
