package behavioral.visitor;

// Element Interface
public interface GraphNode {
    void accept(NodeVisitor visitor);
}
