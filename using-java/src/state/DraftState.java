package state;

public class DraftState implements DocumentState{
    @Override
    public String getName() {
        return "Draft";
    }

    @Override
    public void publish(Document document, User user) {
        System.out.println("Moving document from 'Draft' to 'Moderation'");
        document.setState(new ModerationState());
    }
}
