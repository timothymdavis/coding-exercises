package spike.problems.hackerrank;

/**
 * See https://www.hackerrank.com/challenges/reduced-string and src/main/resources/hackerrank/reduced-string-English.pdf
 */
public class ReducedString {

    public static void solve(String s) {
        String reduced = reduce(s);
        System.out.println(reduced.isEmpty() ? "Empty String" : reduced);
    }

    public static String reduce(String s) {
        if (s.length() > 2) {
            String l = reduce(s.substring(0, s.length() / 2));
            String r = reduce(s.substring(s.length() / 2, s.length()));
            if (!l.isEmpty() && !r.isEmpty() && l.charAt(l.length() - 1) == r.charAt(0)) {
                return reduce(l.substring(0, l.length() - 1) + r.substring(1));
            } else {
                return l + r;
            }
        } else if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return "";
        } else {
            return s;
        }
    }

}
