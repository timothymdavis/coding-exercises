package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class KangarooTest extends HackerRankTest {

    public KangarooTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/kangaroo-input.txt", "/hackerrank/kangaroo-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankTestHelper.multiTestCaseWithoutSize(s -> {
            Kangaroo.solve(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}