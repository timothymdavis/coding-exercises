package spike.graph.visitor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import spike.graph.Vertex;

@Getter
@RequiredArgsConstructor
public class SearchGraphVisitor<V> implements GraphVisitor<V> {

    private final V searchCriteria;
    private Vertex<V> resultVertex;

    @Override
    public boolean visit(Vertex<V> vertex) {
        if (vertex != null && vertex.getValue() != null && vertex.getValue().equals(searchCriteria)) {
            resultVertex = vertex;
            return true;
        } else {
            return false;
        }
    }

}
