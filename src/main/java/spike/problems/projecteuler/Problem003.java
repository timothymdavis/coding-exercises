package spike.problems.projecteuler;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p/>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003 {

    public static long findLargestPrimeOf(long number) {
        for (long i = 2; i < number / 2; i++) {
            long nextNumber = number / i;
            if (number % nextNumber == 0) {
                long largestPrimeOf2 = findLargestPrimeOf(nextNumber);
                if (-1 == largestPrimeOf2) {
                    return nextNumber;
                }
            }
        }
        return -1;
    }

    public static long someoneElsesSolution(long number) {
        int i = 1;
        while (i + 1 != number) {
            if (number % ++i == 0) {
                number = number / i--;
            }
        }
        return number;
    }

}
