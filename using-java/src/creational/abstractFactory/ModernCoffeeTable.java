package creational.abstractFactory;

// Concrete Products
public class ModernCoffeeTable implements CoffeeTable{
    @Override
    public void placeThings() {
        System.out.println("Placing items on a modern coffee table.");
    }
}
