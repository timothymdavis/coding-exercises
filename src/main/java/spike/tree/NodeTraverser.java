package spike.tree;

public interface NodeTraverser<T> {

    void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor);

}
