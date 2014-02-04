package spike.projecteuler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem003Test {

    @Test
    public void given() {
        //assertThat(Problem003.findLargestPrimeOf(13195L), is(29L));
    }

    @Test
    public void given2() {
        assertThat(Problem003.someoneElsesSolution(600851475143L), is(6857L));
    }

    @Test
    public void answer() {
        //assertThat(Problem003.findLargestPrimeOf(600851475143L), is(6857L));
    }

    @Test
    public void answer2() {
        assertThat(Problem003.someoneElsesSolution(600851475143L), is(6857L));
    }

}
