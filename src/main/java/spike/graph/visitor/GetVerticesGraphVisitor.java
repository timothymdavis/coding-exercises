package spike.graph.visitor;

import spike.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class GetVerticesGraphVisitor<V> implements GraphVisitor<V> {

    private final List<Vertex<V>> result = new ArrayList<>();

    @Override
    public boolean visit(Vertex<V> vertex) {
        result.add(vertex);
        return false;
    }

    public List<Vertex<V>> getResult() {
        return result;
    }

}
