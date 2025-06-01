package creational.abstractFactory;

// Abstract Factory Interface
public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}
