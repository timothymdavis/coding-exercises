package spike.problems.hackerrank;

/**
 * See https://www.hackerrank.com/challenges/divisible-sum-pairs and st rc/main/resources/hackerrank/divisible-sum-pairs-English.pdf
 */
public class DivisibleSumPairs {

    public static void solve(int k, Integer[] n) {
        int count = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if((n[i] + n[j]) % k == 0 && i < j) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
