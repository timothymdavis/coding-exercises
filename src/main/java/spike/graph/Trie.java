package spike.graph;

import spike.graph.traverser.BreadthFirstGraphTraverser;
import spike.graph.visitor.SearchGraphVisitor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Trie extends BaseSimpleGraph<Character> {

    private Vertex<Character> root;

    public Trie() {
        this.root = new Vertex<>(null);
    }

    private void add(Edge<Character> edge) {
        if (!adjacent(edge.getSource(), edge.getTarget())) {
            edge.getSource().add(edge);
        }
    }

    @Override
    public void add(Vertex<Character> v1, Vertex<Character> v2) {
        add(new Edge<>(v1, v2));
    }

    public void add(String value) {
        add(toCharArray(value));
    }

    public void add(Character[] values) {
        Vertex<Character> current = getStartVertex();
        for (Character value : values) {
            Optional<Vertex<Character>> next = findNext(value, current);
            if (next.isPresent()) {
                current = next.get();
            } else {
                Vertex<Character> target = new Vertex<>(value);
                add(current, target);
                current = target;
            }
        }
    }

    public boolean contains(String value) {
        return contains(toCharArray(value));
    }

    public boolean contains(Character[] values) {
        Vertex<Character> current = getStartVertex();
        for (Character value : values) {
            Optional<Vertex<Character>> next = findNext(value, current);
            if (next.isPresent()) {
                current = next.get();
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean adjacent(Vertex<Character> v1, Vertex<Character> v2) {
        return v1.getEdges()
                .parallelStream()
                .map(Edge::getTarget)
                .anyMatch(vertex -> vertex == v2);
    }

    @Override
    public List<Vertex<Character>> getNeighbors(Vertex<Character> vertex) {
        return vertex.getEdges()
                .parallelStream()
                .map(Edge::getTarget)
                .collect(Collectors.toList());
    }

    private void remove(Edge<Character> edge) {
        edge.getSource().remove(edge);
    }

    @Override
    public void remove(Vertex<Character> v1, Vertex<Character> v2) {
        v1.getEdges()
                .parallelStream()
                .filter(edge -> edge.getTarget() == v2)
                .findFirst()
                .ifPresent(this::remove);
    }

    @Override
    public Vertex<Character> getStartVertex() {
        return root;
    }

    @Override
    public void setStartVertex(Vertex<Character> startVertex) {
        this.root = startVertex;
    }

    private Optional<Vertex<Character>> findNext(Character value, Vertex<Character> current) {
        final int maxDepth = 1;
        SearchGraphVisitor<Character> visitor = new SearchGraphVisitor<>(value);
        traverseFrom(current, new BreadthFirstGraphTraverser<>(maxDepth), visitor);
        if (visitor.getResultVertex() != null) {
            return Optional.ofNullable(visitor.getResultVertex());
        }
        return Optional.empty();
    }

    private Character[] toCharArray(String string) {
        return string.chars().mapToObj(i -> (char) i).toArray(Character[]::new);
    }

}
