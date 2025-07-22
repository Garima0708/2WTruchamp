package com.tvs.pgm.twoW.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.tvs.pgm.twoW.mobile.base.DriverManager;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import org.openqa.selenium.interactions.PointerInput;

public class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected PointerInput finger;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    }

    public WebElement scrollToElementByDescription(String description) {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector().description(\"" + description + "\"))"
        ));
    }
}