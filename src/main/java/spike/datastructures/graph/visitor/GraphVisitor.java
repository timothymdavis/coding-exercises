package spike.datastructures.graph.visitor;

import spike.datastructures.graph.Vertex;

/**
 * Objects that implement this interface can be supplied to the {@link spike.datastructures.graph.traverser.GraphTraverser}.
 *
 * @see SearchGraphVisitor
 * @see PrintVertexValuesGraphVisitor
 */
public interface GraphVisitor<V> {

    /**
     * @param vertex The vertex to visit.
     * @return true if the visitor has finished and doesn't need to visit any more vertices.
     */
    boolean visit(Vertex<V> vertex);

}
