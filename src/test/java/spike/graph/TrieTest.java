package spike.graph;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testAdd() throws Exception {
        Trie trie = new Trie();
        trie.add("peanut");
        trie.add("pea");
        trie.add("nut");
        assertThat(trie.depthFirstVertexValues(), is(asList(null, 'p', 'e', 'a', 'n', 'u', 't', 'n', 'u', 't')));
    }

    @Test
    public void testContains() throws Exception {
        Trie trie = new Trie();
        trie.add("peanut");
        trie.add("pea");
        trie.add("nut");
        assertTrue(trie.contains("peanut"));
        assertTrue(trie.contains("pea"));
        assertTrue(trie.contains("nut"));
        assertFalse(trie.contains("peanuts"));
        assertFalse(trie.contains("peas"));
        assertFalse(trie.contains("nuts"));
    }
}