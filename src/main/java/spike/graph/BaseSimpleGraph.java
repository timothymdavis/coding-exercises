package spike.graph;

import spike.graph.traverser.BreadthFirstGraphTraverser;
import spike.graph.traverser.DepthFirstGraphTraverser;
import spike.graph.traverser.GraphTraverser;
import spike.graph.visitor.GetVertexValuesGraphVisitor;
import spike.graph.visitor.GetVerticesGraphVisitor;
import spike.graph.visitor.GraphVisitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class BaseSimpleGraph<V> implements Graph<V> {

    public List<V> breadthFirstVertexValues() {
        GetVertexValuesGraphVisitor<V> visitor = new GetVertexValuesGraphVisitor<>();
        breadthFirstTraverse(visitor);
        return visitor.getResult();
    }

    public void breadthFirstTraverse(GraphVisitor<V> visitor) {
        traverse(new BreadthFirstGraphTraverser<>(), visitor);
    }

    public List<V> depthFirstVertexValues() {
        GetVertexValuesGraphVisitor<V> visitor = new GetVertexValuesGraphVisitor<>();
        depthFirstTraverse(visitor);
        return visitor.getResult();
    }

    public void depthFirstTraverse(GraphVisitor<V> visitor) {
        traverse(new DepthFirstGraphTraverser<>(), visitor);
    }

    public Map<Vertex<V>, List<Vertex<V>>> getAdjacencyList() {
        Map<Vertex<V>, List<Vertex<V>>> result = new HashMap<>();
        List<Vertex<V>> vertices = getVertices();
        for (Vertex<V> vertex : vertices) {
            result.put(vertex, getNeighbors(vertex));
        }
        return result;
    }

    public int[][] getAdjacencyMatrix() {
        List<Vertex<V>> vertices = getVertices();
        int[][] result = new int[vertices.size()][vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                if (adjacent(vertices.get(i), vertices.get(j))) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }

    private List<Vertex<V>> getVertices() {
        GetVerticesGraphVisitor<V> visitor = new GetVerticesGraphVisitor<>();
        breadthFirstTraverse(visitor);
        return visitor.getResult();
    }

    public void traverse(GraphTraverser<V> traverser, GraphVisitor<V> visitor) {
        Objects.requireNonNull(getStartVertex());
        traverser.traverse(getStartVertex(), visitor);
    }

}
