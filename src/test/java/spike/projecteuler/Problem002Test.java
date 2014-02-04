package spike.projecteuler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem002Test {

    @Test
    public void given() {
        assertThat(Problem002.sumOfEvenValuedFibonacciTermUpTo(90), is(44L));
    }

    @Test
    public void answer() {
        assertThat(Problem002.sumOfEvenValuedFibonacciTermUpTo(4000000), is(4613732L));
    }

}
