package mediator;

// Base Component
public abstract class UIControl {
    protected Mediator mediator;

    public UIControl(Mediator mediator) {
        this.mediator = mediator;
    }

    public void changed(String event) {
        mediator.notify(this, event);
    }
}
