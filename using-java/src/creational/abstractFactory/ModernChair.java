package creational.abstractFactory;

// Concrete Products
public class ModernChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair.");
    }
}
