package spike.problems.other.fibonacci;

/**
 * A recursive implementation of the Fibonacci sequence.
 */
public class RecursiveFibonacciSequence implements FibonacciSequence {

    @Override
    public long fib(long n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }

}
