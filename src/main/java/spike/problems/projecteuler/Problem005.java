package spike.problems.projecteuler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p/>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem005 {

    public static long findSmallestNumberDivisibleFromOneTo(int number) {
        int smallestNumber = 0;
        boolean divisibleByAll = false;
        while (!divisibleByAll) {
            smallestNumber++;
            divisibleByAll = true;
            for (int i = 1; i <= number && divisibleByAll; i++) {
                if (smallestNumber % i != 0) {
                    divisibleByAll = false;
                }
            }
        }
        return smallestNumber;
    }

}
