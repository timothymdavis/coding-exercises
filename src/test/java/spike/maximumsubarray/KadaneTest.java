package spike.maximumsubarray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KadaneTest {

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
    }

}