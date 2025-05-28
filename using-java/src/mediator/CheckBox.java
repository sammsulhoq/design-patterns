package mediator;

public class CheckBox extends UIControl{
    private boolean checked = false;

    public CheckBox(Mediator mediator) {
        super(mediator);
    }

    public void toggle() {
        checked = !checked;
        System.out.println("Checkbox toggled: " + (checked ? "Checked" : "Unchecked"));
        changed("toggle");
    }

    public boolean isChecked() {
        return checked;
    }
}
