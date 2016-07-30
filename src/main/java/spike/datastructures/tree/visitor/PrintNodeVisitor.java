package spike.datastructures.tree.visitor;

import spike.datastructures.tree.BinaryTreeNode;

public class PrintNodeVisitor<T> implements NodeVisitor<T> {

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        System.out.println(node == null ? null : node.getValue());
        return false;
    }

}
