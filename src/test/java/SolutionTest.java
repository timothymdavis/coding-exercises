import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import spike.problems.hackerrank.HackerRankTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest extends HackerRankTest {

    public SolutionTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> setUpScanners() throws IOException {
        TestContext testContext = getTestContext("/hackerrank/test-input.txt", "/hackerrank/test-output.txt");

        List<Object> arguments = new ArrayList<>();
        Solution.Boilerplate.singleTestCase(s -> {
            Solution.solve(s.nextInt());
            String actualLine = testContext.getActualScanner().nextLine();
            String expectedLine = testContext.getExpectedScanner().nextLine();
            arguments.add(new String[]{actualLine, expectedLine});
        });

        return arguments;
    }

}
