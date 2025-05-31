package structural.decorator;

// Concrete Decorator
public class SlackDecorator extends NotifierDecorator{
    private final String slackChannel;

    public SlackDecorator(Notifier wrappee, String slackChannel) {
        super(wrappee);
        this.slackChannel = slackChannel;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message to #" + slackChannel + ": " + message);
    }
}
