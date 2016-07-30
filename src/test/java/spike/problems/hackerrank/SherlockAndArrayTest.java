package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static spike.problems.hackerrank.HackerRankTestHelper.nextArray;

@RunWith(Parameterized.class)
public class SherlockAndArrayTest extends HackerRankTest {

    public SherlockAndArrayTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/sherlock-and-array-input.txt", "/hackerrank/sherlock-and-array-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankTestHelper.multiTestCase(s -> {
            SherlockAndArray.solve(nextArray(s.nextInt(), s::nextLong, Long[]::new));
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}