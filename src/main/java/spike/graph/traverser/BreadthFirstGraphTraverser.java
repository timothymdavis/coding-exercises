package spike.graph.traverser;

import spike.graph.Edge;
import spike.graph.Vertex;
import spike.graph.visitor.GraphVisitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class BreadthFirstGraphTraverser<V> implements GraphTraverser<V> {

    private boolean finished = false;
    private Map<Vertex, Boolean> visitedMap = new HashMap<>();

    @Override
    public void traverse(Vertex<V> vertex, GraphVisitor<V> visitor) {
        if (vertex != null) {
            Queue<Vertex<V>> queue = new LinkedList<>();
            queue.add(vertex);
            while (!queue.isEmpty() && !finished) {
                Vertex<V> currentNode = queue.poll();
                if (visitedMap.get(currentNode) == null) {
                    visitedMap.put(currentNode, true);
                    finished = visitor.visit(currentNode);
                    queue.addAll(currentNode.getEdges()
                            .stream()
                            .filter(edge -> edge != null)
                            .map(Edge::getTarget)
                            .collect(Collectors.toList()));
                }
            }
        }
    }

}
