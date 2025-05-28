package chainOfResponsibility;

public class AuthorizationHandler extends BaseHandler {
    @Override
    public boolean handle(Request request) {
        if (request.isAdmin) {
            System.out.println("Admin has full access.");
            return super.handle(request);
        } else {
            System.out.println("Standard user access granted.");
            return super.handle(request);
        }
    }
}
