package spike.tree.visitor;

import spike.tree.BinaryTreeNode;
import spike.tree.visitor.NodeVisitor;

import java.util.ArrayList;
import java.util.List;

public class GetListNodeVisitor<T> implements NodeVisitor<T> {

    private final List<T> result = new ArrayList<>();

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        result.add(node.getValue());
        return false;
    }

    public List<T> getResult() {
        return result;
    }

}
