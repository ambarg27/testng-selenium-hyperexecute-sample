import org.testng.annotations.Test;

// TE-27603 C06: deterministic PASS (no browser/hub) so Test_2 matrix groups pass while Test_1 groups fail.
public class Test2 {
    public static String status = "passed";

    @Test(description = "deterministic pass test 2")
    public void test2() {
        // no assertion -> always passes
    }
}
