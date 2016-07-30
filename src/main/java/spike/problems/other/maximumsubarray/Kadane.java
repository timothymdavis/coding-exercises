package spike.problems.other.maximumsubarray;

import java.util.Arrays;
import java.util.Objects;

/**
 * See Kadane's Algorithm: https://en.wikipedia.org/wiki/Maximum_subarray_problem.
 */
public class Kadane {

    public static long maximumSubarraySum(int[] array) {
        Objects.requireNonNull(array);
        if (array.length == 0) throw new IllegalArgumentException("array must not be empty");

        long subTotal = array[0];
        long total = array[0];

        for (int i = 1; i < array.length; i++) {
            subTotal = Math.max(array[i], subTotal + array[i]);
            total = Math.max(total, subTotal);
        }

        return total;
    }

    public static int[] maximumSubarray(int[] array) {
        Objects.requireNonNull(array);
        if (array.length == 0) throw new IllegalArgumentException("array must not be empty");

        int startIndex = 0;
        int endIndex = 0;
        int subTotal = array[0];
        int total = array[0];

        for (int i = 1; i < array.length; i++) {
            subTotal = Math.max(array[i], subTotal + array[i]);
            if (subTotal > total) {
                endIndex = i;
            }
            total = Math.max(total, subTotal);
            if (array[i] == total) {
                startIndex = i;
            }
        }

        return Arrays.copyOfRange(array, startIndex, endIndex + 1);
    }

}
