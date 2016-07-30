package spike.problems.hackerrank;

import spike.datastructures.graph.Edge;
import spike.datastructures.graph.Vertex;

import java.util.*;
import java.util.stream.Collectors;

/**
 * See https://www.hackerrank.com/challenges/the-quickest-way-up and src/main/resources/hackerrank/the-quickest-way-up-English.pdf
 */
public class TheQuickestWayUp {

    private final static int START = 1;
    private final static int END = 100;

    public static void solve(Scanner s) {
        Map<Integer, Integer> pipeMap = new HashMap<>();
        pipeMap.putAll(getIntegerMap(s));
        pipeMap.putAll(getIntegerMap(s));

        Map<Integer, Vertex<Integer>> vertexMap = buildVertexMap(END);
        Vertex<Integer> start = buildGraph(vertexMap, pipeMap);

        BreadthFirstGraphTraverser<Integer> traverser = new BreadthFirstGraphTraverser<>();
        ShortestPathVisitor<Integer> visitor = new ShortestPathVisitor<>(e -> e.getTarget().getValue() == END);
        traverser.traverse(start, visitor);

        System.out.println(visitor.getShortestPathDepth());
    }

    public static Map<Integer, Vertex<Integer>> buildVertexMap(int vertexCount) {
        HashMap<Integer, Vertex<Integer>> map = new HashMap<>();
        for (int i = START; i <= vertexCount; i++) {
            Vertex<Integer> vertex = new Vertex<>(i);
            map.put(i, vertex);
        }
        return map;
    }

    public static Vertex<Integer> buildGraph(Map<Integer, Vertex<Integer>> vertexMap,
                                             Map<Integer, Integer> pipeMap) {
        Vertex<Integer> start = vertexMap.get(START);
        for (int i = START; i <= vertexMap.size(); i++) {
            Vertex<Integer> v = vertexMap.get(i);
            if (pipeMap.containsKey(i)) {
                addVertexIfPossible(vertexMap, pipeMap, v, pipeMap.get(i));
            }
            else {
                addVertexIfPossible(vertexMap, pipeMap, v, i + 1);
                addVertexIfPossible(vertexMap, pipeMap, v, i + 2);
                addVertexIfPossible(vertexMap, pipeMap, v, i + 3);
                addVertexIfPossible(vertexMap, pipeMap, v, i + 4);
                addVertexIfPossible(vertexMap, pipeMap, v, i + 5);
                addVertexIfPossible(vertexMap, pipeMap, v, i + 6);
            }
        }
        return start;
    }

    private static void addVertexIfPossible(Map<Integer, Vertex<Integer>> vertexMap,
                                            Map<Integer, Integer> pipeMap,
                                            Vertex<Integer> v,
                                            int i) {
        Integer targetIndex = pipeMap.containsKey(i) ? pipeMap.get(i) : i;
        if (targetIndex <= vertexMap.size()) {
            v.add(new Edge<>(v, vertexMap.get(targetIndex)));
        }
    }

    public static Map<Integer, Integer> getIntegerMap(Scanner s) {
        Map<Integer, Integer> result = new HashMap<>();
        int snakeCount = s.nextInt();
        for (int i = 0; i < snakeCount; i++) {
            result.put(s.nextInt(), s.nextInt());
        }
        return result;
    }


    /*
     * Graph related classes.
     */

    public interface GraphTraverser<V> {
        void traverse(Vertex<V> vertex, GraphVisitor<V> visitor);
    }

    public interface GraphVisitor<V> {
        boolean visit(Edge<V> edge);
    }

    public static class BreadthFirstGraphTraverser<V> implements GraphTraverser<V> {

        private boolean finished = false;
        private boolean checkVisited = true;
        private Map<Edge, Boolean> visitedMap = new HashMap<>();

        @Override
        public void traverse(Vertex<V> vertex, GraphVisitor<V> visitor) {
            if (vertex != null) {
                Queue<Edge<V>> queue = new LinkedList<>();
                queue.add(new Edge<>(null, vertex));
                while (!queue.isEmpty() && !finished) {
                    Edge<V> current = queue.poll();
                    if (!checkVisited || visitedMap.get(current) == null) {
                        Vertex<V> currentVertex = current.getTarget();
                        finished = visitor.visit(current);
                        visitedMap.put(current, true);
                        List<Edge<V>> collect = currentVertex.getEdges()
                                .stream()
                                .filter(edge -> edge != null)
                                .collect(Collectors.toList());
                        queue.addAll(collect);
                    }
                }
            }
        }
    }

    public static class ShortestPathVisitor<V> implements GraphVisitor<V> {

        private final GraphVisitor<V> delegate;
        private Map<Vertex<V>, Integer> shortestPathMap = new HashMap<>();
        private Edge<V> lastVisited = null;
        private boolean finished = false;

        public ShortestPathVisitor(GraphVisitor<V> delegate) {
            this.delegate = delegate;
        }

        @Override
        public boolean visit(Edge<V> edge) {
            if (!shortestPathMap.containsKey(edge.getTarget())) {
                int depth = 0;
                Vertex<V> source = edge.getSource();
                if (source != null && shortestPathMap.get(source) != null) {
                    depth = shortestPathMap.get(source) + 1;
                }
                shortestPathMap.put(edge.getTarget(), depth);
            }
            lastVisited = edge;
            finished = delegate.visit(edge);
            return finished;
        }

        public int getShortestPathDepth() {
            return lastVisited != null && finished ? shortestPathMap.get(lastVisited.getTarget()) : -1;
        }

    }

}
