package visitor;

// Concrete visitor
public class XMLExportVisitor implements NodeVisitor {
    @Override
    public void visit(City city) {
        System.out.println("<city><name>" + city.getName() + "</name></city>");
    }

    @Override
    public void visit(Industry industry) {
        System.out.println("<industry><sector>" + industry.getSector() + "</sector></industry>");
    }

    @Override
    public void visit(SightseeingArea area) {
        System.out.println("<sightseeing><landmark>" + area.getLandmark() + "</landmark></sightseeing>");
    }
}