package spike.tree;

public interface NodeVisitor<T> {

    boolean visit(BinaryTreeNode<T> node);

}
