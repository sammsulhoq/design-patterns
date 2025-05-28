package behavioral.command;

// Invoker
public class KeyboardShortcut{
    private String keyCombo;
    private Command command;

    public KeyboardShortcut(String keyCombo, Command command) {
        this.keyCombo = keyCombo;
        this.command = command;
    }

    public void press() {
        System.out.println("[" + keyCombo + "] shortcut pressed:");
        command.execute();
        System.out.println();
    }
}
