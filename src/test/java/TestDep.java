import org.testng.Assert;
import org.testng.annotations.Test;

// TE-27603 C16-C18 dependent group: depA fails -> depB (depends on depA) is skipped as a DEPENDENT unit.
public class TestDep {
    @Test(description = "dependent-group anchor - always fails")
    public void depA() {
        Assert.fail("TestDep.depA deterministic failure (anchor)");
    }
    @Test(dependsOnMethods = "depA", description = "depends on depA - skipped/dependent when depA fails")
    public void depB() {
        // never runs because depA fails -> recorded as dependent
    }
}
