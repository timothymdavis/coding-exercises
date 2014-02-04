package spike.projecteuler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem004Test {

    @Test
    public void given() {
        assertThat(Problem004.findLargestNumericalPalindromeOf(2), is(9009L));
    }

    @Test
    public void answer() {
        assertThat(Problem004.findLargestNumericalPalindromeOf(3), is(906609L));
    }

}
