package spike.graph.traverser;

import spike.graph.Vertex;
import spike.graph.visitor.GraphVisitor;

public interface GraphTraverser<V> {

    void traverse(Vertex<V> vertex, GraphVisitor<V> visitor);

}
