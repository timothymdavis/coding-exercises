package spike.commoncharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function f(a, b) which takes two character string arguments and returns a string containing only the
 * characters found in both strings in the order of a. Write a version which is order N-squared and one which is order
 * N.
 */
public class CommonCharacters {

    public static String nSquared(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (char aCharacter : a.toCharArray()) {
            for (char bCharacter : b.toCharArray()) {
                if (aCharacter == bCharacter) {
                    sb.append(aCharacter);
                }
            }
        }
        return sb.toString();
    }

    public static String n(String a, String b) {
        Set<Character> characterSet = new HashSet<>();
        for (char aCharacter : a.toCharArray()) {
            characterSet.add(aCharacter);
        }
        StringBuilder sb = new StringBuilder();
        for (char bCharacter : b.toCharArray()) {
            if (characterSet.contains(bCharacter)) {
                sb.append(bCharacter);
            }
        }
        return sb.toString();
    }

}
