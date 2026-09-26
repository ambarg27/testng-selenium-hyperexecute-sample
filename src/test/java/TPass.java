import org.testng.annotations.Test;
// TE-27603 B02: deterministic PASS (no browser). Shares a group with the failing Test_1.
public class TPass {
    @Test(description = "deterministic pass")
    public void tpass() { /* no assertion -> passes */ }
}
