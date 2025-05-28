package behavioral.visitor;

// Visitor interface
public interface NodeVisitor {
    void visit(City city);
    void visit(Industry industry);
    void visit(SightseeingArea area);
}
