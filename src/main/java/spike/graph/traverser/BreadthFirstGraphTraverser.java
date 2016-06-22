package spike.graph.traverser;

import lombok.NoArgsConstructor;
import spike.graph.Edge;
import spike.graph.Vertex;
import spike.graph.visitor.GraphVisitor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
public class BreadthFirstGraphTraverser<V> implements GraphTraverser<V> {

    private int maxDepth = -1;
    private boolean finished = false;
    private Map<Vertex, Boolean> visitedMap = new HashMap<>();

    public BreadthFirstGraphTraverser(int maxDepth) {
        if (maxDepth < 0) { throw new IllegalArgumentException(); }
        this.maxDepth = maxDepth;
    }

    @Override
    public void traverse(Vertex<V> vertex, GraphVisitor<V> visitor) {
        int currentDepth = 0;
        if (vertex != null) {
            Queue<Vertex<V>> queue = new LinkedList<>();
            queue.add(vertex);
            while (!queue.isEmpty() && !finished) {
                Vertex<V> currentNode = queue.poll();
                if (visitedMap.get(currentNode) == null) {
                    visitedMap.put(currentNode, true);
                    finished = visitor.visit(currentNode);
                    if (maxDepth == -1 || maxDepth > currentDepth++) {
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

}
