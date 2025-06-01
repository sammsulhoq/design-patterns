package creational.abstractFactory;

// Concrete Products
public class ArtDecoChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Sitting on an ArtDeco chair.");
    }
}
