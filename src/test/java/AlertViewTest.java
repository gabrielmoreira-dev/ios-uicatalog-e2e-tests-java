import org.testng.Assert;
import org.testng.annotations.*;
import pages.AlertViewPage;
import pages.HomePage;

public class AlertViewTest extends IOSBaseTest {
    private AlertViewPage alertViewPage;

    @Test
     void testClickOnAlertView() {
        alertViewPage = new AlertViewPage(driver);
        new HomePage(driver).openAlertViewsPage();
        alertViewPage.setText("Hello World");
    }

    @Test
    void testClickOnClickCancelView() {
        alertViewPage = new AlertViewPage(driver);
        new HomePage(driver).openAlertViewsPage();

        alertViewPage.openConfirmationAlert();

        Assert.assertEquals(
            alertViewPage.getConfirmationText(),
            "A message should be a short, complete sentence."
        );
    }
}
