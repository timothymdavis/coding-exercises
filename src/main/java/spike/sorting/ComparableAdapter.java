package spike.sorting;

import java.util.Comparator;

/**
 * Simple adapter that turns a couple of {@link Comparable} objects into a {@link Comparator}.
 *
 * @param <T> The type of objects to compare. Must implement {@link Comparable}.
 */
public class ComparableAdapter<T extends Comparable<T>> implements Comparator<T> {

    /**
     * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer as the first
     * argument is less than, equal to, or greater than the second.
     *
     * @param o1 The first object to be compared.
     * @param o2 The second object to be compared.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater
     *         than the second.
     * @throws ClassCastException       If the arguments' types prevent them from being compared by this comparator.
     * @throws IllegalArgumentException If either argument is <code>null</code>.
     */
    @Override
    public int compare(T o1, T o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Can't compare null objects!");
        }
        return o1.compareTo(o2);
    }

}
