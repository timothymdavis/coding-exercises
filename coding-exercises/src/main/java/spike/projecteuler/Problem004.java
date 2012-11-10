package spike.projecteuler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers
 * is 9009 = 91  99.
 * <p/>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem004 {

    public static long findLargestNumericalPalindromeOf(int numberOfDigits) {
        long largestNumber = getLargestNumber(numberOfDigits);
        long largestPalindrome = 0;

        for (long i = largestNumber; i > 0; i--) {
            for (long j = largestNumber; j > 0; j--) {
                long potentialPalindrome = i * j;
                if (isPalindrome(String.valueOf(potentialPalindrome)) && largestPalindrome < potentialPalindrome) {
                    largestPalindrome = potentialPalindrome;
                }
            }
        }

        return largestPalindrome;
    }

    private static boolean isPalindrome(String potentialPalindrome) {
        int length = potentialPalindrome.length();
        char[] chars = potentialPalindrome.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    /*
     *  This wasn't necessary. I should have hard coded the input to 999.
     */
    public static long getLargestNumber(int numberOfDigits) {
        StringBuilder largestNumber = new StringBuilder();
        for (int i = 0; i < numberOfDigits; i++) {
            largestNumber.append("9");
        }
        return new Long(largestNumber.toString());
    }

}
