package creational.abstractFactory;

// Concrete Products
public class ArtDecoSofa implements Sofa{
    @Override
    public void lieOn() {
        System.out.println("Lying on an ArtDeco sofa.");
    }
}
