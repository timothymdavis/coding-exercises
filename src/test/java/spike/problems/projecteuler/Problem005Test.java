package spike.problems.projecteuler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem005Test {

    @Test
    public void given() {
        assertThat(Problem005.findSmallestNumberDivisibleFromOneTo(10), is(2520L));
    }

    @Test
    public void answer() {
        assertThat(Problem005.findSmallestNumberDivisibleFromOneTo(20), is(232792560L));
    }

}
