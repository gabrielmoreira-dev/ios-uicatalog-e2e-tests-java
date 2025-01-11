import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlertViewPage;
import pages.HomePage;

import java.net.MalformedURLException;

public class AlertViewTest extends IOSBaseTest {
    private AlertViewPage alertViewPage;

    @BeforeClass
    @Override
    public void setUp() throws MalformedURLException {
        super.setUp();
        alertViewPage = new AlertViewPage(driver);
        new HomePage(driver).openAlertViewsPage();
    }

    @AfterClass
    @Override
    public void tearDown() {
        alertViewPage = null;
        super.tearDown();
    }

    @Test
     void testClickOnAlertView() {
        alertViewPage.setText("Hello World");
    }

    @Test
    void testClickOnClickCancelView() {
        alertViewPage.openConfirmationAlert();

        Assert.assertEquals(
            alertViewPage.getConfirmationText(),
            "A message should be a short, complete sentence."
        );
    }
}
