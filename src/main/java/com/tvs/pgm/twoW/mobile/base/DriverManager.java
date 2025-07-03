package com.tvs.pgm.twoW.mobile.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {
    private static AndroidDriver driver;

    private DriverManager() {}

    public static void initializeDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options=new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("Samsung SM-A528B");
            options.setAppPackage("com.tvs.tvs_pgm_dev");
            options.setAppActivity("com.tvs_pgm.tvs.MainActivity");
            options.setCapability("dontStopAppOnReset", true);
            options.setCapability("noReset", true);

            driver = new AndroidDriver(URI.create("http://127.0.0.1:4723/wd/hub").toURL(), options);
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
