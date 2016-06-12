package spike.graph;

import java.util.List;
import java.util.stream.Collectors;

public class UndirectedSimpleGraph<V> extends BaseSimpleGraph<V> {

    private Vertex<V> startVertex;

    public UndirectedSimpleGraph(Vertex<V> startVertex) {
        this.startVertex = startVertex;
    }

    private void add(Edge<V> edge) {
        if (!adjacent(edge.getSource(), edge.getTarget())) {
            edge.getSource().add(edge);
            edge.getTarget().add(edge);
        }
    }

    @Override
    public void add(Vertex<V> v1, Vertex<V> v2) {
        add(new Edge<>(v1, v2));
    }

    @Override
    public boolean adjacent(Vertex<V> v1, Vertex<V> v2) {
        return v1.getEdges()
                .parallelStream()
                .map(edge -> edge.getTarget() == v1 ? edge.getSource() : edge.getTarget())
                .anyMatch(vertex -> vertex == v2);
    }

    @Override
    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        return vertex.getEdges()
                .parallelStream()
                .map(edge -> edge.getTarget() == vertex ? edge.getSource() : edge.getTarget())
                .collect(Collectors.toList());
    }

    private void remove(Edge<V> edge) {
        edge.getSource().remove(edge);
        edge.getTarget().remove(edge);
    }

    @Override
    public void remove(Vertex<V> v1, Vertex<V> v2) {
        v1.getEdges()
                .parallelStream()
                .filter(edge -> edge.getSource() == v2 || edge.getTarget() == v2)
                .findFirst()
                .ifPresent(this::remove);
    }

    @Override
    public Vertex<V> getStartVertex() {
        return startVertex;
    }

    @Override
    public void setStartVertex(Vertex<V> startVertex) {
        this.startVertex = startVertex;
    }

}
