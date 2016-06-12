package spike.graph;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GraphTest {

    @Test
    public void testUndirectedSimpleGraph() {
        Vertex<String> vA = new Vertex<>("A");
        Vertex<String> vB = new Vertex<>("B");
        Vertex<String> vC = new Vertex<>("C");
        Vertex<String> vD = new Vertex<>("D");

        UndirectedSimpleGraph<String> graph = new UndirectedSimpleGraph<>(vA);

        assertThat(vA.getEdges().size(), is(0));
        graph.add(vA, vB);
        assertThat(vA.getEdges().size(), is(1));
        graph.add(vB, vA);
        assertThat(vA.getEdges().size(), is(1));
        graph.remove(vA, vB);
        assertThat(vA.getEdges().size(), is(0));

        graph.add(vA, vB);
        graph.add(vB, vC);
        graph.add(vC, vA);
        graph.add(vB, vD);

        assertThat(graph.adjacent(vA, vB), is(true));
        assertThat(graph.adjacent(vB, vC), is(true));
        assertThat(graph.adjacent(vC, vA), is(true));
        assertThat(graph.adjacent(vB, vD), is(true));
        assertThat(graph.adjacent(vC, vD), is(false));
        assertThat(graph.adjacent(vA, vA), is(false));

        assertThat(graph.breadthFirstVertexValues(), is(asList("A", "B", "C", "D")));
        assertThat(graph.depthFirstVertexValues(), is(asList("A", "B", "C", "D")));

        assertThat(graph.getAdjacencyList().get(vA), is(asList(vB, vC)));

        assertThat(graph.getAdjacencyMatrix(),
                is(new int[][] {
                        {0, 1, 1, 0},
                        {1, 0, 1, 1},
                        {1, 1, 0, 0},
                        {0, 1, 0, 0},
                }));
    }

}