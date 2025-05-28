import memento.Editor;
import memento.History;
import state.Document;
import state.User;

public class Main {
    public static void main(String[] args) {
        // Testing MEMENTO Pattern
        Editor editor = new Editor();
        History editorHistory = new History();

        editor.setContent("a");
        editorHistory.push(editor.createState());

        editor.setContent("b");
        editorHistory.push(editor.createState());

        editor.setContent("c");
        editorHistory.push(editor.createState());

        editor.restore(editorHistory.pop());
        editor.restore(editorHistory.pop());

        System.out.println(editor.getContent());
        System.out.println("\n\n");

        // Testing STATE Pattern
        User regularUser = new User("Jeff", false);
        User adminUser = new User("Dave", true);

        Document document = new Document();

        document.publish(regularUser); // Draft -> Moderation

        document.publish(regularUser); // should be rejected
        document.publish(adminUser); // Moderation -> Published

        document.publish(adminUser); // Does nothing as document is already published
    }
}
