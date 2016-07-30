package spike.problems.hackerrank;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class EncryptionTest extends HackerRankTest {

    public EncryptionTest(String actual, String expected) {
        super(actual, expected);
    }

    @Parameters
    public static Collection<Object> getParameters() throws IOException {
        TestContext context = getTestContext("/hackerrank/encryption-input.txt", "/hackerrank/encryption-output.txt");

        List<Object> arguments = new ArrayList<>();

        HackerRankBoilerplate.multiTestCaseWithoutSize(s -> {
            Encryption.solve(s.next());
            populateTestArguments(context, arguments);
        });

        return arguments;
    }

}