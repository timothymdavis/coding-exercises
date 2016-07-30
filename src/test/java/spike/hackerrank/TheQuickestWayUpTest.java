package spike.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static spike.hackerrank.HackerRankBoilerplate.nextArray;

@RunWith(Parameterized.class)
public class TheQuickestWayUpTest extends HackerRankTest {

    public TheQuickestWayUpTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/the-quickest-way-up-input.txt", "/hackerrank/the-quickest-way-up-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankBoilerplate.multiTestCase(s -> {
            TheQuickestWayUp.solve(s);
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}