package spike.hackerrank;

/**
 * See https://www.hackerrank.com/challenges/encryption and src/main/resources/hackerrank/encryption-English.pdf
 */
public class Encryption {

    public static void solve(String text) {
        int textIndex = 0;
        int columnCount = (int) Math.ceil(Math.sqrt(text.length()));
        int rowCount = (int) Math.floor(Math.sqrt(text.length()));
        if (columnCount * rowCount < text.length()) {
            rowCount = columnCount;
        }
        char[][] grid = new char[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (textIndex < text.length()) {
                    grid[i][j] = text.charAt(textIndex++);
                }
                else {
                    grid[i][j] = ' ';
                }
            }
        }
        for (int j = 0; j < columnCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                if (grid[i][j] != ' ') {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.print(" ");
        }
        System.out.println();
    }

}
