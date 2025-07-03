package com.tvs.pgm.twoW.mobile.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private DriverManager() {
        // Prevent instantiation
    }

    public static void initializeDriver() {
        if (driver.get() == null) {
            try {
            	UiAutomator2Options options = new UiAutomator2Options()
            		    .setPlatformName("Android")
            		    .setDeviceName("Samsung SM-A528B")
            		    .setAppPackage("com.tvs.tvs_pgm_dev")
            		    .setAppActivity("com.tvs_pgm.tvs.MainActivity");

            		options.setCapability("dontStopAppOnReset", true);
            		options.setCapability("noReset", true);

                URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
                driver.set(new AndroidDriver(appiumServerUrl, options));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL", e);
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize AndroidDriver", e);
            }
        }
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        AndroidDriver currentDriver = driver.get();
        if (currentDriver != null) {
            currentDriver.quit();
            driver.remove();
        }
    }
}