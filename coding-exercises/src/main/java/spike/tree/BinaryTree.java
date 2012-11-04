package spike.tree;

import java.util.List;

public interface BinaryTree<T extends Comparable<T>> {

    void delete(T value);

    void insert(T value);

    boolean contains(T value);

    List<T> getBreadthFirstList();

}
