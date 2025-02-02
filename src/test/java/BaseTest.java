import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    protected AppiumDriver driver;
    protected HomePage homePage;
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
        homePage = new HomePage(driver);
    }

    @AfterClass
    protected void dispose() {
        driver.quit();
    }

    protected List<HashMap<String, String>> getJsonData(String file) throws IOException {
        String jsonContent = FileUtils.readFileToString(
                new File(System.getProperty("user.dir") + "//src//test//resources//" + file + ".json"),
                StandardCharsets.UTF_8
        );
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<>() {
        });
    }
}