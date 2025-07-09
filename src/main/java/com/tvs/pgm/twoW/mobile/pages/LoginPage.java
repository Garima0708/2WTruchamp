package com.tvs.pgm.twoW.mobile.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
	
	private WebElement locationPermissionText;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement locationPermissionWhileUsing;
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Enter Mobile Number\"]")
    private WebElement enterMobileNumberText;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterMobileNumberField;
    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Verify Number\"]")
    private WebElement verifyNumberButton;

    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"English\"]")
    private WebElement laungageDropdown;
    
    @AndroidFindBy(accessibility ="Enter OTP sent to")
    private WebElement verifyEnterOtpText;
    
    @AndroidFindBy(className  ="android.widget.EditText")
    private WebElement clickEnterOtpField;
    
    
    public LoginPage() {
        
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public boolean isLocationPermissionTextDisplayed() {
    	return locationPermissionText.isDisplayed();
    }
    
    public void locationPermssionWhileUsing() {
    	locationPermissionWhileUsing.click();
		
    }
    
    public boolean isEnterMobileNumberDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(enterMobileNumberText));
        return enterMobileNumberText.isDisplayed();
        
    }

    public void enterMobileNumber(String mobileNumber){
       // wait.until(ExpectedConditions.elementToBeClickable(enterMobileNumberField));
        enterMobileNumberField.click();
        enterMobileNumberField.clear();
        enterMobileNumberField.sendKeys(mobileNumber);
    }

    public boolean isverifyNumberButtonClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        return verifyNumberButton.isEnabled();
    }

    public boolean isverifyNumberButtonNotClickable(){
        //wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        return verifyNumberButton.isEnabled();
    }

   

    public void clickVerifyNumber(){
      //  wait.until(ExpectedConditions.elementToBeClickable(verifyNumberButton));
        verifyNumberButton.click();
    }
 
    public  boolean isVerifyEnterOtpTextDisplayed(){
    	wait.until(ExpectedConditions.invisibilityOf(verifyEnterOtpText));
		return verifyEnterOtpText.isDisplayed();
    	
    }
    
    public boolean clickEnterOtp() {
     wait.until(ExpectedConditions.elementToBeClickable(clickEnterOtpField));
        wait.until(ExpectedConditions.elementToBeClickable(clickEnterOtpField));
        boolean isEnabled = clickEnterOtpField.isEnabled();
        if (isEnabled) {
            clickEnterOtpField.click();
        }
        return isEnabled;
    }
    public void enterOtp(String otp) {
        wait.until(ExpectedConditions.elementToBeClickable(clickEnterOtpField));
        clickEnterOtpField.click();
        clickEnterOtpField.clear();
        clickEnterOtpField.sendKeys(otp);
    }
    
    // public String verifyPlaceHoldervalue(){
    //     String plcaeholderName=enterMobileNumberField.getAttribute("value");
    //     return plcaeholderName;
    // }

    // public String verifyLaungaugeText(){
    //     String text=laungageDropdown.getText();
    //     return text;
    // }

}
