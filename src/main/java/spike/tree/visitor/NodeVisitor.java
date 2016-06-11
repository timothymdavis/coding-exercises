package spike.tree.visitor;

import spike.tree.BinaryTreeNode;

public interface NodeVisitor<T> {

    boolean visit(BinaryTreeNode<T> node);

}
