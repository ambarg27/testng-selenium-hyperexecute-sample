import org.testng.Assert;
import org.testng.annotations.Test;

// TE-27603 C06 (RFC 9.8 P4): cross-GROUP repeated scenario names via matrix.
// The same scenario name (MatrixDup) runs across matrix variants a/b/c; ONLY variant b fails.
// Rerun failed-subset must select exactly the b group by position/combination,
// not every group sharing the name (that is the P4 positional-multiset guarantee).
public class MatrixDupTest {

    @Test(description = "matrixDup")
    public void matrixDup() {
        String v = System.getenv("variant");
        if ("b".equals(v)) {
            Assert.fail("C06 matrix: deterministic failure for variant b (cross-group positional selection)");
        }
    }
}
