import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSBaseTest {
    public IOSDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        String serverURL = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "IOS");
        dc.setCapability("appium:automationName", "XCUITest");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        dc.setCapability("appium:deviceName", "iPhone 15 Pro");
        dc.setCapability("appium:platformVersion", "18.0");

        driver = new IOSDriver(new URL(serverURL), dc);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
