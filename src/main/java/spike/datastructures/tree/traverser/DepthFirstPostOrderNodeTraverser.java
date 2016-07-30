package spike.datastructures.tree.traverser;

import spike.datastructures.tree.BinaryTreeNode;
import spike.datastructures.tree.visitor.NodeVisitor;

public class DepthFirstPostOrderNodeTraverser<T> implements NodeTraverser<T> {

    private boolean finished = false;

    @Override
    public void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor) {
        if (node != null && !finished) {
            traverse(node.getLeft(), visitor);
            traverse(node.getRight(), visitor);
            finished = visitor.visit(node);
        }
    }

}
