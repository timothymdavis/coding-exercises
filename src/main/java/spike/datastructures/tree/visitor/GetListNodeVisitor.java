package spike.datastructures.tree.visitor;

import spike.datastructures.tree.BinaryTreeNode;

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
