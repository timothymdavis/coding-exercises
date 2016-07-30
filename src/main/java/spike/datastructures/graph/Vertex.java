package spike.datastructures.graph;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString(of = {"value"})
public class Vertex<V> {

    private final List<Edge<V>> edges;
    private V value;

    public Vertex(V value) {
        this.value = value;
        edges = new ArrayList<>();
    }

    public void add(Edge<V> edge) {
        edges.add(edge);
    }

    public void remove(Edge<V> edge) {
        edges.remove(edge);
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public List<Edge<V>> getEdges() {
        return edges;
    }

}
