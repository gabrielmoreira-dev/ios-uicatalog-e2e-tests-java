package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;

public class AppiumDriverWrapper {
    private static AppiumDriver instance;

    public static AppiumDriver getDriver(URL serviceURL) {
        if (instance == null) {
            instance = getIOSDriver(serviceURL);
        }
        return instance;
    }

    private static IOSDriver getIOSDriver(URL serviceURL) {
        XCUITestOptions options = new XCUITestOptions();
        options.setAutomationName("XCUITest");
        options.setApp(System.getProperty("user.dir") + "/apps/UIKitCatalog.app");
        options.setPlatformName("IOS");
        options.setPlatformVersion("18.0");
        options.setDeviceName("iPhone 15 Pro");

        return new IOSDriver(serviceURL, options);
    }
}
