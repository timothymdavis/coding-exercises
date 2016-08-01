package spike.problems.other.fibonacci;

/**
 * An iterative implementation of the Fibonacci sequence.
 */
public class IterativeFibonacciSequence implements FibonacciSequence {

    @Override
    public long fib(long n) {
        long prev = 1, curr = 1, result = n;

        for (long i = 2; i < n; i++) {
            result = prev + curr;
            prev = curr;
            curr = result;
        }

        return result;
    }

}
