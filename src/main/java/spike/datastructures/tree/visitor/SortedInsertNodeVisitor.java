package spike.datastructures.tree.visitor;

import spike.datastructures.tree.BinaryTreeNode;

public class SortedInsertNodeVisitor<T extends Comparable<T>> implements NodeVisitor<T> {

    private final T value;

    public SortedInsertNodeVisitor(T value) {
        this.value = value;
    }

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        if (node != null) {
            BinaryTreeNode<T> newNode = new BinaryTreeNode<>(node, value);
            if (value.compareTo(node.getValue()) < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(newNode);
                    return true;
                }
                else {
                    return false;
                }
            }
            else if (value.compareTo(node.getValue()) > 0) {
                if (node.getRight() == null) {
                    node.setRight(newNode);
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                // Don't insert duplicates; just ignore it.
                return true;
            }
        }
        else {
            return false;
        }
    }

}
