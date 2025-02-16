package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SteppersPage extends BasePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][1]")
    private WebElement incrementButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"10\"`]")
    private WebElement textView;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")
    private WebElement backButton;

    public SteppersPage(AppiumDriver driver) {
        super(driver);
    }

    public void holdIncrementButton() {
        touchAndHold(incrementButton, 5);
    }

    public void verifyValue(String expected) {
        Assert.assertEquals(textView.getText(), expected);
    }

    public void dispose() {
        backButton.click();
    }
}