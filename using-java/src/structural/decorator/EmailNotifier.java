package structural.decorator;

import java.util.List;

// Concrete component
public class EmailNotifier implements Notifier{
    private final List<String> emailList;

    public EmailNotifier(List<String> emailList) {
        this.emailList = emailList;
    }

    @Override
    public void send(String message) {
        for(String email: emailList) {
            System.out.println("Sending EMAIL to " + email + ": " + message);
        }
    }
}
