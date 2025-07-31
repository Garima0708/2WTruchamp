package com.tvs.pgm.twoW.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tvs.pgm.twoW.mobile.listeners.TestListener;
import com.tvs.pgm.twoW.mobile.pages.LoginPage;
import com.tvs.pgm.twoW.mobile.utils.ExtentReportManager;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass(alwaysRun = true)
    public void setupPage() {
        extent = ExtentReportManager.getInstance();
        test = extent.createTest("Login Test Suite");
        loginPage = new LoginPage(test);  // Pass ExtentTest to page
    }

    @Test(priority = 1)
    public void verifyLocationPermissionPopupDisplayed() {
        test.info("Checking if location permission popup is displayed");
        Assert.assertTrue(loginPage.isLocationPermissionPopupDisplayed(), "❌ Location permission popup not displayed.");
    }

    @Test(priority = 2)
    public void verifyLocationPermissionText() {
        test.info("Verifying location permission text");
        String actualText = loginPage.getLocationPermissionText();
        Assert.assertEquals(actualText, "While using the app", "❌ Location permission text mismatch.");
    }

    @Test(priority = 3)
    public void allowLocationPermission() {
        test.info("Allowing location permission");
        loginPage.allowLocationPermission();
    }

    @Test(priority = 4)
    public void verifyEnterMobileNumberFieldDisplayed() {
        test.info("Verifying mobile number field is displayed");
        Assert.assertTrue(loginPage.isEnterMobileNumberDisplayed(), "❌ Mobile number input field not displayed.");
    }

    @Test(priority = 5)
    public void verifyInvalidMobileNumberBlocked() {
        test.info("Testing invalid mobile number");
        loginPage.enterMobileNumber("1234567");
        Assert.assertFalse(loginPage.isVerifyNumberButtonEnabled(), "❌ Verify button should be disabled for invalid number.");
    }

    @Test(priority = 6)
    public void enterValidMobileNumber() {
        test.info("Entering valid mobile number");
        loginPage.enterMobileNumber("6100000016");
        Assert.assertTrue(loginPage.isVerifyNumberButtonEnabled(), "❌ Verify button should be enabled for valid number.");
    }

    @Test(priority = 7)
    public void clickVerifyNumberButton() {
        test.info("Clicking verify number button");
        loginPage.clickVerifyNumberButton();
    }

    @Test(priority = 8)
    public void verifyOtpScreenDisplayed() {
        test.info("Verifying OTP screen displayed");
        Assert.assertTrue(loginPage.isOtpScreenDisplayed(), "❌ OTP screen is not displayed.");
    }

    @Test(priority = 9)
    public void clickOtpField() {
        test.info("Clicking OTP field");
        loginPage.clickOtpField();
    }

    @Test(priority = 10)
    public void enterOtp() {
        test.info("Entering OTP");
        loginPage.enterOtp("54321");
    }
}
