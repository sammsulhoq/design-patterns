package mediator;

public class TextBox extends UIControl{
    private String text = "";
    private boolean visible = true;

    public TextBox(Mediator mediator) {
        super(mediator);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        changed("textChanged");
    }

    public void show() {
        visible = true;
        System.out.println("TextBox shown");
    }

    public void hide() {
        visible = false;
        System.out.println("TextBox hidden");
    }

    public boolean isVisible() {
        return  visible;
    }
}
