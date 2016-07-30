package spike.datastructures.tree.visitor;

import spike.datastructures.tree.BinaryTreeNode;

/**
 * Objects that implement this interface can be supplied to the {@link spike.datastructures.tree.traverser.NodeTraverser}.
 *
 * @see SearchNodeVisitor
 * @see PrintNodeVisitor
 */
public interface NodeVisitor<T> {

    /**
     * @param node The node to visit.
     * @return true if the visitor has finished and doesn't need to visit any more nodes.
     */
    boolean visit(BinaryTreeNode<T> node);

}
