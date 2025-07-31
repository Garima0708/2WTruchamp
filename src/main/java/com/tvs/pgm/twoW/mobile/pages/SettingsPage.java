package com.tvs.pgm.twoW.mobile.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends BasePage {
	
	  @AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")
	    private WebElement settingIcon;

	    @AndroidFindBy(accessibility = "Enable Fingerprint Authentication")
	    private WebElement fingerPrintAuthentication;

	    @AndroidFindBy(accessibility = "Passcode Settings")
	    private WebElement passcodeSettings;
	    
	    @AndroidFindBy(accessibility = "Enable/Disable")
	    private WebElement passcodeSettingsEnableDisable;
	    
	    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
	    private WebElement enterPasscode;
	    
	    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
	    private WebElement confirmPasscode;
	    
	    @AndroidFindBy(accessibility = "In what city were you born?")
	    private WebElement selectPasscodeQuestion;
	    
	    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")
	    private WebElement enterYourPasscodeAnswer;
	    
	    @AndroidFindBy(accessibility = "Submit")
	    private WebElement submitPasscode;

	    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
	    private WebElement backToPasscodeSettingsPage;
	    
	    @AndroidFindBy(accessibility = " ")
	    private WebElement backToSettingsPage;

	    @AndroidFindBy(accessibility = "Select Language")
	    private WebElement selectLanguage;

	    @AndroidFindBy(accessibility = "Privacy Policy")
	    private WebElement privacyPolicy;
	    
	    @AndroidFindBy(accessibility = "Terms of Use")
	    private WebElement termsOfUse;
	    
	    @AndroidFindBy(accessibility = "App Version\\nV 1.0.5")
	    private WebElement appVersion;

	    
	    @AndroidFindBy(accessibility = "Delete Account")
	    private WebElement deleteAccount;
	    
	    @AndroidFindBy(accessibility = "//android.widget.EditText")
	    private WebElement enterDeleteReason;
	    
	    @AndroidFindBy(accessibility = "//android.widget.Button[@content-desc=\"Delete Account\"]")
	    private WebElement clickDeleteAccount;
	    

	    public SettingsPage() {        
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	    public boolean verifySettingIconPresent(){
	    	try {
		    wait.until(ExpectedConditions.visibilityOf(settingIcon));
		    settingIcon.isDisplayed();
		    System.out.println("setting icon found!");
		    return settingIcon.isDisplayed();
	    	} catch (Exception e) {
	    		System.out.println("Failed to Find settings icon: " + e.getMessage());
	            return false;
	    	}
		    
		    }

	    public boolean clickSettingsIcon() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(settingIcon));
	            settingIcon.click();
	            System.out.println("Clicked on settings icon.");
	            return true;
	        } catch (Exception e) {
	            System.out.println("Failed to click on settings icon: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    

	    public boolean isFingerprintTogglePresent() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(fingerPrintAuthentication));
	            System.out.println("Fingerprint Authentication toggle is present.");
	            return fingerPrintAuthentication.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Fingerprint toggle not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean clickFingerprintToggle() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(fingerPrintAuthentication));
	            String before =  fingerPrintAuthentication.getAttribute("checked");
	    	    System.out.println("Before click, checked: " + before);
	    	    fingerPrintAuthentication.click();
	            System.out.println("Fingerprint Authentication toggle clicked.");
	            String after = fingerPrintAuthentication.getAttribute("checked");
	    	    System.out.println("After click, checked: " + after);
	            return true;
	        } catch (Exception e) {
	            System.out.println("Failed to click fingerprint toggle: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isPasscodeSettingPresent() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(passcodeSettings));
	            System.out.println("Passcode setting is present.");
	            return passcodeSettings.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Passcode setting not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean clickPasscodeSetting() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(passcodeSettings));
	            passcodeSettings.click();
	            System.out.println("Passcode setting clicked.");
	            return true;
	        } catch (Exception e) {
	            System.out.println("Failed to click passcode setting: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isPasscodeTogglePresent() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(passcodeSettingsEnableDisable));
	            System.out.println("Passcode enable/disable toggle is visible.");
	            return passcodeSettingsEnableDisable.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("Passcode toggle not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean clickPasscodeToggle() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(passcodeSettingsEnableDisable));
	            passcodeSettingsEnableDisable.click();
	            System.out.println("Passcode toggle clicked.");
	            return true;
	        } catch (Exception e) {
	            System.out.println("Failed to click passcode toggle: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isEnterPasscodeDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(enterPasscode));
	            System.out.println("✅ Enter Passcode field is present.");
	            return enterPasscode.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Enter Passcode field not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isConfirmPasscodeDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(confirmPasscode));
	            System.out.println("✅ Confirm Passcode field is present.");
	            return confirmPasscode.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Confirm Passcode field not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isSelectPasscodeQuestionDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(selectPasscodeQuestion));
	            System.out.println("✅ Select Passcode Question is present.");
	            return selectPasscodeQuestion.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Select Passcode Question not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isEnterPasscodeAnswerDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(enterYourPasscodeAnswer));
	            System.out.println("✅ Enter Passcode Answer field is present.");
	            return enterYourPasscodeAnswer.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Enter Passcode Answer field not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isSubmitPasscodeDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(submitPasscode));
	            System.out.println("✅ Submit Passcode button is present.");
	            return submitPasscode.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Submit Passcode button not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isBackToPasscodeSettingsPageDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(backToPasscodeSettingsPage));
	            System.out.println("✅ Back to Passcode Settings Page button is present.");
	            return backToPasscodeSettingsPage.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Back to Passcode Settings Page button not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isBackToSettingsPageDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(backToSettingsPage));
	            System.out.println("✅ Back to Settings Page button is present.");
	            return backToSettingsPage.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Back to Settings Page button not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isSelectLanguageDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(selectLanguage));
	            System.out.println("✅ Select Language option is present.");
	            return selectLanguage.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Select Language option not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isPrivacyPolicyDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(privacyPolicy));
	            System.out.println("✅ Privacy Policy is present.");
	            return privacyPolicy.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Privacy Policy not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isTermsOfUseDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(termsOfUse));
	            System.out.println("✅ Terms of Use is present.");
	            return termsOfUse.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Terms of Use not found: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public String getAppVersionText() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(appVersion));
	            String version = appVersion.getAttribute("content-desc");
	            System.out.println("✅ App version: " + version);
	            return version;
	        } catch (Exception e) {
	            System.out.println("❌ Failed to get app version: " + e.getMessage());
	            return null;
	        }
	    }

	    public boolean isDeleteAccountDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(deleteAccount));
	            System.out.println("✅ Delete Account option is present.");
	            return deleteAccount.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Delete Account option not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isEnterDeleteReasonDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(enterDeleteReason));
	            System.out.println("✅ Enter Delete Reason field is present.");
	            return enterDeleteReason.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Enter Delete Reason field not found: " + e.getMessage());
	            return false;
	        }
	    }

	    public boolean isClickDeleteAccountButtonDisplayed() {
	        try {
	            wait.until(ExpectedConditions.visibilityOf(clickDeleteAccount));
	            System.out.println("✅ Delete Account button is present.");
	            return clickDeleteAccount.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("❌ Delete Account button not found: Hey " + e.getMessage());
	            return false;
	        }
	    }

	}