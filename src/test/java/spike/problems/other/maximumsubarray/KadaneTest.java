package spike.problems.other.maximumsubarray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KadaneTest {

    @Test(expected = NullPointerException.class)
    public void testMaximumSubarraySumForNullArray() throws Exception {
        Kadane.maximumSubarraySum(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaximumSubarraySumForEmptyArray() throws Exception {
        Kadane.maximumSubarraySum(new int[] {});
    }

    @Test
    public void testMaximumSubarraySum() throws Exception {
        assertThat(Kadane.maximumSubarraySum(new int[] {-100, -100, -1, -100, -10}), is(-1L));
        assertThat(Kadane.maximumSubarraySum(new int[] {-100, 100, -1, 100, -100}), is(199L));
        assertThat(Kadane.maximumSubarraySum(new int[] {-100, 100, -1, 100, 10}), is(209L));
        assertThat(Kadane.maximumSubarraySum(new int[] {1, 2, 3, 4}), is(10L));
        assertThat(Kadane.maximumSubarraySum(new int[] {-1, 2, 3, 4}), is(9L));
        assertThat(Kadane.maximumSubarraySum(new int[] {-1, 2, -3, 4}), is(4L));
        assertThat(Kadane.maximumSubarraySum(new int[] {-1, 2, -1, 4}), is(5L));
    }

    @Test(expected = NullPointerException.class)
    public void testMaximumSubarrayForNullArray() throws Exception {
        Kadane.maximumSubarray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaximumSubarrayForEmptyArray() throws Exception {
        Kadane.maximumSubarray(new int[] {});
    }

    @Test
    public void testMaximumSubarray() throws Exception {
        assertThat(Kadane.maximumSubarray(new int[] {-100, -100, -1, -100, -10}), is(new int[] {-1}));
        assertThat(Kadane.maximumSubarray(new int[] {-100, 100, -1, 100, -100}), is(new int[] {100, -1, 100}));
        assertThat(Kadane.maximumSubarray(new int[] {-100, 100, -1, 100, 10}), is(new int[] {100, -1, 100, 10}));
        assertThat(Kadane.maximumSubarray(new int[] {1, 2, 3, 4}), is(new int[] {1, 2, 3 , 4}));
        assertThat(Kadane.maximumSubarray(new int[] {-1, 2, 3, 4}), is(new int[] {2, 3 , 4}));
        assertThat(Kadane.maximumSubarray(new int[] {-1, 2, -3, 4}), is(new int[] {4}));
        assertThat(Kadane.maximumSubarray(new int[] {-1, 2, -1, 4}), is(new int[] {2, -1, 4}));
    }

}