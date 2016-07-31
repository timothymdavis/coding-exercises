package spike.problems.hackerrank;

import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;

import static java.lang.Character.toChars;

/**
 * See https://www.hackerrank.com/challenges/caesar-cipher-1 and src/main/resources/hackerrank/caesar-cipher-1-English.pdf
 */
public class CaesarCipher1 {

    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]");

    public static void solve(String toEncrypt, int k) {
        String encrypted = toEncrypt.codePoints()
                .map(rotateCharacterBy(k))
                .mapToObj(c -> String.valueOf(toChars(c)))
                .reduce((a, b) -> a + b)
                .orElse("");
        System.out.println(encrypted);
    }

    private static IntUnaryOperator rotateCharacterBy(int k) {
        return c -> {
            int base = Character.isUpperCase(c) ? 65 : 97;
            return PATTERN.matcher(String.valueOf(toChars(c))).matches() ? base + (c - base + k) % 26 : c;
        };
    }

}
