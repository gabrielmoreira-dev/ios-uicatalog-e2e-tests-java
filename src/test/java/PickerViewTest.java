import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PickerViewPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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

    @Test(dataProvider = "getData")
    void testPickerView(HashMap<String, String> input) {
        sut.setRGBColors(input.get("red"), input.get("green"), input.get("blue"));
        sut.verifyRGBColors(new String[]{input.get("red"), input.get("green"), input.get("blue")});
    }

    @DataProvider
    private Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData("picker_data");
        Object[][] object = new Object[3][];
        for (int i = 0; i < data.size(); i++) {
            object[i] = new Object[]{data.get(i)};
        }
        return object;
    }
}