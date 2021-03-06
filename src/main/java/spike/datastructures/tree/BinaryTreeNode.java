package spike.datastructures.tree;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import spike.datastructures.tree.traverser.NodeTraverser;
import spike.datastructures.tree.visitor.NodeVisitor;

@Data
@RequiredArgsConstructor
public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> right;
    private final T value;

    public BinaryTreeNode(BinaryTreeNode<T> parent, T value) {
        this.parent = parent;
        this.value = value;
    }

    public void traverse(NodeTraverser<T> traverser, NodeVisitor<T> visitor) {
        traverser.traverse(this, visitor);
    }

}
