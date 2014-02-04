package spike.tree;

public class SortedBinaryTreeNodeTraverser<T extends Comparable<T>> implements NodeTraverser<T> {

    private boolean finished = false;
    private T searchCriteria;

    public SortedBinaryTreeNodeTraverser(T searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor) {
        if (node != null && !finished) {
            if (searchCriteria.compareTo(node.getValue()) < 0) {
                BinaryTreeNode<T> left = node.getLeft();
                if (left == null) {
                    finished = visitor.visit(node);
                }
                else {
                    traverse(left, visitor);
                }
            }
            else if (searchCriteria.compareTo(node.getValue()) > 0) {
                BinaryTreeNode<T> right = node.getRight();
                if (right == null) {
                    finished = visitor.visit(node);
                }
                else {
                    traverse(right, visitor);
                }
            }
            else {
                finished = visitor.visit(node);
            }
        }
    }

}
