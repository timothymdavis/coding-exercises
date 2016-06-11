package spike.tree.traverser;

import spike.tree.BinaryTreeNode;
import spike.tree.visitor.NodeVisitor;

public interface NodeTraverser<T> {

    void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor);

}
