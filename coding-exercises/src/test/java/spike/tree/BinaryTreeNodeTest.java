package spike.tree;

import java.util.Arrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeNodeTest {

    private final BinaryTreeNode<Integer> smallTree;

    public BinaryTreeNodeTest() {
        smallTree = new BinaryTreeNode<Integer>(0);

        BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(smallTree, 1);
        BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(smallTree, 2);

        smallTree.setLeft(left);
        smallTree.setRight(right);

        left.setLeft(new BinaryTreeNode<Integer>(left, 3));
        left.setRight(new BinaryTreeNode<Integer>(left, 4));
        right.setLeft(new BinaryTreeNode<Integer>(right, 5));
        right.setRight(new BinaryTreeNode<Integer>(right, 6));
    }

    @Test
    public void testBreadthFirstNodeTraverse() throws Exception {
        GetListNodeVisitor<Integer> visitor = new GetListNodeVisitor<Integer>();
        smallTree.traverse(new BreadthFirstNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResult(), is(Arrays.asList(0, 1, 2, 3, 4, 5 , 6)));
    }

    @Test
    public void testDepthFirstInOrderNodeSearch() throws Exception {
        SearchNodeVisitor<Integer> visitor = new SearchNodeVisitor<Integer>(4);
        smallTree.traverse(new DepthFirstInOrderNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResultNode(), is(smallTree.getLeft().getRight()));
    }

    @Test
    public void testDepthFirstInOrderNodeTraverse() throws Exception {
        GetListNodeVisitor<Integer> visitor = new GetListNodeVisitor<Integer>();
        smallTree.traverse(new DepthFirstInOrderNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResult(), is(Arrays.asList(3, 1, 4, 0, 5, 2, 6)));
    }

    @Test
    public void testDepthFirstPostOrderNodeSearch() throws Exception {
        SearchNodeVisitor<Integer> visitor = new SearchNodeVisitor<Integer>(4);
        smallTree.traverse(new DepthFirstPostOrderNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResultNode(), is(smallTree.getLeft().getRight()));
    }

    @Test
    public void testDepthFirstPostOrderNodeTraverse() throws Exception {
        GetListNodeVisitor<Integer> visitor = new GetListNodeVisitor<Integer>();
        smallTree.traverse(new DepthFirstPostOrderNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResult(), is(Arrays.asList(3, 4, 1, 5, 6, 2, 0)));
    }

    @Test
    public void testDepthFirstPreOrderNodeSearch() throws Exception {
        SearchNodeVisitor<Integer> visitor = new SearchNodeVisitor<Integer>(4);
        smallTree.traverse(new DepthFirstPreOrderNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResultNode(), is(smallTree.getLeft().getRight()));
    }

    @Test
    public void testDepthFirstPreOrderNodeTraverse() throws Exception {
        GetListNodeVisitor<Integer> visitor = new GetListNodeVisitor<Integer>();
        smallTree.traverse(new DepthFirstPreOrderNodeTraverser<Integer>(), visitor);
        assertThat(visitor.getResult(), is(Arrays.asList(0, 1, 3, 4, 2, 5, 6)));
    }

}