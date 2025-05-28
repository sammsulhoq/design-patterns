package visitor;

public class SightseeingArea implements GraphNode {
    private final String landmark;

    public SightseeingArea(String landmark) {
        this.landmark = landmark;
    }

    public String getLandmark() {
        return landmark;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}