import org.testng.annotations.*;
import pages.AlertViewPage;
import pages.HomePage;

public class AlertViewTest extends IOSBaseTest {
    private AlertViewPage page;

    @Test
     void testClickOnAlertView() {
        page = new HomePage(driver).openAlertViewsPage();
        page.setText("Hello World");
    }

    @Test
    void testClickOnClickCancelView() {
        page = new HomePage(driver).openAlertViewsPage();
        page.openConfirmationAlert();
        page.verifyConfirmationText("A message should be a short, complete sentence.");
    }
}
