import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;
    private AppiumDriverLocalService service;

    @BeforeSuite
    protected void startAppium() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @AfterSuite
    protected void stopAppium() {
        service.stop();
    }

    @BeforeClass
    protected void setUpDriver() throws MalformedURLException {
        String serverURL = "http://127.0.0.1:4723";

        XCUITestOptions options = new XCUITestOptions();
        options.setAutomationName("XCUITest");
        options.setApp(System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        options.setPlatformName("IOS");
        options.setPlatformVersion("18.0");
        options.setDeviceName("iPhone 15 Pro");

        driver = new IOSDriver(new URL(serverURL), options);
    }

    @AfterClass
    protected void dispose() {
        driver.quit();
    }
}