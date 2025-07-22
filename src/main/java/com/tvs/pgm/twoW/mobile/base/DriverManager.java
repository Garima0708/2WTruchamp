package com.tvs.pgm.twoW.mobile.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Singleton pattern for AndroidDriver using Appium Java Client v8+.
 * AndroidDriver is no longer generic—Appium returns WebElement by default. :contentReference[oaicite:1]{index=1}
 */
public class DriverManager {

    private static AndroidDriver driver;  // no generics allowed in Appium v8+

    private DriverManager() {}  // prevent instantiation

    public static void initializeDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setDeviceName("Samsung SM-A528B")
                    .setAppPackage("com.tvs.tvs_pgm_dev")
                    .setAppActivity("com.tvs_pgm.tvs.MainActivity")
                    .noReset();

            // Set dontStopAppOnReset correctly via capability
            options.setCapability("appium:dontStopAppOnReset", true);  // optional, default false :contentReference[oaicite:2]{index=2}

            // Use base URL without /wd/hub for Appium v2
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

            // Optional: Implicit wait
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized; call initializeDriver() first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
