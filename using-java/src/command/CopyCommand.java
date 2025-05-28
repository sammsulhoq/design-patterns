package command;

// Concrete class
public class CopyCommand implements Command{
    private EditorApplication editorApplication;

    public CopyCommand(EditorApplication editorApplication) {
        this.editorApplication = editorApplication;
    }

    @Override
    public void execute() {
        editorApplication.copy();
    }
}
