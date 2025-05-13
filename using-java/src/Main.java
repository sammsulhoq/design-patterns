import memento.Editor;
import memento.History;

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
    }
}
