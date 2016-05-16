package spike.toexcel;

/**
 * Write a function (with helper functions if needed) called to Excel that takes an excel column value (A,B,C,D…AA,AB,
 * AC,… AAA..) and returns a corresponding integer value (A=1,B=2,… AA=26[sic]..).
 */
public class ExcelConverter {

    public static int toExcel(String columnName) {
        int result = (columnName.length() - 1) * 26;
        String lastCharacter = columnName.substring(columnName.length() - 1);
        result += Integer.parseInt(lastCharacter, 36) - 9;
        return result;
    }

}
