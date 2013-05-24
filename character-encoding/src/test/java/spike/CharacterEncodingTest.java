package spike;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CharacterEncodingTest
{
    private static final String ISO_8859_1_FILE_NAME = "/ISO-8859-1.dat";

    @Test
    public void usingUtf8Encoding() throws IOException
    {
        /*
         * Notes:
         *
         *  We were having an issue where customers would see "Dï¿½SSELDORF" in their e-mail instead of the proper
         *  encoding. Here's a step by step so I don't forget what happened in the future.
         *
         *  1. A third party process writes "DÜSSELDORF" to disk with the ISO-8859-1 encoding.
         *  2. Our internal process picks up the file using the UTF-8 encoding.
         *  3. The UTF-8 encoding doesn't know what to do with the 'Ü' character and replaces it with '�' or
         *     "11101111 10111111 10111101" in binary.
         *  4. The user receives an e-mail from us and views it in something that uses the ISO-8859-1 encoding,
         *     which interprets the replacement code as "ï¿½" because in ISO-8859-1:
         *       'ï' = 11101111
         *       '¿' = 10111111
         *       '½' = 10111101
         *  5. Or the user views the email with UTF-8 and sees the replacement character '�'.
         */

        InputStream inputStream = getClass().getResourceAsStream(ISO_8859_1_FILE_NAME);

        String inputAsUtf8 = IOUtils.toString(inputStream);
        assertThat(inputAsUtf8, is("D�SSELDORF\n"));

        String convertedToIso88591 = new String(inputAsUtf8.getBytes(), "ISO-8859-1");
        assertThat(convertedToIso88591, is("Dï¿½SSELDORF\n"));
    }

    @Test
    public void usingISO_8859_1Encoding() throws IOException
    {
        InputStream inputStream = getClass().getResourceAsStream(ISO_8859_1_FILE_NAME);
        String inputAsIso88591 = IOUtils.toString(inputStream, "ISO-8859-1");
        assertThat(inputAsIso88591, is("DÜSSELDORF\n"));
    }
}
