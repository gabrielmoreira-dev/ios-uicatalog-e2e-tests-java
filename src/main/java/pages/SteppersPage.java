package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SteppersPage extends BasePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][1]")
    private WebElement incrementButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"10\"`]")
    private WebElement textView;

    public SteppersPage(IOSDriver driver) {
        super(driver);
    }

    public void longPressIncrementButton() {
        touchAndHold(incrementButton, 5);
    }

    public void verifyText(String expected) {
        Assert.assertEquals(textView.getText(), expected);
    }
}