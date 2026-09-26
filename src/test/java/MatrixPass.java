import org.testng.annotations.Test;

// TE-27603 C06: always-passing leaf for the matrix positional-selection reproducer.
public class MatrixPass {
    @Test(description = "matrixLeaf")
    public void matrixLeaf() {
        // no assertion -> always passes
    }
}
