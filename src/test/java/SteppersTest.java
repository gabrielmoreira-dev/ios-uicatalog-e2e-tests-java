import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SteppersPage;

public class SteppersTest extends IOSBaseTest {
    @Test
    void testLongPress() {
        SteppersPage steppersPage = new SteppersPage(driver);
        new HomePage(driver).openSteppersPage();

        steppersPage.incrementValue();

        Assert.assertEquals(steppersPage.getText(), "10");
    }
}
