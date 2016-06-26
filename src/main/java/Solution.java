import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * For HackerRank (hackerrank.com) problems. Needs to be in the default package for easy copy/paste.
 */
public class Solution {


    public static void solve(int[] n) {
    }


    public static void main(String[] args) {
        Boilerplate.intArrayTestCase(Solution::solve);
    }

    /**
     * Boilerplate code for HackerRank problems.
     */
    public static class Boilerplate {

        public static void genericTestCase(TestCaseHandler handler) {
            Scanner scanner = new Scanner(System.in);
            int testCaseCount = scanner.nextInt();
            IntStream.range(0, testCaseCount).forEach(i -> handler.handle(scanner));
        }

        @SuppressWarnings("unused")
        public static void singleRowTestCase(TestCaseHandler handler) {
            Scanner scanner = new Scanner(System.in);
            handler.handle(scanner);
        }

        @SuppressWarnings("unused")
        public static void intTestCase(IntTestCaseHandler handler) {
            genericTestCase(s -> handler.handle(s.nextInt()));
        }

        @SuppressWarnings("unused")
        public static void twoIntTestCase(TwoIntTestCaseHandler handler) {
            genericTestCase(s -> handler.handle(s.nextInt(), s.nextInt()));
        }

        @SuppressWarnings("unused")
        public static void intArrayTestCase(IntArrayTestCaseHandler handler) {
            genericTestCase(s -> handler
                    .handle(IntStream.range(0, s.nextInt())
                    .map(i -> s.nextInt())
                    .toArray()));
        }

        public interface TestCaseHandler {
            void handle(Scanner scanner);
        }

        public interface IntTestCaseHandler {
            void handle(int number);
        }

        public interface TwoIntTestCaseHandler {
            void handle(int numberOne, int numberTwo);
        }

        public interface IntArrayTestCaseHandler {
            void handle(int[] array);
        }

    }

}
