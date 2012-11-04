package spike.tree;

import java.util.ArrayList;
import java.util.List;

public class GetListNodeVisitor<T> implements NodeVisitor<T> {

    private List<T> result = new ArrayList<T>();

    @Override
    public boolean visit(BinaryTreeNode<T> node) {
        result.add(node.getValue());
        return false;
    }

    public List<T> getResult() {
        return result;
    }

}
