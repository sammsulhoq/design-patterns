package strategy;

public class WalkingRouteStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Building pedestrian route from " + start + " to " + end + " through parks and alleys.");
    }
}
