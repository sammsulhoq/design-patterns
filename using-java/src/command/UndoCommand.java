package command;

public class UndoCommand implements Command{
    private EditorApplication editorApplication;

    public UndoCommand(EditorApplication editorApplication) {
        this.editorApplication = editorApplication;
    }

    @Override
    public void execute() {
        editorApplication.undo();
    }
}
