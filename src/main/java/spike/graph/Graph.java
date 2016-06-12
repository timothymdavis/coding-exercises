package spike.graph;

import java.util.List;

public interface Graph<V> {

    void add(Vertex<V> v1, Vertex<V> v2);

    boolean adjacent(Vertex<V> v1, Vertex<V> v2);

    List<Vertex<V>> getNeighbors(Vertex<V> vertex);

    void remove(Vertex<V> v1, Vertex<V> v2);

    Vertex<V> getStartVertex();

    void setStartVertex(Vertex<V> startVertex);

}
