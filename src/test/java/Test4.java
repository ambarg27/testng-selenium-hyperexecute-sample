import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.URL;

// jp10 rerun sample — deterministic. Test_4 always PASSES.
public class Test4 {
    RemoteWebDriver driver = null;
    public static String status = "passed";
    static String username = System.getenv("LT_USERNAME");
    static String access_key = System.getenv("LT_ACCESS_KEY");
    static String hub = System.getenv("LT_HUB_HOST") != null ? System.getenv("LT_HUB_HOST") : "hub.lambdatest.com";
    String page = "data:text/html,<html><head><title>Rerun Sample</title></head><body><h1 id='hdr'>todo</h1></body></html>";

    @BeforeMethod
    @Parameters(value={"browser","version","platform","resolution"})
    public void setUp(String browser, String version, String platform, String resolution) throws Exception {
        String br = System.getProperty("browser", browser);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("build", "[HyperExecute] jp10 Rerun Sample");
        caps.setCapability("name", "Test_4 (" + br + ")");
        caps.setCapability("platform", System.getenv("HYPEREXECUTE_PLATFORM") != null ? System.getenv("HYPEREXECUTE_PLATFORM") : platform);
        caps.setCapability("browserName", br);
        caps.setCapability("version", version);
        caps.setCapability("network", true);
        driver = new RemoteWebDriver(new URL("https://" + username + ":" + access_key + "@" + hub + "/wd/hub"), caps);
    }

    @Test(description="deterministic rerun test 4")
    public void test4() {
        driver.get(page);
        Assert.assertEquals(driver.getTitle(), "Rerun Sample", "page loaded");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try { ((JavascriptExecutor) driver).executeScript("lambda-status=" + status); } catch (Exception e) {}
            driver.quit();
        }
    }
}
