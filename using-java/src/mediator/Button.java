package mediator;

public class Button extends UIControl{
    public Button(Mediator mediator) {
        super(mediator);
    }

    public void click() {
        System.out.println("Button clicked");
        changed("click");
    }
}
