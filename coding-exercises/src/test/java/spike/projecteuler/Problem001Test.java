package spike.projecteuler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem001Test {

    @Test
    public void given() {
        assertThat(Problem001.sumOfMultiplesOfThreeOrFiveBelow(10), is(23L));
    }

    @Test
    public void answer() {
        assertThat(Problem001.sumOfMultiplesOfThreeOrFiveBelow(1000), is(233168L));
    }

}
