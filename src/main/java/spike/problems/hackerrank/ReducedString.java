package spike.problems.hackerrank;

/**
 * See https://www.hackerrank.com/challenges/reduced-string and src/main/resources/hackerrank/reduced-string-English.pdf
 */
public class ReducedString {

    public static void solve(String s) {
        boolean nothingRemoved;
        do {
            nothingRemoved = true;
            for (int i = 0; i < s.length() - 1; i++) {
                char currentChar = s.charAt(i);
                char nextChar = s.charAt(i + 1);
                if (currentChar == nextChar) {
                    nothingRemoved = false;
                    String temp = s.substring(0, i);
                    if (s.length() >= i + 2) {
                        temp += s.substring(i + 2);
                    }
                    s = temp;
                }
            }
        }
        while (!nothingRemoved);
        System.out.println(s.isEmpty() ? "Empty String" : s);
    }

}
