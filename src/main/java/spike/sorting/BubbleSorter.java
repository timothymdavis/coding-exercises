package spike.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classic bubble sort algorithm.
 *
 * @param <T> The type to sort. Must implement {@link Comparable}.
 */
public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

    private Comparator<T> comparator;

    /**
     * Default constructor. Uses a {@link ComparableAdapter} for comparisons.
     */
    public BubbleSorter() {
        comparator = new ComparableAdapter<T>();
    }

    /**
     * Constructor that allows a custom {@link Comparator}.
     * <p/>
     * Precondition: comparator != null
     *
     * @param comparator The custom {@link Comparator} to use instead of {@link ComparableAdapter}.
     */
    public BubbleSorter(Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("The parameter comparator must not be null!");
        }
        this.comparator = comparator;
    }

    @Override
    public List<T> sort(List<T> sortableList) {
        if (sortableList == null) {
            throw new IllegalArgumentException("Parameter sortableList must not be null!");
        }
        ArrayList<T> clonedSortableList = new ArrayList<T>(sortableList);
        sortInner(clonedSortableList);
        return clonedSortableList;
    }

    private void sortInner(List<T> list) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                    swap(list, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(List<T> list, int i1, int i2) {
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

}
