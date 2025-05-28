package visitor;

import java.util.List;

// Client that traverses the graph
public class Graph {
    private final List<GraphNode> nodes;

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void export(NodeVisitor visitor) {
        for (GraphNode node : nodes) {
            node.accept(visitor);
        }
    }
}