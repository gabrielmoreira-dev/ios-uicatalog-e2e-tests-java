import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PickerViewTest extends IOSBaseTest {
    @Test
    void testPickerView() {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        WebElement redPicker = driver.findElement(AppiumBy.accessibilityId("Red color component value"));
        WebElement greenPicker = driver.findElement(AppiumBy.accessibilityId("Green color component value"));
        WebElement bluePicker = driver.findElement(AppiumBy.accessibilityId("Blue color component value"));

        redPicker.sendKeys("80");
        greenPicker.sendKeys("220");
        bluePicker.sendKeys("105");

        Assert.assertEquals(redPicker.getText(), "80");
        Assert.assertEquals(greenPicker.getText(), "220");
        Assert.assertEquals(bluePicker.getText(), "105");
    }
}
