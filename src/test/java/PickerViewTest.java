import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PickerViewPage;

import java.io.IOException;
import java.util.HashMap;

public class PickerViewTest extends BaseTest {
    private PickerViewPage sut;

    @BeforeMethod
    private void setUp() {
        sut = homePage.openPickerViewPage();
    }

    @AfterMethod
    private void tearDown() {
        sut.dispose();
        sut = null;
    }

    @Test(dataProvider = "getData")
    void testPickerView(HashMap<String, String> input) {
        final String red = input.get("red");
        final String green = input.get("green");
        final String blue = input.get("blue");

        sut.setRGBColors(red, green, blue);

        sut.verifyRGBColors(new String[]{red, green, blue});
    }

    @DataProvider
    private Object[][] getData() throws IOException {
        return getData("picker_data");
    }
}