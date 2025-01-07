import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertViewTest extends IOSBaseTest {
    @Test
     void testClickOnAlertView() {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField")).sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
    }

    @Test
    void testClickOnClickCancelView() {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

        driver.findElement(AppiumBy.accessibilityId("Confirm / Cancel")).click();
        WebElement textView = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'"));

        Assert.assertEquals(textView.getText(), "A message should be a short, complete sentence.");
    }
}
