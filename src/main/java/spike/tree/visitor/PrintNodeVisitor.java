package spike.tree.visitor;

import spike.tree.BinaryTreeNode;

public class PrintNodeVisitor<T> implements NodeVisitor<T> {

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        System.out.println(node == null ? null : node.getValue());
        return false;
    }

}
