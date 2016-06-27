package spike.bitmanipulation;

public class BitUtility {

    public static int add(int x, int y) {
        if (y == 0) {
            return x;
        }
        else {
            return add(x ^ y, (x & y) << 1);
        }
    }

    public static int subtract(int x, int y) {
        int yNegative = add(1, ~y);
        return add(x, yNegative);
    }

}
