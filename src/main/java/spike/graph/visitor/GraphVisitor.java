package spike.graph.visitor;

import spike.graph.Vertex;

public interface GraphVisitor<V> {

    boolean visit(Vertex<V> node);

}
