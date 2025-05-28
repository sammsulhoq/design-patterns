package behavioral.visitor;

public class Industry implements GraphNode {
    private final String sector;

    public Industry(String sector) {
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}