package spike.tree.visitor;

import spike.tree.BinaryTreeNode;

/**
 * Objects that implement this interface can be supplied to the {@link spike.tree.traverser.NodeTraverser}.
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
