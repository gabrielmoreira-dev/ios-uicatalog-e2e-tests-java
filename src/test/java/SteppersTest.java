import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SteppersPage;

public class SteppersTest extends BaseTest {
    private SteppersPage sut;

    @BeforeMethod
    private void setUp() {
        sut = homePage.openSteppersPage();
    }

    @AfterMethod
    private void tearDown() {
        sut.dispose();
        sut = null;
    }

    @Test
    void testLongPress() {
        sut.holdIncrementButton();
        sut.verifyValue("10");
    }
}