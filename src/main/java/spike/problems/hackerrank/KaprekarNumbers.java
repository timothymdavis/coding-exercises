package spike.problems.hackerrank;

import java.util.stream.IntStream;

/**
 * See https://www.hackerrank.com/challenges/kaprekar-numbers and src/main/resources/hackerrank/kaprekar-numbers-English.pdf
 */
public class KaprekarNumbers {

    public static void solve(int min, int max) {
        String result = IntStream.rangeClosed(min, max)
                .filter(KaprekarNumbers::isKaprekar)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + " " + b)
                .orElse("INVALID RANGE");
        System.out.println(result);
    }

    private static boolean isKaprekar(long input) {
        long number = (long) Math.pow(input, 2);
        long digits = getDigitCount(input);
        long den = (long) Math.pow(10, digits);
        long l = number / den;
        long r = number % den;
        return r > 0 && l + r == input;
    }

    private static int getDigitCount(long number) {
        int result = 0;
        while (number >= 1) {
            number = number / 10;
            result++;
        }
        return result;
    }

}
