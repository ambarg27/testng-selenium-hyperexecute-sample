import org.testng.Assert;
import org.testng.annotations.Test;

// TE-27603 C06 (RFC 9.8 P4): single conditional test used by the matrix reproducer.
// Runs in every matrix group under the SAME name; fails ONLY when variant=b (the middle group).
public class MatrixCond {
    @Test(description = "matrixCond")
    public void matrixCond() {
        String v = System.getenv("variant");
        if ("b".equals(v)) {
            Assert.fail("C06 matrix: deterministic failure for variant b (cross-group positional selection)");
        }
    }
}
