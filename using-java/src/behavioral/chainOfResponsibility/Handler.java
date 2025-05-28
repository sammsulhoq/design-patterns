package behavioral.chainOfResponsibility;

// Chain interface
public interface Handler {
    Handler setNext(Handler next);
    boolean handle(Request request);
}
