package behavioral.strategy;

public class TouristAttractionRouteStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Building tourist route from " + start + " to " + end + " through major attractions.");
    }
}
