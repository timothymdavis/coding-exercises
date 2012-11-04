package spike.tree;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortedBinaryTreeTest {

    private SortedBinaryTree<Integer> smallTree;

    public SortedBinaryTreeTest() {
        smallTree = new SortedBinaryTree<Integer>();
        smallTree.insert(6);
        smallTree.insert(9);
        smallTree.insert(4);
        smallTree.insert(1);
        smallTree.insert(3);
    }

    @Test
    public void testContains() throws Exception {
        assertThat(smallTree.contains(6), is(true));
        assertThat(smallTree.contains(9), is(true));
        assertThat(smallTree.contains(4), is(true));
        assertThat(smallTree.contains(1), is(true));
        assertThat(smallTree.contains(3), is(true));
    }

    @Test
    public void testDelete() throws Exception {
        smallTree.delete(1);
        assertThat(smallTree.getBreadthFirstList(), is(asList(6, 4, 9, 3)));
    }

    @Test
    public void testInsert() throws Exception {
        assertThat(smallTree.getBreadthFirstList(), is(asList(6, 4, 9, 1, 3)));
    }

}
