package behavioral.chainOfResponsibility;

public class AuthenticationHandler extends BaseHandler {
    @Override
    public boolean handle(Request request) {
        if ("admin".equals(request.username) && "secret".equals(request.password)) {
            request.isAdmin = true;
            System.out.println("User authenticated as admin.");
        } else if ("user".equals(request.username) && "pass".equals(request.password)) {
            request.isAdmin = false;
            System.out.println("User authenticated.");
        } else {
            System.out.println("Authentication failed for: " + request.username);
            return false;
        }
        return super.handle(request);
    }
}
