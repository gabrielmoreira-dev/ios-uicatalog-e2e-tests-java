package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViewsItem;

    @iOSXCUITFindBy(accessibility = "Steppers")
    private WebElement steppersItem;

    @iOSXCUITFindBy(accessibility = "Picker View")
    private WebElement pickerViewItem;

    public HomePage(IOSDriver driver) {
        super(driver);
    }

    public AlertViewPage openAlertViewPage() {
        alertViewsItem.click();
        return new AlertViewPage(driver);
    }

    public SteppersPage openSteppersPage() {
        steppersItem.click();
        return new SteppersPage(driver);
    }

    public PickerViewPage openPickerViewPage() {
        pickerViewItem.click();
        return new PickerViewPage(driver);
    }
}