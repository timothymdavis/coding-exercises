package spike.tree;

import java.util.List;

public class SortedBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private BinaryTreeNode<T> root = null;

    @Override
    public void delete(T value) {
        SortedDeleteNodeVisitor<T> visitor = new SortedDeleteNodeVisitor<T>(value);
        SortedBinaryTreeNodeTraverser<T> traverser = new SortedBinaryTreeNodeTraverser<T>(value);
        traverser.traverse(root, visitor);
    }

    @Override
    public void insert(T value) {
        if (root == null) {
            root = new BinaryTreeNode<T>(value);
        }
        else {
            SortedBinaryTreeNodeTraverser<T> traverser = new SortedBinaryTreeNodeTraverser<T>(value);
            SortedInsertNodeVisitor<T> visitor = new SortedInsertNodeVisitor<T>(value);
            traverser.traverse(root, visitor);
        }
    }

    @Override
    public boolean contains(T searchCriteria) {
        SortedBinaryTreeNodeTraverser<T> traverser = new SortedBinaryTreeNodeTraverser<T>(searchCriteria);
        SearchNodeVisitor<T> visitor = new SearchNodeVisitor<T>(searchCriteria);
        traverser.traverse(root, visitor);
        return null != visitor.getResultNode();
    }

    @Override
    public List<T> getBreadthFirstList() {
        BreadthFirstNodeTraverser<T> traverser = new BreadthFirstNodeTraverser<T>();
        GetListNodeVisitor<T> visitor = new GetListNodeVisitor<T>();
        traverser.traverse(root, visitor);
        return visitor.getResult();
    }

}
