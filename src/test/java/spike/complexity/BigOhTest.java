package spike.complexity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BigOhTest {

    private static int[] TEN_INTS = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

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
        assertThat(bigOh.getCount(), is(10D));
    }

    @Test
    public void testNRecursive() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofNRecursive(10);
        assertThat(bigOh.getCount(), is(10D));
    }

    @Test
    public void testLogBase2OfN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofLogBase2OfN(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.floor(Math.log(10) / Math.log(2))));
    }

    @Test
    public void testLogBase3OfN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofLogBase3OfN(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.floor(Math.log(10) / Math.log(3))));
    }

    @Test
    public void testNSquared() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofNSquared(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.pow(10, 2)));
    }

    @Test
    public void testNCubed() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.ofNCubed(TEN_INTS);
        assertThat(bigOh.getCount(), is(Math.pow(10, 3)));
    }

    @Test
    public void test2ToTheN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of2ToTheN(10);
        assertThat(bigOh.getCount(), is(Math.pow(2, 10) - 1));
    }

    @Test
    public void test3ToTheN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of3ToTheN(10);
        assertThat(bigOh.getCount(), is(Math.floor(Math.pow(3, 10) / 2)));
    }

    @Test
    public void test4ToTheN() throws Exception {
        BigOh bigOh = new BigOh();
        bigOh.of4ToTheN(10);
        assertThat(bigOh.getCount(), is(Math.floor(Math.pow(4, 10) / 3)));
    }

}