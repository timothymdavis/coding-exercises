package spike.tree;

public class DepthFirstInOrderNodeTraverser<T> implements NodeTraverser<T> {

    private boolean finished = false;

    @Override
    public void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor) {
        if (node != null && !finished) {
            traverse(node.getLeft(), visitor);
            finished = visitor.visit(node);
            traverse(node.getRight(), visitor);
        }
    }

}
