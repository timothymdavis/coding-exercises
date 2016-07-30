package spike.datastructures.tree.visitor;

import spike.datastructures.tree.BinaryTreeNode;

public class SearchNodeVisitor<T> implements NodeVisitor<T> {

    private final T searchCriteria;
    private BinaryTreeNode<T> resultNode;

    public SearchNodeVisitor(T searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        if (node != null && node.getValue() != null && node.getValue().equals(searchCriteria)) {
            resultNode = node;
            return true;
        }
        else {
            return false;
        }
    }

    public BinaryTreeNode<T> getResultNode() {
        return resultNode;
    }

}
