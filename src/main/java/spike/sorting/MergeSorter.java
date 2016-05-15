package spike.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Stab at a recursive Merge Sort.
 *
 * @param <T> The type to sort. Must extend {@link Comparable}.
 */
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    private Comparator<T> comparator;

    /**
     * Default constructor. Uses a {@link ComparableAdapter} for comparisons.
     */
    public MergeSorter() {
        comparator = new ComparableAdapter<>();
    }

    /**
     * Constructor that allows a custom {@link Comparator}.
     * <p/>
     * Precondition: comparator != null
     *
     * @param comparator The custom {@link Comparator} to use instead of {@link ComparableAdapter}.
     */
    public MergeSorter(Comparator<T> comparator) {
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

        sort(clonedSortableList, 0, sortableList.size());

        return clonedSortableList;
    }

    private void sort(List<T> sortableList, int start, int end) {
        if (end - start > 1) {
            int middle = start + ((end - start) / 2);
            sort(sortableList, start, middle);
            sort(sortableList, middle, end);
            merge(sortableList, start, middle, end);
        }
    }

    private void merge(List<T> list, int start, int middle, int end) {
        ArrayList<T> mergedList = new ArrayList<>();

        int l = 0, r = 0;

        while (l < middle - start && r < end - middle) {
            T left = list.get(start + l);
            T right = list.get(middle + r);
            mergedList.add(comparator.compare(left, right) < 0 ? list.get(start + l++) : list.get(middle + r++));
        }

        while (l < middle - start) {
            mergedList.add(list.get(start + l++));
        }

        while (r < end - middle) {
            mergedList.add(list.get(middle + r++));
        }

        for (int i = 0; i < mergedList.size(); i++) {
            list.set(start + i, mergedList.get(i));
        }
    }

}
