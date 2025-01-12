package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertViewPage {
    public AlertViewPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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
