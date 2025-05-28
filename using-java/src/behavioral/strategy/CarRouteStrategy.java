package behavioral.strategy;

public class CarRouteStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Building fastest car route from " + start + " to " + end + " via highways and roads.");
    }
}
