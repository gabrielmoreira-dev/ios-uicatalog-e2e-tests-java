package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    public void setRedColor(String color) {
        redPicker.sendKeys(color);
    }

    public void setGreenColor(String color) {
        greenPicker.sendKeys(color);
    }

    public void setBlueColor(String color) {
        bluePicker.sendKeys(color);
    }

    public void setRGBColors(String red, String green, String blue) {
        setRedColor(red);
        setGreenColor(green);
        setBlueColor(blue);
    }

    public String getRedColor() {
        return redPicker.getText();
    }

    public String getGreenColor() {
        return greenPicker.getText();
    }

    public String getBlueColor() {
        return bluePicker.getText();
    }

    public String[] getRGBColors() {
        return new String[] { getRedColor(), getGreenColor(), getBlueColor() };
    }
}
