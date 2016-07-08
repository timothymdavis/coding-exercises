import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * For HackerRank (hackerrank.com) problems. Needs to be in the default package for easy copy/paste.
 */
public class Solution {


    public static void solve(int n) {
        System.out.println(n);
    }


    public static void main(String[] args) {
        Boilerplate.singleTestCase(s -> solve(s.nextInt()));
    }

    /**
     * Boilerplate code for HackerRank problems.
     */
    public static class Boilerplate {

        @SuppressWarnings("unused")
        public static void singleTestCase(Consumer<Scanner> handler) {
            handler.accept(new Scanner(System.in));
        }

        @SuppressWarnings("unused")
        public static void multiTestCase(Consumer<Scanner> handler) {
            Scanner scanner = new Scanner(System.in);
            int testCaseCount = scanner.nextInt();
            IntStream.range(0, testCaseCount).forEach(i -> handler.accept(scanner));
        }

        /**
         * {@code singleTestCase(s -> nextArray(s, s::next, String[]::new)); }
         * {@code multiTestCase(s -> nextArray(s, s::nextInt, Integer[]::new)); }
         */
        public static <A> A[] nextArray(int size, Supplier<A> supplier, IntFunction<A[]> intFunction) {
            return IntStream.range(0, size).mapToObj(i -> supplier.get()).toArray(intFunction);
        }

    }

}
