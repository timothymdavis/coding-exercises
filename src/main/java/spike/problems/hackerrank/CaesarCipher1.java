package spike.problems.hackerrank;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * See https://www.hackerrank.com/challenges/caesar-cipher-1 and src/main/resources/hackerrank/caesar-cipher-1-English.pdf
 */
public class CaesarCipher1 {

    private static final Pattern IS_LETTER_PATTERN = Pattern.compile("[a-zA-Z]");

    public static void solve(String toEncrypt, int rotateCount) {
        String encrypted = Arrays.stream(toEncrypt.split(""))
                .map(s -> s.charAt(0))
                .map(c -> rot(c, rotateCount))
                .map(String::valueOf)
                .reduce((a, b) -> a + b)
                .orElse("");
        System.out.println(encrypted);
    }

    private static char rot(char c, int rotateCount) {
        if (isLetter(c)) {
            boolean isUpper = Character.isUpperCase(c);
            int base = isUpper ? 65 : 97;
            return (char) (base + (c - base + rotateCount) % 26);
        }
        else {
            return c;
        }
    }

    /**
     * Apparently Character#isLetter(char) won't work for this problem.
     */
    private static boolean isLetter(char codePoint) {
        return IS_LETTER_PATTERN.matcher(String.valueOf(codePoint)).find();
    }

}
