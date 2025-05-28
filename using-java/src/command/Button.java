package command;

// Invoker
public class Button {
    private String label;
    private Command command;

    public Button(String label, Command command) {
        this.label = label;
        this.command = command;
    }

    public void click() {
        System.out.println("[" + label + "] button clicked:");
        command.execute();
        System.out.println();
    }
}
