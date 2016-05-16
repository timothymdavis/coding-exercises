package spike.toexcel;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ExcelConverterTest {

    @Test
    public void testToExcel() throws Exception {
        assertThat(ExcelConverter.toExcel("A"), is(1));
        assertThat(ExcelConverter.toExcel("Z"), is(26));
        assertThat(ExcelConverter.toExcel("AA"), is(27));
        assertThat(ExcelConverter.toExcel("AB"), is(28));
        assertThat(ExcelConverter.toExcel("AAA"), is(53));
    }

}