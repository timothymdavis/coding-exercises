package spike.problems.other.toexcel;

/**
 * Write a function (with helper functions if needed) called to Excel that takes an excel column value (A,B,C,D…AA,AB,
 * AC,… AAA..) and returns a corresponding integer value (A=1,B=2,… AA=26[sic]..).
 */
public class ExcelConverter {

    public static int toExcel(String columnName) {
        int result = (columnName.length() - 1) * 26;
        char lastCharacter = columnName.substring(columnName.length() - 1).charAt(0);
        result += lastCharacter - 'A' + 1;
        return result;
    }

}
