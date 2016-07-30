package spike.datastructures.tree.traverser;

import lombok.RequiredArgsConstructor;
import spike.datastructures.tree.BinaryTreeNode;
import spike.datastructures.tree.visitor.NodeVisitor;

@RequiredArgsConstructor
public class SortedBinaryTreeNodeTraverser<T extends Comparable<T>> implements NodeTraverser<T> {

    private boolean finished = false;
    private final T searchCriteria;

    @Override
    public void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor) {
        if (node != null && !finished) {
            if (searchCriteria.compareTo(node.getValue()) < 0) {
                BinaryTreeNode<T> left = node.getLeft();
                if (left == null) {
                    finished = visitor.visit(node);
                }
                else {
                    traverse(left, visitor);
                }
            }
            else if (searchCriteria.compareTo(node.getValue()) > 0) {
                BinaryTreeNode<T> right = node.getRight();
                if (right == null) {
                    finished = visitor.visit(node);
                }
                else {
                    traverse(right, visitor);
                }
            }
            else {
                finished = visitor.visit(node);
            }
        }
    }

}
