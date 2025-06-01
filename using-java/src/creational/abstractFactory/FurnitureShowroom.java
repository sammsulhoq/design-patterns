package creational.abstractFactory;

// Client Code
public class FurnitureShowroom {
    private final Chair chair;
    private final Sofa sofa;
    private final CoffeeTable table;

    public FurnitureShowroom(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.table = factory.createCoffeeTable();
    }

    public void showcase() {
        chair.sitOn();
        sofa.lieOn();
        table.placeThings();
    }
}
