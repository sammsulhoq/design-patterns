package creational.factory;

public abstract class Logistics {
    // Factory Method
    public abstract Transport createTransport();

    // Common business logic that uses the transport
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

