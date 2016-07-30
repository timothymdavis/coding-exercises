package spike.datastructures.graph.traverser;

import lombok.NoArgsConstructor;
import spike.datastructures.graph.Edge;
import spike.datastructures.graph.Vertex;
import spike.datastructures.graph.visitor.GraphVisitor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
public class BreadthFirstGraphTraverser<V> implements GraphTraverser<V> {

    private boolean finished = false;
    private final Map<Vertex, Boolean> visitedMap = new HashMap<>();

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
