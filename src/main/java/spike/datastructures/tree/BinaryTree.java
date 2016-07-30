package spike.datastructures.tree;

import java.util.List;

/**
 * Simple binary tree interface. Only allows {@link #delete(T)}, {@link #insert(T)}, and {@link #contains(T)}
 */
public interface BinaryTree<T extends Comparable<T>> {

    /**
     * Deletes the {@link BinaryTreeNode} that contains {@code value}.
     * <p/>
     * Does nothing if the value isn't found in the tree.
     *
     * @param value the value to delete from the tree.
     */
    void delete(T value);

    /**
     * Inserts a new {@link BinaryTreeNode} that contains the {@code value}.
     * <p/>
     * Duplicate values may be ignored.
     *
     * @param value The value to insert into the tree.
     */
    void insert(T value);

    /**
     * Returns {@code true} if the tree contains {@code value}.
     *
     * @param value The value to search for.
     * @return true if the tree contains {@code value}; false otherwise.
     */
    boolean contains(T value);

    /**
     * Convenience method for getting a breadth-first list of the tree.
     *
     * @return The list containing the breadth-first ordered values.
     */
    List<T> getBreadthFirstList();

}
