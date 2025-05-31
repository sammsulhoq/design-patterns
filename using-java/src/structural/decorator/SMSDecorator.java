package structural.decorator;

// Concrete Decorators
public class SMSDecorator extends NotifierDecorator{
    private final String phone;

    public SMSDecorator(Notifier wrappee, String phone) {
        super(wrappee);
        this.phone = phone;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS to " + phone + ": " + message);
    }
}
