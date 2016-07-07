package spike.tree.traverser;

import spike.tree.BinaryTreeNode;
import spike.tree.visitor.NodeVisitor;

/**
 * Traverses a tree. Implementations should visit each node in the tree until the {@link NodeVisitor} returns true
 * or it runs out of nodes to visit.
 *
 * @see BreadthFirstNodeTraverser
 * @see DepthFirstInOrderNodeTraverser
 */
public interface NodeTraverser<T> {

    void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor);

}
