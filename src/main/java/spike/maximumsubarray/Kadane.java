package spike.maximumsubarray;

import java.util.Arrays;
import java.util.Objects;

/**
 * See Kadane's Algorithm: https://en.wikipedia.org/wiki/Maximum_subarray_problem.
 */
public class Kadane {

    public static int[] maximumSubarray(int[] array) {
        Objects.requireNonNull(array);
        if (array.length == 0) throw new IllegalArgumentException("array must not be empty");

        int startIndex = 0, endIndex = 0, runningTotal = 0, subTotal = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            runningTotal += array[i];
            if (array[i] > subTotal) {
                startIndex = i;
                runningTotal = array[i];
            }
            if (runningTotal > subTotal) {
                subTotal = runningTotal;
                endIndex = i;
            }
        }

        return Arrays.copyOfRange(array, startIndex, endIndex + 1);
    }

}
