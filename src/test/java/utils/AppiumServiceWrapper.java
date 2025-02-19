package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServiceWrapper {
    private static AppiumDriverLocalService instance;

    public static AppiumDriverLocalService getService() {
        if (instance == null) {
            instance = AppiumDriverLocalService.buildDefaultService();
        }
        return instance;
    }
}
