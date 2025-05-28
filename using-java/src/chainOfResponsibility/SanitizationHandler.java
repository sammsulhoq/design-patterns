package chainOfResponsibility;

public class SanitizationHandler extends BaseHandler {
    @Override
    public boolean handle(Request request) {
        if (request.payload.contains("<script>")) {
            System.out.println("Malicious input detected. Request blocked.");
            return false;
        }
        System.out.println("Input sanitized.");
        return super.handle(request);
    }
}

