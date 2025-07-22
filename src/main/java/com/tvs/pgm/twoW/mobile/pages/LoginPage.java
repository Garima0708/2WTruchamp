package com.tvs.pgm.twoW.mobile.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class LoginPage extends BasePage {

    // Permission pop-up
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private WebElement locationPermissionText;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement locationPermissionWhileUsing;

    // Login screen
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Enter Mobile Number\"]")
    private WebElement enterMobileNumberText;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterMobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Verify Number\"]")
    private WebElement verifyNumberButton;

    @AndroidFindBy(accessibility = "Enter OTP sent to")
    private WebElement verifyEnterOtpText;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement otpField;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Permissions
    public boolean isLocationPermissionPopupDisplayed() {
        return locationPermissionText.isDisplayed();
    }

    public String getLocationPermissionText() {
        return locationPermissionWhileUsing.getText();
    }

    public void allowLocationPermission() {
        locationPermissionWhileUsing.click();
    }

    // Mobile Number screen
    public boolean isEnterMobileNumberDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(enterMobileNumberText));
        return enterMobileNumberText.isDisplayed();
    }

    public void enterMobileNumber(String mobileNumber) {
        enterMobileNumberField.click();
        enterMobileNumberField.clear();
        enterMobileNumberField.sendKeys(mobileNumber);
    }

    public boolean isVerifyNumberButtonEnabled() {
        return verifyNumberButton.isEnabled();
    }

    public void clickVerifyNumberButton() {
        wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        verifyNumberButton.click();
    }
    // OTP screen
    public boolean isOtpScreenDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(verifyEnterOtpText));
        return verifyEnterOtpText.isDisplayed();
    }

    public void clickOtpField() {
        wait.until(ExpectedConditions.visibilityOf(otpField));
        otpField.click();
    }

    public void enterOtp(String otp) {
        wait.until(ExpectedConditions.elementToBeClickable(otpField));
        otpField.click();
        otpField.clear();
        otpField.sendKeys(otp);
    }

    public boolean waitForOtpScreenToDisappear() {
        return wait.until(ExpectedConditions.invisibilityOf(verifyEnterOtpText));
    }
}

    
    // public String verifyPlaceHoldervalue(){
    //     String plcaeholderName=enterMobileNumberField.getAttribute("value");
    //     return plcaeholderName;
    // }

    // public String verifyLaungaugeText(){
    //     String text=laungageDropdown.getText();
    //     return text;
    // }


