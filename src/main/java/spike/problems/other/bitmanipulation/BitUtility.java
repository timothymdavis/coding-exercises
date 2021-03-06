package spike.problems.other.bitmanipulation;

public class BitUtility {

    /**
     * Adds two integers together without using the + operator.
     *
     *    8 ,    2 ->   10,     0
     * 1000 , 0010 -> 1010, 00000
     *
     *    9 ,    8 ->     1,    16 ->    17,     0
     * 1001 , 1000 -> 00001, 10000 -> 10001, 00000
     *
     * @param x left side.
     * @param y right side.
     * @return the sum.
     */
    public static int add(int x, int y) {
        if (y == 0) {
            return x;
        }
        else {
            return add(x ^ y, (x & y) << 1);
        }
    }

    /**
     * Subtracts one integer from another without using the - operator.
     *
     * @param x left side.
     * @param y right side.
     * @return the result.
     */
    public static int subtract(int x, int y) {
        int yNegative = add(1, ~y);
        return add(x, yNegative);
    }

}
