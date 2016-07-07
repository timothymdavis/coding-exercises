package spike.graph.traverser;

import lombok.NoArgsConstructor;
import spike.graph.Edge;
import spike.graph.Vertex;
import spike.graph.visitor.GraphVisitor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Only traverses one level of the graph. This can be useful we you only want to search the children of the current
 * vertex, but you still want to use the {@link GraphVisitor} interface.
 */
@NoArgsConstructor
public class OneLevelGraphTraverser<V> implements GraphTraverser<V> {

    private boolean firstLevelAdded = false;
    private boolean finished = false;
    private Map<Vertex, Boolean> visitedMap = new HashMap<>();

    @Override
    public void traverse(Vertex<V> vertex, GraphVisitor<V> visitor) {
        if (vertex != null) {
            Queue<Vertex<V>> queue = new LinkedList<>();
            queue.add(vertex);
            while (!queue.isEmpty() && !finished) {
                Vertex<V> currentNode = queue.poll();
                finished = visitor.visit(currentNode);
                if (!firstLevelAdded) {
                    queue.addAll(currentNode.getEdges()
                            .stream()
                            .filter(edge -> edge != null)
                            .map(Edge::getTarget)
                            .collect(Collectors.toList()));
                    firstLevelAdded = true;
                }
            }
        }
    }

}
