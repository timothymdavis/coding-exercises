package spike.bitmanipulation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static spike.bitmanipulation.BitUtility.add;
import static spike.bitmanipulation.BitUtility.subtract;

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

    @Test
    public void testSubtract() {
        assertThat(subtract(5, 3), is(2));
        assertThat(subtract(5, -3), is(8));
        assertThat(subtract(0, -1), is(1));
        assertThat(subtract(-1, 0), is(-1));
        assertThat(subtract(0, 0), is(0));
        assertThat(subtract(1, 0), is(1));
        assertThat(subtract(0, 1), is(-1));
        assertThat(subtract(10, 10), is(0));
        assertThat(subtract(Integer.MIN_VALUE + 1, 1), is(Integer.MIN_VALUE));
    }

}