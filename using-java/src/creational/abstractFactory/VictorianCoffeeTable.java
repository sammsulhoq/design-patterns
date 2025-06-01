package creational.abstractFactory;

// Concrete Products
public class VictorianCoffeeTable implements CoffeeTable{
    @Override
    public void placeThings() {
        System.out.println("Placing items on a Victorian coffee table.");
    }
}
