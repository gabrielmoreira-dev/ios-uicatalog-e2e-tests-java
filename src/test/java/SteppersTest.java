import org.testng.annotations.Test;
import pages.HomePage;
import pages.SteppersPage;

public class SteppersTest extends IOSBaseTest {
    @Test
    void testLongPress() {
        SteppersPage page = new HomePage(driver).openSteppersPage();
        page.longPressIncrementButton();
        page.verifyText("10");
    }
}
