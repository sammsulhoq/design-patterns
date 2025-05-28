package behavioral.chainOfResponsibility;

import java.util.*;

public class CacheHandler extends BaseHandler {
    private static final Set<String> cache = new HashSet<>(List.of("user:pass:/getOrders"));

    @Override
    public boolean handle(Request request) {
        String cacheKey = request.username + ":" + request.password + ":" + request.payload;
        if (cache.contains(cacheKey)) {
            System.out.println("Serving from cache for request: " + request.payload);
            return false;
        }
        System.out.println("No cache found. Proceeding...");
        return super.handle(request);
    }
}

