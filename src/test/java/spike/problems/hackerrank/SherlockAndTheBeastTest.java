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
public class SherlockAndTheBeastTest extends HackerRankTest {

    public SherlockAndTheBeastTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/sherlock-and-the-beast-input.txt", "/hackerrank/sherlock-and-the-beast-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankTestHelper.singleTestCase(s -> {
            SherlockAndTheBeast.solution(nextArray(s.nextInt(), s::nextInt, Integer[]::new));
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}