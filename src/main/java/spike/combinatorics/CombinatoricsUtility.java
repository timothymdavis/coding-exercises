package spike.combinatorics;

/**
 * These don't work for numbers larger than long.
 */
public class CombinatoricsUtility {

    public static long factorial(long n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= i + 1;
        }
        return result;
    }

    public static long nCr(long n, long r) {
        long result = 1;
        r = Math.min(r, n - r);
        for (int i = 1; i <= r; i++, n--) {
            result = result / i * n + result % i * n / i;
        }
        return result;
    }

    public static long nPr(long n, long r) {
        return factorial(n) / factorial(n - r);
    }

}
