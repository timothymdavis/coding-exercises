package spike.complexity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BigOhTest {

    private static final int N = 10;
    private static int[] TEN_INTS = new int[N];

    @Test
    public void test1() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of1();
        assertThat(bigOh.getCount(), is(1D));
    }

    @Test
    public void testN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofN(TEN_INTS);
        assertThat(bigOh.getCount(), is((double) N));
    }

    @Test
    public void testNRecursive() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofNRecursive((long) N);
        assertThat(bigOh.getCount(), is((double) N));
    }

    @Test
    public void testLogBase2OfN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofLogBase2OfN(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.floor(Math.log(N) / Math.log(2))));
    }

    @Test
    public void testLogBase3OfN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofLogBase3OfN(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.floor(Math.log(N) / Math.log(3))));
    }

    @Test
    public void testNCubed() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofNCubed(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.pow(N, 3)));
    }

    @Test
    public void test2ToTheN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of2ToTheN((long) N);
        assertThat(bigOh.getCount(), is(Math.pow(2, N) - 1));
    }

    @Test
    public void test3ToTheN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of3ToTheN((long) N);
        assertThat(bigOh.getCount(), is(Math.floor(Math.pow(3, N) / 2)));
    }

    @Test
    public void test4ToTheN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of4ToTheN((long) N);
        assertThat(bigOh.getCount(), is(Math.floor(Math.pow(4, N) / 3)));
    }

}