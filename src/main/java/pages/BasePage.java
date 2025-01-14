package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActionHandler;

public class BasePage {
    private final IOSActionHandler actionHandler;
    protected final AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.actionHandler = new IOSActionHandler(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void touchAndHold(WebElement element, int duration) {
        actionHandler.touchAndHold(element, duration);
    }
}
