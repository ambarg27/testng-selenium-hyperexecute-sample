import org.testng.Assert;
import org.testng.annotations.Test;

// TE-27603 rerun testing: Test_1 fails DETERMINISTICALLY (no browser dependency).
public class Test1 {
    public static String status = "failed";

    @Test(description = "deterministic rerun test 1 - always fails")
    public void test1() {
        Assert.fail("Test_1 deterministic failure for TE-27603 rerun testing");
    }
}
