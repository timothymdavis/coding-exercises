package spike.problems.hackerrank;

import java.util.Stack;

/**
 * See https://www.hackerrank.com/challenges/reduced-string and src/main/resources/hackerrank/reduced-string-English.pdf
 */
public class ReducedString {

    public static void solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        System.out.println(stack.stream()
                .map(String::valueOf)
                .reduce((a, b) -> a + b)
                .orElse("Empty String"));
    }

}
