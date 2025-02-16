package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActionHandler {
    private final AppiumDriver driver;

    public IOSActionHandler(AppiumDriver driver) {
        this.driver = driver;
    }

    public void touchAndHold(WebElement element, int duration) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", duration);
        driver.executeScript("mobile: touchAndHold", params);
    }
}