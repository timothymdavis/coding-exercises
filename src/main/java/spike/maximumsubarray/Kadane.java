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

        int startIndex = 0, endIndex = 0, sum = 0, total = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] > (sum < 0 ? total : sum)) {
                startIndex = i;
                sum = array[i];
            }
            if (sum > total) {
                total = sum;
                endIndex = i;
            }
        }

        return Arrays.copyOfRange(array, startIndex, endIndex + 1);
    }

}
