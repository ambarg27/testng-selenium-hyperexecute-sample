import org.testng.Assert;
import org.testng.annotations.Test;

// TE-27603 C06 (P4): Test_1 fails ONLY on Chrome (reads browser env), passes on Edge.
// So the identical "...=Test_1" name is shared by a FAILED group (Chrome) and a PASSED group (Edge)
// -> failed-subset rerun must select only the Chrome occurrence, not every group named Test_1.
public class Test1 {
    public static String status = "failed";

    @Test(description = "conditional fail test 1")
    public void test1() {
        String b = System.getenv("browser");
        if ("Chrome".equals(b)) {
            Assert.fail("C06: Test_1 fails only on Chrome (browser=" + b + ")");
        }
    }
}
