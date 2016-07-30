package spike.datastructures.graph.traverser;

import spike.datastructures.graph.Vertex;
import spike.datastructures.graph.visitor.GraphVisitor;

/**
 * Traverses a graph. Implementations should visit each vertex in the graph until the {@link GraphVisitor} returns true
 * or it runs out of vertices to visit.
 *
 * @see BreadthFirstGraphTraverser
 * @see DepthFirstGraphTraverser
 */
public interface GraphTraverser<V> {

    void traverse(Vertex<V> vertex, GraphVisitor<V> visitor);

}
