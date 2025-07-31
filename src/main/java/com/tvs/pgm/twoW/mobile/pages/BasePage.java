package com.tvs.pgm.twoW.mobile.pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;

public class BasePage {

    // ✅ Changed from private to protected so child classes can access
    protected final AppiumDriver driver;
    protected final WebDriverWait wait;

    public BasePage() {
        AppiumDriver localDriver = null;
        WebDriverWait localWait = null;
        try {
            localDriver = com.tvs.pgm.twoW.mobile.base.DriverManager.getDriver();
            localWait = new WebDriverWait(localDriver, Duration.ofSeconds(20));
        } catch (Exception e) {
            System.err.println("Failed to initialize driver in BasePage: " + e.getMessage());
        }
        this.driver = localDriver;
        this.wait = localWait;
    }

    /**
     * Get the driver instance (if needed externally).
     */
    public AppiumDriver getDriver() {
        return this.driver;
    }
    public WebElement scrollToElementByAccessibilityId(String accessibilityId) {
        try {
            if (driver == null) {
                throw new IllegalStateException("Driver is not initialized.");
            }

            String platform = driver.getCapabilities().getPlatformName().toString().toLowerCase();
            System.out.println("🔍 Detected platform: " + platform);

            if ("android".equals(platform)) {
                return driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                    + "new UiSelector().description(\"" + accessibilityId + "\"));"
                ));
            } else if ("ios".equals(platform)) {
                Map<String, Object> scrollObject = new HashMap<>();
                scrollObject.put("direction", "down");
                scrollObject.put("predicateString", "name == '" + accessibilityId + "'");
                ((JavascriptExecutor) driver).executeScript("mobile: scroll", scrollObject);

                return driver.findElement(AppiumBy.accessibilityId(accessibilityId));
            } else {
                throw new UnsupportedOperationException("Unsupported platform for scroll: " + platform);
            }

        } catch (Exception e) {
            System.err.println("❌ Failed to scroll to element with accessibilityId '" + accessibilityId + "': " + e.getMessage());
            return null;
        }
    }
    public boolean scrollDown() {
        try {
            String platform = driver.getCapabilities().getPlatformName().toString().toLowerCase();
            Map<String, Object> params = new HashMap<>();

            if ("android".equals(platform)) {
                // Basic fallback coordinates if "viewportRect" is unavailable
                params.put("left", 100);
                params.put("top", 100);
                params.put("width", 500);
                params.put("height", 1000);
                params.put("direction", "down");
                params.put("percent", 0.8);

                ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);

            } else if ("ios".equals(platform)) {
                params.put("direction", "down");
                ((JavascriptExecutor) driver).executeScript("mobile: scroll", params);

            } else {
                throw new UnsupportedOperationException("Unsupported platform: " + platform);
            }

            System.out.println("✅ Scrolled down");
            return true;

        } catch (Exception e) {
            System.err.println("❌ Scroll down failed: " + e.getMessage());
            return false;
        }
    }
}  