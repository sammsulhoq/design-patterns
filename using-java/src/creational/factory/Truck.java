package creational.factory;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by land in a truck.");
    }
}

