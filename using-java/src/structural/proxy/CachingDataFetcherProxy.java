package structural.proxy;

import java.util.*;

// Proxy with Caching
public class CachingDataFetcherProxy implements DataFetcher {
    private final RealDataFetcher realFetcher = new RealDataFetcher();
    private final Map<String, String> cache = new HashMap<>();

    @Override
    public String fetchData(String query) {
        if (cache.containsKey(query)) {
            System.out.println("Returning cached result for: " + query);
            return cache.get(query);
        }

        String result = realFetcher.fetchData(query);
        cache.put(query, result);
        return result;
    }
}