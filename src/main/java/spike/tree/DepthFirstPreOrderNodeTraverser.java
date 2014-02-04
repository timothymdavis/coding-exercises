package spike.tree;

public class DepthFirstPreOrderNodeTraverser<T> implements NodeTraverser<T> {

    private boolean finished = false;

    @Override
    public void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor) {
        if (node != null && !finished) {
            finished = visitor.visit(node);
            traverse(node.getLeft(), visitor);
            traverse(node.getRight(), visitor);
        }
    }

}
