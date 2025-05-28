package behavioral.command;

public class PasteCommand implements Command{
    private EditorApplication editorApplication;

    public PasteCommand(EditorApplication editorApplication) {
        this.editorApplication = editorApplication;
    }

    @Override
    public void execute() {
        editorApplication.paste();
    }
}
