import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class AlertViewTest extends IOSBaseTest {
    @Test
    public void testIOSApp() {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    }
}
