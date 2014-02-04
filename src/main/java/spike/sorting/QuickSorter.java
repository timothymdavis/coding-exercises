package spike.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A quick sort implementation.
 *
 * @param <T> The type to sort. Must extend {@link Comparable}.
 */
public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {

    private Comparator<T> comparator;

    /**
     * Default constructor. Uses a {@link ComparableAdapter} for comparisons.
     */
    public QuickSorter() {
        comparator = new ComparableAdapter<T>();
    }

    /**
     * Constructor that allows a custom {@link Comparator}.
     * <p/>
     * Precondition: comparator != null
     *
     * @param comparator The custom {@link Comparator} to use instead of {@link ComparableAdapter}.
     */
    public QuickSorter(Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("The parameter comparator must not be null!");
        }
        this.comparator = comparator;
    }

    private int partition(List<T> sortableList, int left, int right) {
        T pivotValue = sortableList.get(right);
        while (left != right) {
            if (comparator.compare(sortableList.get(left), pivotValue) < 0) {
                left++;
            }
            else {
                sortableList.set(right, sortableList.get(left));
                sortableList.set(left, sortableList.get(--right));
            }
        }
        sortableList.set(right, pivotValue);
        return right;
    }

    @Override
    public List<T> sort(List<T> sortableList) {
        if (sortableList == null) {
            throw new IllegalArgumentException();
        }
        // Create a cloned copy so that the parameter sortableList doesn't suffer any side effects.
        ArrayList<T> clonedSortableList = new ArrayList<T>(sortableList);
        sort(clonedSortableList, 0, sortableList.size() - 1);
        return clonedSortableList;
    }

    private void sort(List<T> sortableList, int start, int end) {
        if (end - start > 0) {
            int pivot = partition(sortableList, start, end);
            sort(sortableList, start, pivot - 1);
            sort(sortableList, pivot + 1, end);
        }
    }
}
