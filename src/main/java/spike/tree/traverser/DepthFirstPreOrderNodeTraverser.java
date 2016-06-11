package spike.tree.traverser;

import spike.tree.BinaryTreeNode;
import spike.tree.visitor.NodeVisitor;

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
