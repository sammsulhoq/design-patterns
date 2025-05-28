package mediator;

// Concrete Mediator
public class CustomerProfileDialog implements Mediator{
    public CheckBox hasDogCheckbox;
    public TextBox dogNameField;
    public TextBox customerNameField;
    public Button submitButton;

    public void setup() {
        hasDogCheckbox = new CheckBox(this);
        dogNameField = new TextBox(this);
        customerNameField = new TextBox(this);
        submitButton = new Button(this);

        dogNameField.hide();
    }

    @Override
    public void notify(UIControl sender, String event) {
        if (sender == hasDogCheckbox && event.equals("toggle")) {
            if(hasDogCheckbox.isChecked()) {
                dogNameField.show();
            }

            dogNameField.hide();
        }

        if (sender == submitButton && event.equals("click")) {
            validateAndSubmit();
        }
    }

    public void validateAndSubmit() {
        if (customerNameField.getText().isEmpty()) {
            System.out.println("ERROR: Customer name is required.");
            return;
        }

        if (hasDogCheckbox.isChecked() && dogNameField.getText().isEmpty()) {
            System.out.println("ERROR: Dog's name is required.");
            return;
        }

        System.out.println("Form submitted successfully!");
    }
}
