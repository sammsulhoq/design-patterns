package chainOfResponsibility;

// Abstract Base Class
public abstract class BaseHandler implements Handler{
    private Handler next;

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public boolean handle(Request request) {
        if (next != null) {
            return next.handle(request);
        }

        return true;
    }
}
