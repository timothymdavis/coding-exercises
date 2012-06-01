package spike;

import static java.lang.System.out;

public class FizzBuzz {

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
