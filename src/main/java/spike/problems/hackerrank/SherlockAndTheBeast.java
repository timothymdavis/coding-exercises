package spike.problems.hackerrank;

import java.util.Arrays;

/**
 * See https://www.hackerrank.com/challenges/sherlock-and-the-beast and src/main/resources/hackerrank/sherlock-and-the-beast-English.pdf
 */
public class SherlockAndTheBeast {

    public static void solution(Integer[] digits) {
        Arrays.stream(digits).forEach(SherlockAndTheBeast::printLargestDecentNumber);
    }

    public static void printLargestDecentNumber(int size) {
        int currentSize = size;

        while (currentSize % 3 != 0) {
            currentSize -= 5;
        }

        if (currentSize < 0) {
            System.out.println("-1");
        }
        else {
            for (int i = 0; i < currentSize; i++) {
                System.out.print("5");
            }
            for (int i = 0; i < size - currentSize; i++) {
                System.out.print("3");
            }
            System.out.println("");
        }
    }

}
