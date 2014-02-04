package spike.fibonacci;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IterativeFibonacciSequenceTest {

    @Test
    public void testFib0() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(0), is(0L));
    }

    @Test
    public void testFib1() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(1), is(1L));
    }

    @Test
    public void testFib() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(5), is(5L));
    }

    @Test
    public void testFib6() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(6), is(8L));
    }

    @Test
    public void testFib20() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(20), is(6765L));
    }

    @Test
    public void testFib100() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(100), is(3736710778780434371L));
    }

}
