import chainOfResponsibility.*;
import command.*;
import iterator.*;
import mediator.CustomerProfileDialog;
import memento.*;
import observer.*;
import state.*;
import strategy.*;
import template.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Testing MEMENTO Pattern
        Editor editor = new Editor();
        History editorHistory = new History();

        editor.setContent("a");
        editorHistory.push(editor.createState());

        editor.setContent("b");
        editorHistory.push(editor.createState());

        editor.setContent("c");
        editorHistory.push(editor.createState());

        editor.restore(editorHistory.pop());
        editor.restore(editorHistory.pop());

        System.out.println(editor.getContent());
        System.out.println("\n\n");

        // Testing STATE Pattern
        User regularUser = new User("Jeff", false);
        User adminUser = new User("Dave", true);

        Document document = new Document();

        document.publish(regularUser); // Draft -> Moderation

        document.publish(regularUser); // should be rejected
        document.publish(adminUser); // Moderation -> Published

        document.publish(adminUser); // Does nothing as document is already published
        System.out.println("\n\n");

        // Testing ITERATOR pattern
        Profile alice = new Profile("alice@company.com", "Alice", "CompanyA");
        Profile bob = new Profile("bob@company.com", "Bob", "CompanyA");
        Profile charlie = new Profile("charlie@other.com", "Charlie", "CompanyB");
        Profile diana = new Profile("diana@company.com", "Diana", "CompanyA");

        FaceBook facebook = new FaceBook();
        facebook.addFriends("alice@company.com", List.of(bob, charlie, diana));

            // Get friends iterator
        System.out.println("Alice's Friends:");
        ProfileIterator friendsIterator = facebook.createFriendsIterator("alice@company.com");
        while (friendsIterator.hasNext()) {
            System.out.println(friendsIterator.getNext());
        }

            // Get colleagues iterator
        System.out.println("\nAlice's Colleagues:");
        ProfileIterator colleaguesIterator = facebook.createColleaguesIterator("alice@company.com");
        while (colleaguesIterator.hasNext()) {
            System.out.println(colleaguesIterator.getNext());
        }
        System.out.println("\n\n");

        // Testing STRATEGY pattern
        Navigator navigator = new Navigator();

        navigator.setStrategy(new CarRouteStrategy());
        navigator.buildRoute("Hotel", "Museum");

        navigator.setStrategy(new WalkingRouteStrategy());
        navigator.buildRoute("Museum", "Cafe");

        navigator.setStrategy(new PublicTransportRouteStrategy());
        navigator.buildRoute("Cafe", "Theater");

        navigator.setStrategy(new CyclingRouteStrategy());
        navigator.buildRoute("Theater", "Park");

        navigator.setStrategy(new TouristAttractionRouteStrategy());
        navigator.buildRoute("Park", "Historic Castle");

        System.out.println("\n\n");

        // Testing TEMPLATE METHOD pattern
        DocumentProcessor doc = new DocProcessor();
        doc.processDocument("resume.doc");

        System.out.println("\n---\n");

        DocumentProcessor csv = new CsvProcessor();
        csv.processDocument("data.csv");

        System.out.println("\n---\n");

        DocumentProcessor pdf = new PdfProcessor();
        pdf.processDocument("report.pdf");
        System.out.println("\n\n");

        // Testing COMMAND pattern
        EditorApplication editorApplication = new EditorApplication();

            // Create commands
        Command copy = new CopyCommand(editorApplication);
        Command paste = new PasteCommand(editorApplication);
        Command undo = new UndoCommand(editorApplication);

            // Create UI buttons
        Button copyBtn = new Button("Copy", copy);
        Button pasteBtn = new Button("Paste", paste);
        Button undoBtn = new Button("Undo", undo);

            // Keyboard shortcuts
        KeyboardShortcut ctrlC = new KeyboardShortcut("Ctrl+C", copy);
        KeyboardShortcut ctrlV = new KeyboardShortcut("Ctrl+V", paste);
        KeyboardShortcut ctrlZ = new KeyboardShortcut("Ctrl+Z", undo);

            // Trigger commands
        copyBtn.click();
        pasteBtn.click();
        undoBtn.click();

        ctrlC.press();
        ctrlV.press();
        ctrlZ.press();
        System.out.println("\n\n");

        // Testing OBSERVER pattern
        Store appleStore = new Store();

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Charlie");

            // Alice and Charlie are interested in iPhone 15
        appleStore.registerObserver("iPhone 15", customer1);
        appleStore.registerObserver("iPhone 15", customer3);

            // Bob is interested in MacBook Pro
        appleStore.registerObserver("MacBook Pro", customer2);

            // Product released
        appleStore.addNewProduct("iPhone 15");
        appleStore.addNewProduct("MacBook Pro");

            // Nothing happens for iPad Air, no one is subscribed
        appleStore.addNewProduct("iPad Air");
        System.out.println("\n\n");

        // Testing MEDIATOR pattern
        CustomerProfileDialog dialog = new CustomerProfileDialog();
        dialog.setup();

        dialog.customerNameField.setText("John Doe");

        dialog.hasDogCheckbox.toggle(); // Reveal dog name field
        dialog.dogNameField.setText("Buddy");

        dialog.submitButton.click(); // Valid submission

        System.out.println("\n---\n");

        // Try submitting without dog name
        dialog.hasDogCheckbox.toggle(); // Uncheck
        dialog.hasDogCheckbox.toggle(); // Re-check to reveal again
        dialog.dogNameField.setText(""); // Reset dog name

        dialog.submitButton.click(); // Should throw error
        System.out.println("\n\n");

        // Testing CHAIN OF RESPONSIBILITY pattern
        Request request = new Request("user", "pass", "192.168.1.10", "/getOrders");

        // Setup chain
        BruteForceProtectionHandler bruteForce = new BruteForceProtectionHandler();
        bruteForce
                .setNext(new AuthenticationHandler())
                .setNext(new SanitizationHandler())
                .setNext(new AuthorizationHandler())
                .setNext(new CacheHandler());

        // Execute chain
        boolean success = bruteForce.handle(request);
        if (success) {
            System.out.println("Request processed successfully.");
        } else {
            System.out.println("Request failed during validation.");
            bruteForce.registerFailure(request.ip);
        }
        System.out.println("\n\n");
    }
}
