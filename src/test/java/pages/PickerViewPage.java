package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PickerViewPage extends BasePage {
    @iOSXCUITFindBy(accessibility = "Red color component value")
    private WebElement redPicker;

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private WebElement greenPicker;

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private WebElement bluePicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"UIKitCatalog\"`]")
    private WebElement backButton;

    public PickerViewPage(AppiumDriver driver) {
        super(driver);
    }

    public void setRGBColors(String red, String green, String blue) {
        redPicker.sendKeys(red);
        greenPicker.sendKeys(green);
        bluePicker.sendKeys(blue);
    }

    public void verifyRGBColors(String[] expected) {
        Assert.assertEquals(getRGBColors(), expected);
    }

    public void dispose() {
        backButton.click();
    }

    private String[] getRGBColors() {
        return new String[]{redPicker.getText(), greenPicker.getText(), bluePicker.getText()};
    }
}