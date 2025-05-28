package chainOfResponsibility;

import java.util.*;

public class BruteForceProtectionHandler extends BaseHandler{
    private Map<String, Integer> ipFailures = new HashMap<>();

    @Override
    public boolean handle(Request request) {
        int fails = ipFailures.getOrDefault(request.ip, 0);
        if (fails >= 3) {
            System.out.println("Request blocked due to brute-force attempt from IP: " + request.ip);
            return false;
        }

        return super.handle(request);
    }

    public void registerFailure(String ip) {
        ipFailures.put(ip, ipFailures.getOrDefault(ip, 0) + 1);
    }

    public void resetFailures(String ip) {
        ipFailures.remove(ip);
    }
}
