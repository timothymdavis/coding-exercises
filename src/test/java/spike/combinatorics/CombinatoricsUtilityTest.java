package spike.combinatorics;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static spike.combinatorics.CombinatoricsUtility.factorial;
import static spike.combinatorics.CombinatoricsUtility.nCr;
import static spike.combinatorics.CombinatoricsUtility.nPr;

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
        assertThat(nCr(2, 1), is(2L));
        assertThat(nCr(20, 5), is(15504L));
    }

    @Test
    public void testPCR() throws Exception {
        assertThat(nPr(1, 0), is(1L));
        assertThat(nPr(2, 1), is(2L));
        assertThat(nPr(20, 5), is(1860480L));
    }

}