package behavioral.strategy;

public class CyclingRouteStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Building cycling route from " + start + " to " + end + " on bike-friendly lanes.");
    }
}
