package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RunWith(Parameterized.class)
public class CaesarCipher1Test extends HackerRankTest {

    public CaesarCipher1Test(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    @SuppressWarnings("StatementWithEmptyBody")
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/caesar-cipher-1-input.txt", "/hackerrank/caesar-cipher-1-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankTestHelper.multiTestCaseWithoutSize(s -> {
            while(Objects.equals(s.nextLine(), "")) {} // ignore the number of characters
            CaesarCipher1.solve(s.nextLine(), s.nextInt());
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}