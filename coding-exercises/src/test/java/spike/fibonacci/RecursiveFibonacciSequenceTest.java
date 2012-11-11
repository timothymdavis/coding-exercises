package spike.fibonacci;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RecursiveFibonacciSequenceTest {

    @Test
    public void testFib0() throws Exception {
        assertThat(new RecursiveFibonacciSequence().fib(0), is(0L));
    }

    @Test
    public void testFib1() throws Exception {
        assertThat(new IterativeFibonacciSequence().fib(1), is(1L));
    }

    @Test
    public void testFib() throws Exception {
        assertThat(new RecursiveFibonacciSequence().fib(5), is(5L));
    }

    @Test
    public void testFib6() throws Exception {
        assertThat(new RecursiveFibonacciSequence().fib(6), is(8L));
    }

    @Test
    public void testFib20() throws Exception {
        assertThat(new RecursiveFibonacciSequence().fib(20), is(6765L));
    }

}
