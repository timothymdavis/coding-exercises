package spike;

import static java.lang.System.out;

/**
 * Decided to take a quick stab at FizzBuzz. Probably took two minutes.
 *
 * See http://www.codinghorror.com/blog/2007/02/why-cant-programmers-program.html.
 */
public class FizzBuzz {

    /**
     * Makes the FizzBuzz magic happen!
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                out.print(i);
            }
            if (i % 3 == 0) {
                out.print("Fizz");
            }
            if (i % 5 == 0) {
                out.print("Buzz");
            }
            out.println();
        }
    }

}
