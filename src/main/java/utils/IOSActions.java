package utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions {
    private final IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }

    public void touchAndHold(WebElement element, int duration) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration", duration);
        driver.executeScript("mobile: touchAndHold", params);
    }
}
