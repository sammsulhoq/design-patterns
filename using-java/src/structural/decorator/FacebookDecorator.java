package structural.decorator;

public class FacebookDecorator extends NotifierDecorator{
    private final String fbAccount;

    public FacebookDecorator(Notifier wrappee, String fbAccount) {
        super(wrappee);
        this.fbAccount = fbAccount;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Facebook message to @" + fbAccount + ": " + message);
    }
}
