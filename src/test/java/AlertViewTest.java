import org.testng.annotations.*;
import pages.AlertViewPage;
import pages.HomePage;

public class AlertViewTest extends IOSBaseTest {
    private AlertViewPage sut;

    @BeforeMethod
    private void setUp() {
        sut = new HomePage(driver).openAlertViewPage();
    }

    @AfterMethod
    private void tearDown() {
        sut = null;
    }

    @Test
    void testClickOnAlertView() {
        sut.entryText("Hello World");
    }

    @Test
    void testClickOnClickCancelView() {
        sut.openConfirmationAlert();
        sut.verifyConfirmationText("A message should be a short, complete sentence.");
    }
}