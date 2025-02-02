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
import utils.AppiumService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    private final AppiumDriverLocalService service = AppiumService.getService();
    protected AppiumDriver driver;
    protected HomePage homePage;

    @BeforeSuite
    protected void startAppium() {
        service.start();
    }

    @BeforeClass
    protected void setUpDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setAutomationName("XCUITest");
        options.setApp(System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        options.setPlatformName("IOS");
        options.setPlatformVersion("18.0");
        options.setDeviceName("iPhone 15 Pro");

        driver = new IOSDriver(service.getUrl(), options);
        homePage = new HomePage(driver);
    }

    protected Object[][] getData(String file) throws IOException {
        List<HashMap<String, String>> data = getJsonData(file);
        Object[][] object = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            object[i] = new Object[]{data.get(i)};
        }
        return object;
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

    @AfterClass
    protected void dispose() {
        driver.quit();
    }

    @AfterSuite
    protected void stopAppium() {
        service.stop();
    }
}