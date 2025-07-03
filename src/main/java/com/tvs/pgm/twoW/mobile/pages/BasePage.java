package com.tvs.pgm.twoW.mobile.pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.tvs.pgm.twoW.mobile.base.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class BasePage {
	

    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected PointerInput finger;
    protected Sequence swipe;

    public BasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        swipe = new Sequence(finger, 0);

}

}
