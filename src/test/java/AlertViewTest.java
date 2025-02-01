import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertViewPage;
import pages.HomePage;

public class AlertViewTest extends BaseTest {
    private AlertViewPage sut;

    @BeforeMethod
    private void setUp() {
        sut = new HomePage(driver).openAlertViewPage();
    }

    @AfterMethod
    private void tearDown() {
        sut.dispose();
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