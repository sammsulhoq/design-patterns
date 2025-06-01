package creational.abstractFactory;

// Concrete Products
public class VictorianChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Sitting on a Victorian chair.");
    }
}
