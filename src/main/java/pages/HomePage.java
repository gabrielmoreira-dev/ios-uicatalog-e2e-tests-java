package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViewsItem;

    @iOSXCUITFindBy(accessibility = "Steppers")
    private WebElement steppersItem;

    public void openAlertViewsPage() {
        alertViewsItem.click();
    }

    public void openSteppersPage() {
        steppersItem.click();
    }
}
