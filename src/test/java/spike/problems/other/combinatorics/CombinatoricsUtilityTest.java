package spike.problems.other.combinatorics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static spike.problems.other.combinatorics.CombinatoricsUtility.factorial;
import static spike.problems.other.combinatorics.CombinatoricsUtility.nCr;
import static spike.problems.other.combinatorics.CombinatoricsUtility.nPr;

public class CombinatoricsUtilityTest {

    @Test
    public void testFactorial() throws Exception {
        assertThat(factorial(0), is(1L));
        assertThat(factorial(1), is(1L));
        assertThat(factorial(2), is(2L));
        assertThat(factorial(3), is(6L));
        assertThat(factorial(4), is(24L));
        assertThat(factorial(20), is(2432902008176640000L));

    }

    @Test
    public void testNCR() throws Exception {
        assertThat(nCr(1, 0), is(1L));
        assertThat(nCr(1, 1), is(1L));
        assertThat(nCr(2, 0), is(1L));
        assertThat(nCr(2, 1), is(2L));
        assertThat(nCr(2, 2), is(1L));
        assertThat(nCr(3, 0), is(1L));
        assertThat(nCr(3, 1), is(3L));
        assertThat(nCr(3, 2), is(3L));
        assertThat(nCr(3, 3), is(1L));
        assertThat(nCr(4, 0), is(1L));
        assertThat(nCr(4, 1), is(4L));
        assertThat(nCr(4, 2), is(6L));
        assertThat(nCr(4, 3), is(4L));
        assertThat(nCr(4, 4), is(1L));
        assertThat(nCr(5, 0), is(1L));
        assertThat(nCr(5, 1), is(5L));
        assertThat(nCr(5, 2), is(10L));
        assertThat(nCr(5, 3), is(10L));
        assertThat(nCr(5, 4), is(5L));
        assertThat(nCr(5, 5), is(1L));
        assertThat(nCr(20, 5), is(15504L));
    }

    @Test
    public void testPCR() throws Exception {
        assertThat(nPr(1, 0), is(1L));
        assertThat(nPr(1, 1), is(1L));
        assertThat(nPr(2, 0), is(1L));
        assertThat(nPr(2, 1), is(2L));
        assertThat(nPr(2, 2), is(2L));
        assertThat(nPr(3, 0), is(1L));
        assertThat(nPr(3, 1), is(3L));
        assertThat(nPr(3, 2), is(6L));
        assertThat(nPr(3, 3), is(6L));
        assertThat(nPr(4, 0), is(1L));
        assertThat(nPr(4, 1), is(4L));
        assertThat(nPr(4, 2), is(12L));
        assertThat(nPr(4, 3), is(24L));
        assertThat(nPr(4, 4), is(24L));
        assertThat(nPr(5, 0), is(1L));
        assertThat(nPr(5, 1), is(5L));
        assertThat(nPr(5, 2), is(20L));
        assertThat(nPr(5, 3), is(60L));
        assertThat(nPr(5, 4), is(120L));
        assertThat(nPr(5, 5), is(120L));
        assertThat(nPr(20, 5), is(1860480L));
    }

}