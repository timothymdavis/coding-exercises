package spike.fibonacci;

/**
 * This interface defines how to get the nth element in the Fibonacci sequence.
 */
public interface FibonacciSequence {

    /**
     * Gets the nth element of the Fibonacci sequence.
     *
     * @param n The element number. For instance, for the sixth element in the Fibonacci sequence,
     *          the value returned would be 8.
     * @return The Fibonacci number for the nth element.
     */
    long fib(long n);

}
