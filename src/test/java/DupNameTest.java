import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// TE-27603 C06 (RFC 9.8 P4): repeated scenario names / positional multiset.
// dupScenario runs 3 times (same scenario name); ONLY the middle invocation (row 1) fails.
// Rerun failed-subset must select exactly that one occurrence by position (groupNumber, indexInTask),
// not every scenario sharing the name.
public class DupNameTest {

    @DataProvider(name = "rows")
    public Object[][] rows() {
        return new Object[][] { {0, false}, {1, true}, {2, false} };
    }

    @Test(dataProvider = "rows", description = "dupScenario")
    public void dupScenario(int idx, boolean shouldFail) {
        if (shouldFail) {
            Assert.fail("C06 deterministic failure at data row " + idx + " (positional selection)");
        }
    }
}
