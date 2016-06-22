package spike.graph.visitor;

import spike.graph.Vertex;

public class SearchGraphVisitor<V>
        implements GraphVisitor<V> {

    private final V searchCriteria;
    private Vertex<V> resultVertex;

    public SearchGraphVisitor(V searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public boolean visit(Vertex<V> vertex) {
        if (vertex != null && vertex.getValue() != null && vertex.getValue().equals(searchCriteria)) {
            resultVertex = vertex;
            return true;
        } else {
            return false;
        }
    }

    public Vertex<V> getResultVertex() {
        return resultVertex;
    }

}
