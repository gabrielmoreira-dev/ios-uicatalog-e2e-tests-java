import org.testng.annotations.*;
import pages.AlertViewPage;
import pages.HomePage;

public class AlertViewTest extends IOSBaseTest {
    private AlertViewPage page;

    @BeforeMethod
    private void setUp() {
        page = new HomePage(driver).openAlertViewsPage();
    }

    @AfterMethod
    private void tearDown() {
        page = null;
    }

    @Test
    void testClickOnAlertView() {
        page.setText("Hello World");
    }

    @Test
    void testClickOnClickCancelView() {
        page.openConfirmationAlert();
        page.verifyConfirmationText("A message should be a short, complete sentence.");
    }
}