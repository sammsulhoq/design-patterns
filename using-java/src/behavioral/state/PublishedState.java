package behavioral.state;

public class PublishedState implements DocumentState{
    @Override
    public String getName() {
        return "Published";
    }

    @Override
    public void publish(Document document, User user) {
        System.out.println("Document is published!");
    }
}
