package strategy;

public class PublicTransportRouteStrategy implements RouteStrategy{
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("Building public transport route from " + start + " to " + end + " using buses and metro.");
    }
}
