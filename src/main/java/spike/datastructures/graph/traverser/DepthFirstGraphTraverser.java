package spike.datastructures.graph.traverser;

import spike.datastructures.graph.Edge;
import spike.datastructures.graph.Vertex;
import spike.datastructures.graph.visitor.GraphVisitor;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstGraphTraverser<T> implements GraphTraverser<T> {

    private boolean finished = false;
    private final Map<Vertex, Boolean> visitedMap = new HashMap<>();

    @Override
    public void traverse(Vertex<T> vertex, GraphVisitor<T> visitor) {
        if (vertex != null && !finished) {
            if (visitedMap.get(vertex) == null) {
                visitedMap.put(vertex, true);
                finished = visitor.visit(vertex);
                for (Edge<T> edge : vertex.getEdges()) {
                    traverse(edge.getTarget(), visitor);
                }
            }
        }
    }

}
