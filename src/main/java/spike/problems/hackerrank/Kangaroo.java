package spike.problems.hackerrank;

/**
 * See https://www.hackerrank.com/challenges/kangaroo and src/main/resources/hackerrank/kangaroo-English.pdf
 */
public class Kangaroo {

    public static void solve(int x1, int v1, int x2, int v2) {
        System.out.println(canSolve(x1, v1, x2, v2) ? "YES" : "NO");
    }

    public static boolean canSolve(int x1, int v1, int x2, int v2) {
        if (v1 <= v2) {
            return false;
        }

        int delta = x2 - x1;

        while (x2 - x1 <= delta) {
            delta = x2 - x1;
            x1 += v1;
            x2 += v2;
            if (x1 == x2) {
                return true;
            }
        }

        return false;
    }

}
