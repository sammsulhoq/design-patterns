package structural.proxy;

// Real Subject – Simulates Slow Service
public class RealDataFetcher implements DataFetcher {
    @Override
    public String fetchData(String query) {
        System.out.println("Fetching data from real source for: " + query);
        try {
            Thread.sleep(1000); // Simulate slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Result for '" + query + "'";
    }
}
