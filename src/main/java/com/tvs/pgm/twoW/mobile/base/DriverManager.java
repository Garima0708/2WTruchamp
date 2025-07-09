package com.tvs.pgm.twoW.mobile.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {}

    // Initialize the AndroidDriver only once
    public static void initializeDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("Samsung SM-A528B");
            options.setAppPackage("com.tvs.tvs_pgm_dev");
            options.setAppActivity("com.tvs_pgm.tvs.MainActivity");
            options.setCapability("dontStopAppOnReset", true);
            options.setCapability("noReset", true);

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        }
    }

    // Get the existing driver instance
    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    // Quit the driver and clean up
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}