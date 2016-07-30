package spike.datastructures.graph.visitor;

import spike.datastructures.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class GetVertexValuesGraphVisitor<V> implements GraphVisitor<V> {

    private final List<V> result = new ArrayList<>();

    @Override
    public boolean visit(Vertex<V> vertex) {
        result.add(vertex.getValue());
        return false;
    }

    public List<V> getResult() {
        return result;
    }

}
