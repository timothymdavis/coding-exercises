package spike.bitmanipulation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static spike.bitmanipulation.BitUtility.add;

public class BitUtilityTest {

    @Test
    public void testAdd() throws Exception {
        assertThat(add(0, -1), is(-1));
        assertThat(add(-1, 0), is(-1));
        assertThat(add(0, 0), is(0));
        assertThat(add(0, 1), is(1));
        assertThat(add(1, 0), is(1));
        assertThat(add(10, 10), is(20));
        assertThat(add(Integer.MAX_VALUE - 1, 1), is(Integer.MAX_VALUE));
    }

}