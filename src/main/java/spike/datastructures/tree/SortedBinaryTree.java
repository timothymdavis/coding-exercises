package spike.datastructures.tree;

import spike.datastructures.tree.traverser.BreadthFirstNodeTraverser;
import spike.datastructures.tree.traverser.SortedBinaryTreeNodeTraverser;
import spike.datastructures.tree.visitor.GetListNodeVisitor;
import spike.datastructures.tree.visitor.SearchNodeVisitor;
import spike.datastructures.tree.visitor.SortedDeleteNodeVisitor;
import spike.datastructures.tree.visitor.SortedInsertNodeVisitor;

import java.util.List;

public class SortedBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    private BinaryTreeNode<T> root = null;

    @Override
    public void delete(T value) {
        SortedDeleteNodeVisitor<T> visitor = new SortedDeleteNodeVisitor<>(value);
        SortedBinaryTreeNodeTraverser<T> traverser = new SortedBinaryTreeNodeTraverser<>(value);
        traverser.traverse(root, visitor);
    }

    @Override
    public void insert(T value) {
        if (root == null) {
            root = new BinaryTreeNode<>(value);
        }
        else {
            SortedBinaryTreeNodeTraverser<T> traverser = new SortedBinaryTreeNodeTraverser<>(value);
            SortedInsertNodeVisitor<T> visitor = new SortedInsertNodeVisitor<>(value);
            traverser.traverse(root, visitor);
        }
    }

    @Override
    public boolean contains(T searchCriteria) {
        SortedBinaryTreeNodeTraverser<T> traverser = new SortedBinaryTreeNodeTraverser<>(searchCriteria);
        SearchNodeVisitor<T> visitor = new SearchNodeVisitor<>(searchCriteria);
        traverser.traverse(root, visitor);
        return null != visitor.getResultNode();
    }

    @Override
    public List<T> getBreadthFirstList() {
        BreadthFirstNodeTraverser<T> traverser = new BreadthFirstNodeTraverser<>();
        GetListNodeVisitor<T> visitor = new GetListNodeVisitor<>();
        traverser.traverse(root, visitor);
        return visitor.getResult();
    }

}
