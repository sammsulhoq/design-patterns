package creational.factory;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering goods by sea in a ship.");
    }
}

