package spike.graph;

import java.util.List;

/**
 * Implements all the things that folks on the internet say that a graph should.
 *
 * @param <V> The value type for the {@link Vertex} values.
 */
public interface Graph<V> {

    /**
     * Adds an edge to the graph. Implicitly creates the {@link Edge}.
     */
    void add(Vertex<V> v1, Vertex<V> v2);

    /**
     * Determines if two vertices are adjacent.
     */
    boolean adjacent(Vertex<V> v1, Vertex<V> v2);

    /**
     * Gets all of the adjacent vertices.
     */
    List<Vertex<V>> getNeighbors(Vertex<V> vertex);

    /**
     * Removes an edge from the graph. Does nothing if the edge doesn't exist.
     */
    void remove(Vertex<V> v1, Vertex<V> v2);

    /**
     * Not sure if I like this, but it is useful to know where to start in the graph.
     */
    Vertex<V> getStartVertex();

    /**
     * @see #getStartVertex()
     */
    void setStartVertex(Vertex<V> startVertex);

}
