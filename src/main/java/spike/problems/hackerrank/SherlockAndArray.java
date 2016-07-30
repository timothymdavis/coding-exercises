package spike.problems.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * See https://www.hackerrank.com/challenges/sherlock-and-array and src/main/resources/hackerrank/sherlock-and-array-English.pdf
 */
public class SherlockAndArray {

    public static void solve(Long[] array) {
        List<Long> list = Arrays.asList(array);
        System.out.println(findEqualibrium(list, list.size() / 2) ? "YES" : "NO");
    }

    private static boolean findEqualibrium(List<Long> list, int index) {
        if (list.size() == 1) {
            return true;
        }
        long left = getSum(list, 0, index);
        long right = getSum(list, index + 1, list.size());
        int firstPass = 0;
        while (index >= 1 && index < list.size()) {
            if (left == right) {
                return true;
            }
            else {
                int s = left < right ? 1 : -1;
                if (firstPass != 0 && firstPass != s) {
                    break;
                }
                firstPass = s;
                left += (list.get(index) * s);
                index = index + s;
                right -= (list.get(index) * s);
            }
        }
        return false;
    }

    private static long getSum(List<Long>list, int start, int end) {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += list.get(i);
        }
        return sum;
    }

}
