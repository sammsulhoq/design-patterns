package behavioral.state;

public class ModerationState implements DocumentState{
    @Override
    public String getName() {
        return "Moderation";
    }

    @Override
    public void publish(Document document, User user) {
        if (user.isAdmin()) {
            System.out.println("Moving from 'Moderation' to 'Published'");
            document.setState(new PublishedState());
        }
    }
}
