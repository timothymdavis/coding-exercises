package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ReducedStringTest extends HackerRankTest {

    public ReducedStringTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/reduced-string-input.txt", "/hackerrank/reduced-string-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankTestHelper.multiTestCaseWithoutSize(s -> {
            ReducedString.solve(s.next());
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}