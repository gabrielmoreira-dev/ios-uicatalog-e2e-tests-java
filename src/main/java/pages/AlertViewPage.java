package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AlertViewPage extends BasePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
    private WebElement textEntry;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    private WebElement textField;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okButton;

    @iOSXCUITFindBy(accessibility = "Confirm / Cancel")
    private WebElement confirmationAlert;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmationTextView;

    public AlertViewPage(IOSDriver driver) {
        super(driver);
    }

    public void setText(String value) {
        textEntry.click();
        textField.sendKeys(value);
        okButton.click();
    }

    public void openConfirmationAlert() {
        confirmationAlert.click();
    }

    public void verifyConfirmationText(String expected) {
        Assert.assertEquals(confirmationTextView.getText(), expected);
    }
}