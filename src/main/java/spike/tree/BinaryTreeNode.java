package spike.tree;

import spike.tree.traverser.NodeTraverser;
import spike.tree.visitor.NodeVisitor;

public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> right;
    private final T value;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(BinaryTreeNode<T> parent, T value) {
        this.parent = parent;
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public void traverse(NodeTraverser<T> traverser, NodeVisitor<T> visitor) {
        traverser.traverse(this, visitor);
    }
}
