package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActions;

public class SteppersPage {
    private final IOSActions iOSActions;

    public SteppersPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.iOSActions = new IOSActions(driver);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Increment\"`][1]")
    private WebElement incrementButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"10\"`]")
    private WebElement textView;

    public void touchAndHoldIncrementButton() {
        iOSActions.touchAndHold(incrementButton, 5);
    }

    public String getText() {
        return textView.getText();
    }
}
