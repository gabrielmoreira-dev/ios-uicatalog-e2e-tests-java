import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SteppersTest extends IOSBaseTest {
    @Test
    void testLongPress() {
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][1]"));
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", 5);

        driver.executeScript("mobile: touchAndHold", params);
        String text = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"10\"`]")).getText();

        Assert.assertEquals(text, "10");
    }
}
