package spike.graph.traverser;

import spike.graph.Edge;
import spike.graph.Vertex;
import spike.graph.visitor.GraphVisitor;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstGraphTraverser<T> implements GraphTraverser<T> {

    private boolean finished = false;
    private Map<Vertex, Boolean> visitedMap = new HashMap<>();

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
