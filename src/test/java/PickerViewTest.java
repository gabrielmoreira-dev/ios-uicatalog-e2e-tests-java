import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PickerViewPage;

public class PickerViewTest extends IOSBaseTest {
    private PickerViewPage page;

    @BeforeMethod
    private void setUp() {
        page = new HomePage(driver).openPickerViewPage();
    }

    @AfterMethod
    private void tearDown() {
        page = null;
    }

    @Test
    void testPickerView() {
        page.setRGBColors("80", "220", "105");
        page.verifyRGBColors(new String[] {"80", "220", "105"});
    }
}