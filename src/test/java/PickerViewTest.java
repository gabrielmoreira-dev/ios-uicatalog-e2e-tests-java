import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PickerViewPage;

public class PickerViewTest extends BaseTest {
    private PickerViewPage sut;

    @BeforeMethod
    private void setUp() {
        sut = homePage.openPickerViewPage();
    }

    @AfterMethod
    private void tearDown() {
        sut = null;
    }

    @Test
    void testPickerView() {
        sut.setRGBColors("80", "220", "105");
        sut.verifyRGBColors(new String[]{"80", "220", "105"});
    }
}