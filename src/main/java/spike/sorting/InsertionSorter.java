package spike.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * An insertion sort implementation.
 *
 * @param <T> The type to sort. Must extend {@link Comparable}.
 */
public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {

    private Comparator<T> comparator;

    /**
     * Default constructor. Uses a {@link ComparableAdapter} for comparisons.
     */
    public InsertionSorter() {
        comparator = new ComparableAdapter<>();
    }

    /**
     * Constructor that allows a custom {@link Comparator}.
     * <p/>
     * Precondition: comparator != null
     *
     * @param comparator The custom {@link Comparator} to use instead of {@link ComparableAdapter}.
     */
    public InsertionSorter(Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("The parameter comparator must not be null!");
        }
        this.comparator = comparator;
    }

    @Override
    public List<T> sort(List<T> sortableList) {
        if (sortableList == null) {
            throw new IllegalArgumentException();
        }

        // Create a cloned copy so that the parameter sortableList doesn't suffer any side effects.
        ArrayList<T> clonedSortableList = new ArrayList<>(sortableList);

        sortInner(clonedSortableList);

        return clonedSortableList;
    }

    private void sortInner(List<T> sortableList) {
        for (int i = 0; i < sortableList.size(); i++) {
            T item = sortableList.get(i);
            int j = i;
            while (j > 0 && comparator.compare(item, sortableList.get(j-1)) < 0) {
                sortableList.set(j, sortableList.get(j-1));
                j--;
            }
            sortableList.set(j, item);
        }
    }

}
