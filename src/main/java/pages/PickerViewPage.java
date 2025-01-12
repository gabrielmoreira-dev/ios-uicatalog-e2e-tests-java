package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PickerViewPage {
    public PickerViewPage(IOSDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Red color component value")
    private WebElement redPicker;

    @iOSXCUITFindBy(accessibility = "Green color component value")
    private WebElement greenPicker;

    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private WebElement bluePicker;

    public void setRGBColors(String red, String green, String blue) {
        redPicker.sendKeys(red);
        greenPicker.sendKeys(green);
        bluePicker.sendKeys(blue);
    }

    public void verifyRGBColors(String[] expected) {
        Assert.assertEquals(getRGBColors(), expected);
    }

    private String[] getRGBColors() {
        return new String[] { redPicker.getText(), greenPicker.getText(), bluePicker.getText() };
    }
}
