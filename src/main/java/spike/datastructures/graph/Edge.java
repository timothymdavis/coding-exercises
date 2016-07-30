package spike.datastructures.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Edge<V> {

    private int weight;
    private Vertex<V> source;
    private Vertex<V> target;
    private EdgeDirection directionType;

    public Edge(Vertex<V> source, Vertex<V> target) {
        this.source = source;
        this.target = target;
    }

}
