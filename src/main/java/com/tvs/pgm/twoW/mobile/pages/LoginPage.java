package com.tvs.pgm.twoW.mobile.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoginPage handles login and permission flows.
 */
public class LoginPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    private final ExtentTest test;

    // 📌 Permission pop-up elements
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private WebElement locationPermissionText;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement locationPermissionWhileUsing;

    // 📌 Login screen elements
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Enter Mobile Number\"]")
    private WebElement enterMobileNumberText;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterMobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Verify Number\"]")
    private WebElement verifyNumberButton;

    // 📌 OTP screen elements
    @AndroidFindBy(accessibility = "Enter OTP sent to")
    private WebElement verifyEnterOtpText;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement otpField;

    // Constructor with ExtentTest injection
    public LoginPage(ExtentTest test) {
        super(); // Ensure BasePage initializes `wait` before using it
        this.test = test;
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this); // now safe
    }
    // 🟡 Permission Methods

    public boolean isLocationPermissionPopupDisplayed() {
        try {
            return locationPermissionText.isDisplayed();
        } catch (Exception e) {
            log.warn("Location permission popup not displayed: {}", e.getMessage());
            return false;
        }
    }

    public String getLocationPermissionText() {
        try {
            return locationPermissionWhileUsing.getText();
        } catch (Exception e) {
            log.error("Failed to get location permission text: {}", e.getMessage());
            return null;
        }
    }

    public void allowLocationPermission() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locationPermissionWhileUsing));
            locationPermissionWhileUsing.click();
            log.info("Location permission allowed.");
            if (test != null) test.log(Status.INFO, "✅ Location permission allowed.");
        } catch (Exception e) {
            log.error("Failed to click location permission: {}", e.getMessage());
            if (test != null) test.log(Status.WARNING, "❌ Failed to click location permission: " + e.getMessage());
        }
    }

    // 🔢 Mobile Number Screen

    public boolean isEnterMobileNumberDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(enterMobileNumberText));
            boolean visible = enterMobileNumberText.isDisplayed();
            log.info("Mobile number screen visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.error("Mobile number screen not displayed: {}", e.getMessage());
            if (test != null) test.log(Status.FAIL, "❌ Mobile number screen not displayed: " + e.getMessage());
            return false;
        }
    }

    public void enterMobileNumber(String mobileNumber) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(enterMobileNumberField));
            enterMobileNumberField.click();
            enterMobileNumberField.clear();
            enterMobileNumberField.sendKeys(mobileNumber);
            log.info("Entered mobile number: {}", mobileNumber);
            if (test != null) test.log(Status.INFO, "📱 Entered mobile number: " + mobileNumber);
        } catch (Exception e) {
            log.error("Failed to enter mobile number: {}", e.getMessage());
            if (test != null) test.log(Status.FAIL, "❌ Failed to enter mobile number: " + e.getMessage());
        }
    }

    public boolean isVerifyNumberButtonEnabled() {
        try {
            return verifyNumberButton.isEnabled();
        } catch (Exception e) {
            log.error("Verify button status check failed: {}", e.getMessage());
            return false;
        }
    }

    public void clickVerifyNumberButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
            verifyNumberButton.click();
            log.info("Clicked verify number button.");
            if (test != null) test.log(Status.INFO, "✅ Clicked verify number button.");
        } catch (Exception e) {
            log.error("Failed to click verify number button: {}", e.getMessage());
            if (test != null) test.log(Status.FAIL, "❌ Failed to click verify number button: " + e.getMessage());
        }
    }

    // 🔐 OTP Handling

    public boolean isOtpScreenDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(verifyEnterOtpText));
            boolean visible = verifyEnterOtpText.isDisplayed();
            log.info("OTP screen visible: {}", visible);
            return visible;
        } catch (Exception e) {
            log.error("OTP screen not displayed: {}", e.getMessage());
            if (test != null) test.log(Status.FAIL, "❌ OTP screen not displayed: " + e.getMessage());
            return false;
        }
    }

    public void clickOtpField() {
        try {
            wait.until(ExpectedConditions.visibilityOf(otpField));
            otpField.click();
            log.info("OTP field clicked.");
            if (test != null) test.log(Status.INFO, "🟢 OTP field clicked.");
        } catch (Exception e) {
            log.error("Failed to click OTP field: {}", e.getMessage());
            if (test != null) test.log(Status.FAIL, "❌ Failed to click OTP field: " + e.getMessage());
        }
    }

    public void enterOtp(String otp) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(otpField));
            otpField.click();
            otpField.clear();
            otpField.sendKeys(otp);
            log.info("Entered OTP: {}", otp);
            if (test != null) test.log(Status.INFO, "🔢 Entered OTP: " + otp);
        } catch (Exception e) {
            log.error("Failed to enter OTP: {}", e.getMessage());
            if (test != null) test.log(Status.FAIL, "❌ Failed to enter OTP: " + e.getMessage());
        }
    }

    public boolean waitForOtpScreenToDisappear() {
        try {
            boolean disappeared = wait.until(ExpectedConditions.invisibilityOf(verifyEnterOtpText));
            log.info("OTP screen disappeared: {}", disappeared);
            return disappeared;
        } catch (Exception e) {
            log.error("OTP screen did not disappear: {}", e.getMessage());
            if (test != null) test.log(Status.WARNING, "⚠️ OTP screen did not disappear: " + e.getMessage());
            return false;
        }
    }
}