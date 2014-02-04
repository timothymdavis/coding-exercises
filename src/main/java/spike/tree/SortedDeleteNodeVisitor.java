package spike.tree;

public class SortedDeleteNodeVisitor<T extends Comparable<T>> implements NodeVisitor<T> {

    private final T searchCriteria;

    public SortedDeleteNodeVisitor(T searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        if (node != null) {
            if (searchCriteria.compareTo(node.getValue()) < 0) {
                // Nothing to delete.
                return true;
            }
            else if (searchCriteria.compareTo(node.getValue()) > 0) {
                // Nothing to delete.
                return true;
            }
            else {
                BinaryTreeNode<T> parent = node.getParent();
                BinaryTreeNode<T> left = node.getLeft();
                BinaryTreeNode<T> right = node.getRight();
                if (parent == null) {
                    throw new IllegalStateException("Can't delete the root node from here!");
                }
                if (node == parent.getLeft()) {
                    if (right != null) {
                        right.setLeft(node.getLeft());
                        parent.setLeft(right);
                    }
                    else {
                        parent.setLeft(null);
                    }
                }
                else if (node == parent.getRight()) {
                    if (left != null) {
                        left.setRight(node.getRight());
                        parent.setRight(left);
                    }
                    else {
                        parent.setRight(null);
                    }
                }
                return true;
            }
        }
        else {
            return false;
        }
    }

}
