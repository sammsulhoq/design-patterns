package command;

// Receiver
public class EditorApplication {
    private String clipboard = "";
    private StringBuilder text = new StringBuilder("Hello, this is sample text.");
    private int selectionStart = 7;
    private int selectionEnd = 11;

    public void copy() {
        clipboard = text.substring(selectionStart, selectionEnd);
        System.out.println("Copied to clipboard: '" + clipboard + "'");
    }

    public void paste() {
        text.insert(selectionEnd, selectionStart);
        System.out.println("Text after paste: " + text);
    }

    public void undo() {
        System.out.println("Undo operation performed (simulated).");
    }

    public String getClipboard() {
        return clipboard;
    }

    public String getText() {
        return text.toString();
    }
}
