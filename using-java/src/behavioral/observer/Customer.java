package behavioral.observer;

// Concrete Observer
public class Customer implements Observer{
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String product) {
        System.out.println("Hey " + name + "! The product '" + product + "' is now available at the store.");
    }
}
