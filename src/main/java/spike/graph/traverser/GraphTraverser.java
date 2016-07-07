package spike.graph.traverser;

import spike.graph.Vertex;
import spike.graph.visitor.GraphVisitor;

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
