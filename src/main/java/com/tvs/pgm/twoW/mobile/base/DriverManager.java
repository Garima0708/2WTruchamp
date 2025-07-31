package com.tvs.pgm.twoW.mobile.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

import com.tvs.pgm.twoW.mobile.utils.ConfigReader;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private DriverManager() {}

    public static void initializeDriver() throws MalformedURLException {
        // If driver is already initialized, skip
        if (driver.get() != null) return;

        String platformRaw = ConfigReader.getPlatform();

        if (platformRaw == null || platformRaw.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Platform is null or empty. Please check your config.");
        }

        String platform = platformRaw.trim().toLowerCase();
        System.out.println("🔍 Platform from ConfigReader: '" + platform + "'");

        String appiumServerUrl = ConfigReader.getProperty("appiumServerUrl");
        if (appiumServerUrl == null || appiumServerUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Appium Server URL is null or empty. Check your config.");
        }

        switch (platform) {
            case "android":
                UiAutomator2Options androidOptions = new UiAutomator2Options()
                    .setDeviceName(getRequiredProperty("deviceName"))
                    .setAppPackage(getRequiredProperty("appPackage"))
                    .setAppActivity(getRequiredProperty("appActivity"))
                    .setNoReset(true)
                    .amend("dontStopAppOnReset", true);

                driver.set(new AndroidDriver(new URL(appiumServerUrl), androidOptions));
                break;

            case "ios":
                XCUITestOptions iosOptions = new XCUITestOptions()
                    .setDeviceName(getRequiredProperty("iosDeviceName"))
                    .setPlatformVersion(getRequiredProperty("iosPlatformVersion"))
                    .setUdid(getRequiredProperty("udid"))
                    .setNoReset(true);

                String iosAppPath = ConfigReader.getProperty("iosAppPath");
                String bundleId = ConfigReader.getProperty("bundleId");

                if (iosAppPath != null && !iosAppPath.trim().isEmpty()) {
                    iosOptions.setApp(iosAppPath.trim());
                } else if (bundleId != null && !bundleId.trim().isEmpty()) {
                    iosOptions.setBundleId(bundleId.trim());
                } else {
                    throw new IllegalArgumentException("❌ Both iosAppPath and bundleId are missing. Provide at least one in config.");
                }

                driver.set(new IOSDriver(new URL(appiumServerUrl), iosOptions));
                break;

            default:
                throw new IllegalArgumentException("❌ Unsupported platform: " + platform);
        }
    }

    // Helper method to get required property and fail fast if missing or empty
    private static String getRequiredProperty(String key) {
        String value = ConfigReader.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Required property '" + key + "' is missing or empty in config.");
        }
        return value.trim();
    }

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver not initialized. Call initializeDriver() first.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}