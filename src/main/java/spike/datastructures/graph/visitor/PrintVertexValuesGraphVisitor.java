package spike.datastructures.graph.visitor;

import spike.datastructures.graph.Vertex;

public class PrintVertexValuesGraphVisitor<V> implements GraphVisitor<V> {

    @Override
    public boolean visit(Vertex<V> vertex) {
        System.out.println(vertex == null ? null : vertex.getValue());
        return false;
    }

}
