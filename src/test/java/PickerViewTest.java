import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PickerViewPage;

public class PickerViewTest extends IOSBaseTest {
    @Test
    void testPickerView() {
        PickerViewPage page = new HomePage(driver).openPickerViewPage();

        page.setRGBColors("80", "220", "105");

        Assert.assertEquals(page.getRGBColors(), new String[] {"80", "220", "105"});
    }
}
