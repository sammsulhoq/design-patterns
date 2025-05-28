package state;

public interface DocumentState {
    String getName();
    void publish(Document document, User user);
}
