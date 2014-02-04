package spike.sorting;

import java.util.List;

/**
 * Defines the interface that all sorting algorithms in this package should implement.
 *
 * @param <T> The type to sort. Must implement {@link Comparable}.
 */
public interface Sorter<T extends Comparable<T>> {

    /**
     * Takes an unsorted list and returns a new sorted list made of the same list items. The parameter sortableList
     * shouldn't be modified in any way after this method is called.
     *
     * @param sortableList The unsorted list.
     * @return A new sorted list.
     */
    List<T> sort(List<T> sortableList);

}
