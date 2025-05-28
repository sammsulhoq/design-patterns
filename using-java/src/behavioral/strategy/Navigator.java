package behavioral.strategy;

public class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy routeStrategy) {
        this.strategy = routeStrategy;
    }

    public void buildRoute(String start, String end) {
        if (strategy == null) {
            System.out.println("No behavioral.strategy selected. Please choose a travel method.");
            return;
        }

        strategy.buildRoute(start, end);
    }
}
