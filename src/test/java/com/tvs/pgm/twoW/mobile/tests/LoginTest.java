package com.tvs.pgm.twoW.mobile.tests;

import java.net.MalformedURLException;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tvs.pgm.twoW.mobile.pages.LoginPage;
import com.tvs.pgm.twoW.mobile.base.DriverManager;
import com.tvs.pgm.twoW.mobile.listeners.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DriverManager.initializeDriver();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void verifyLocationPermissionPopup() {
        Assert.assertTrue(loginPage.isLocationPermissionPopupDisplayed(), "Location permission popup not displayed.");
    }

    @Test(priority = 2)
    public void verifyLocationPermissionOptionText() {
        Assert.assertEquals(loginPage.getLocationPermissionText(), "While using the app", "Permission option text mismatch.");
    }

    @Test(priority = 3)
    public void allowLocationPermission() {
        loginPage.allowLocationPermission();
    }

    @Test(priority = 4)
    public void verifyMobileNumberFieldDisplayed() {
        Assert.assertTrue(loginPage.isEnterMobileNumberDisplayed(), "Mobile number input field not displayed.");
    }

    @Test(priority = 5)
    public void verifyInvalidMobileNumberBlocked() {
        loginPage.enterMobileNumber("1234567");
        Assert.assertFalse(loginPage.isVerifyNumberButtonEnabled(), "Verify button should be disabled for invalid number.");
    }

    @Test(priority = 6)
    public void enterValidMobileNumber() {
        loginPage.enterMobileNumber("7100000508");
        Assert.assertTrue(loginPage.isVerifyNumberButtonEnabled(), "Verify button should be enabled for valid number.");
    }

    @Test(priority = 7)
    public void clickVerifyNumberButton() {
        loginPage.clickVerifyNumberButton();
    }

    @Test(priority = 8)
    public void verifyOtpScreenDisplayed() {
        Assert.assertTrue(loginPage.isOtpScreenDisplayed(), "OTP screen is not displayed.");
    }

    @Test(priority = 9)
    public void clickOtpField() {
        loginPage.clickOtpField();
    }

    @Test(priority = 10)
    public void enterOtp() {
        loginPage.enterOtp("54321");
    }
}
