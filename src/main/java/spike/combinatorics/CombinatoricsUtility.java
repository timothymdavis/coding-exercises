package spike.combinatorics;

/**
 * These don't work for numbers larger than {@code long}. For example 100! is too big to fit in a {@code long}.
 */
public class CombinatoricsUtility {

    /**
     * Returns the factorial of n, or n!. Warning: this method may overflow {@code long}.
     *
     * @param n The number to get the factorial of.
     * @return the result;
     */
    public static long factorial(long n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= i + 1;
        }
        return result;
    }

    /**
     * Provides the number of combinations given n and r. Typically this would be done by computing several factorials
     * like so:
     * <p/>
     * (n! / (n - r)!) / r!
     * <p/>
     * This method avoids computing multiple factorials.
     */
    public static long nCr(long n, long r) {
        long result = 1;
        r = Math.min(r, n - r);
        for (int i = 1; i <= r; i++, n--) {
            result = result / i * n + result % i * n / i;
        }
        return result;
    }

    /**
     * Provides the number of permutations given n and r. I have made no attempts to optimize this, so it can be
     * difficult to get results for large numbers. Warning: this method may overflow {@code long} for relatively small
     * numbers.
     */
    public static long nPr(long n, long r) {
        return factorial(n) / factorial(n - r);
    }

}
