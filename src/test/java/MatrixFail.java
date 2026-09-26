import org.testng.Assert;
import org.testng.annotations.Test;

// TE-27603 C06: always-failing leaf for the matrix positional-selection reproducer.
public class MatrixFail {
    @Test(description = "matrixLeaf")
    public void matrixLeaf() {
        Assert.fail("C06 matrix: deterministic failure for the middle group (cross-group positional selection)");
    }
}
