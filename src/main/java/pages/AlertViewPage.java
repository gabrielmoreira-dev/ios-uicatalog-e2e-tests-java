package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AlertViewPage extends BasePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Text Entry\"`]")
    private WebElement textEntryItem;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    private WebElement textField;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okButton;

    @iOSXCUITFindBy(accessibility = "Confirm / Cancel")
    private WebElement confirmationItem;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmationTextView;

    @iOSXCUITFindBy(accessibility = "Cancel")
    private WebElement cancelButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")
    private WebElement backButton;

    public AlertViewPage(AppiumDriver driver) {
        super(driver);
    }

    public void entryText(String value) {
        textEntryItem.click();
        textField.sendKeys(value);
        okButton.click();
    }

    public void openConfirmationAlert() {
        confirmationItem.click();
    }

    public void verifyConfirmationText(String expected) {
        Assert.assertEquals(confirmationTextView.getText(), expected);
    }

    public void dispose() {
        try {
            cancelButton.click();
        } catch (Exception ignored) {
        }
        backButton.click();
    }
}