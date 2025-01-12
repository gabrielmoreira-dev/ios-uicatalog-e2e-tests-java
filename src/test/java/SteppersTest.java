import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SteppersPage;

public class SteppersTest extends IOSBaseTest {
    private SteppersPage page;

    @BeforeMethod
    private void setUp() {
        page = new HomePage(driver).openSteppersPage();
    }

    @AfterMethod
    private void tearDown() {
        page = null;
    }

    @Test
    void testLongPress() {
        page.longPressIncrementButton();
        page.verifyText("10");
    }
}