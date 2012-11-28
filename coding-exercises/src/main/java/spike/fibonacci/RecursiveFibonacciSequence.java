package spike.fibonacci;

/**
 * A recursive implementation of the Fibonacci sequence.
 */
public class RecursiveFibonacciSequence implements FibonacciSequence {

    @Override
    public long fib(long max) {
        if (max < 1) {
            return 0;
        }
        else if (max == 1) {
            return 1;
        }
        else {
            return fib(max - 1) + fib(max - 2);
        }
    }

}