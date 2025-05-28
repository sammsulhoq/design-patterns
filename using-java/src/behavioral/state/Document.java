package behavioral.state;

public class Document {
    private DocumentState state;

    public Document() {
        this.state = new DraftState();
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public void publish(User user) {
        System.out.println("Current behavioral.state: " + state.getName());
        state.publish(this, user);
        System.out.println("New behavioral.state: " + state.getName());
    }

    public String getCurrentStateName() {
        return state.getName();
    }
}
