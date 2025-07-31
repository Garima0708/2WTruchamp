package com.tvs.pgm.twoW.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tvs.pgm.twoW.mobile.listeners.TestListener;
import com.tvs.pgm.twoW.mobile.pages.SettingsPage;

@Listeners(TestListener.class)
public class SettingsTest extends BaseTest{
	
	private  SettingsPage settingsPage;

	 @BeforeClass(alwaysRun = true)
	    public void setupPage() {
		 settingsPage = new SettingsPage(); // Initialize your page object only
	    }
    
	 @Test(priority = 1, description = "Verify Settings icon is displayed")
	    public void testVerifySettingIconPresent() {
	        Assert.assertTrue(settingsPage.verifySettingIconPresent(), "❌ Settings icon is not present.");
	    }

	    @Test(priority = 2, description = "Click on Settings icon")
	    public void testClickSettingsIcon() {
	        Assert.assertTrue(settingsPage.clickSettingsIcon(), "❌ Failed to click on Settings icon.");
	    }

	    @Test(priority = 3, description = "Verify Fingerprint Authentication toggle presence")
	    public void testFingerprintTogglePresence() {
	        Assert.assertTrue(settingsPage.isFingerprintTogglePresent(), "❌ Fingerprint Authentication toggle not found.");
	    }

	    @Test(priority = 4, description = "Click Fingerprint Authentication toggle")
	    public void testClickFingerprintToggle() {
	        Assert.assertTrue(settingsPage.clickFingerprintToggle(), "❌ Failed to click on Fingerprint toggle.");
	    }

	    @Test(priority = 5, description = "Verify Passcode Settings presence")
	    public void testPasscodeSettingsPresence() {
	        Assert.assertTrue(settingsPage.isPasscodeSettingPresent(), "❌ Passcode Settings not found.");
	    }

	    @Test(priority = 6, description = "Click Passcode Settings")
	    public void testClickPasscodeSettings() {
	        Assert.assertTrue(settingsPage.clickPasscodeSetting(), "❌ Failed to click Passcode Settings.");
	    }

	    @Test(priority = 7, description = "Verify Passcode toggle presence")
	    public void testPasscodeTogglePresence() {
	        Assert.assertTrue(settingsPage.isPasscodeTogglePresent(), "❌ Passcode toggle not found.");
	    }

	    @Test(priority = 8, description = "Click Passcode toggle")
	    public void testClickPasscodeToggle() {
	        Assert.assertTrue(settingsPage.clickPasscodeToggle(), "❌ Failed to click Passcode toggle.");
	    }

	    @Test(priority = 9, description = "Verify Enter Passcode field presence")
	    public void testEnterPasscodeDisplayed() {
	        Assert.assertTrue(settingsPage.isEnterPasscodeDisplayed(), "❌ Enter Passcode field not displayed.");
	    }

	    @Test(priority = 10, description = "Verify Confirm Passcode field presence")
	    public void testConfirmPasscodeDisplayed() {
	        Assert.assertTrue(settingsPage.isConfirmPasscodeDisplayed(), "❌ Confirm Passcode field not displayed.");
	    }

	    @Test(priority = 11, description = "Verify Select Passcode Question presence")
	    public void testSelectPasscodeQuestionDisplayed() {
	        Assert.assertTrue(settingsPage.isSelectPasscodeQuestionDisplayed(), "❌ Select Passcode Question not displayed.");
	    }

	    @Test(priority = 12, description = "Verify Enter Passcode Answer field presence")
	    public void testEnterPasscodeAnswerDisplayed() {
	        Assert.assertTrue(settingsPage.isEnterPasscodeAnswerDisplayed(), "❌ Enter Passcode Answer field not displayed.");
	    }

	    @Test(priority = 13, description = "Verify Submit Passcode button presence")
	    public void testSubmitPasscodeDisplayed() {
	        Assert.assertTrue(settingsPage.isSubmitPasscodeDisplayed(), "❌ Submit Passcode button not displayed.");
	    }

	    @Test(priority = 14, description = "Verify Back to Passcode Settings Page button presence")
	    public void testBackToPasscodeSettingsPageDisplayed() {
	        Assert.assertTrue(settingsPage.isBackToPasscodeSettingsPageDisplayed(), "❌ Back to Passcode Settings Page button not displayed.");
	    }

	    @Test(priority = 15, description = "Verify Back to Settings Page button presence")
	    public void testBackToSettingsPageDisplayed() {
	        Assert.assertTrue(settingsPage.isBackToSettingsPageDisplayed(), "❌ Back to Settings Page button not displayed.");
	    }

	    @Test(priority = 16, description = "Verify Select Language option presence")
	    public void testSelectLanguageDisplayed() {
	        Assert.assertTrue(settingsPage.isSelectLanguageDisplayed(), "❌ Select Language option not displayed.");
	    }

	    @Test(priority = 17, description = "Verify Privacy Policy presence")
	    public void testPrivacyPolicyDisplayed() {
	        Assert.assertTrue(settingsPage.isPrivacyPolicyDisplayed(), "❌ Privacy Policy not displayed.");
	    }

	    @Test(priority = 18, description = "Verify Terms of Use presence")
	    public void testTermsOfUseDisplayed() {
	        Assert.assertTrue(settingsPage.isTermsOfUseDisplayed(), "❌ Terms of Use not displayed.");
	    }

	    @Test(priority = 19, description = "Print and verify App Version text")
	    public void testGetAppVersionText() {
	        String version = settingsPage.getAppVersionText();
	        Assert.assertNotNull(version, "❌ App version text is null or not visible.");
	    }
	    
	    @Test(priority = 20, description = "Verify Delete Account option presence")
	    public void testDeleteAccountDisplayed() {
	        Assert.assertTrue(settingsPage.isDeleteAccountDisplayed(), "❌ Delete Account option not displayed.");
	    }

	    @Test(priority = 21, description = "Verify Enter Delete Reason field presence")
	    public void testEnterDeleteReasonDisplayed() {
	        Assert.assertTrue(settingsPage.isEnterDeleteReasonDisplayed(), "❌ Enter Delete Reason field not displayed.");
	    }

	    @Test(priority = 22, description = "Verify Delete Account button presence")
	    public void testDeleteAccountButtonDisplayed() {
	        Assert.assertTrue(settingsPage.isClickDeleteAccountButtonDisplayed(), "❌ Delete Account button not displayed.");
	    }

}