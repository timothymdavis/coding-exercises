package spike.datastructures.tree.traverser;

import spike.datastructures.tree.BinaryTreeNode;
import spike.datastructures.tree.visitor.NodeVisitor;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstNodeTraverser<T> implements NodeTraverser<T> {

    private boolean finished = false;

    @Override
    public void traverse(BinaryTreeNode<T> node, NodeVisitor<T> visitor) {
        if (node != null) {
            Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty() && !finished) {
                BinaryTreeNode<T> currentNode = queue.poll();
                finished = visitor.visit(currentNode);
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
        }
    }

}
