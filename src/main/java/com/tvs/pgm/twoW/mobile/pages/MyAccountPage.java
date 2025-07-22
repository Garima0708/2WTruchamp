package com.tvs.pgm.twoW.mobile.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyAccountPage extends BasePage{
	
	 @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]")
	    private WebElement myAccountImage;

	    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView[1]")
	    private WebElement profileEdit;

	    @AndroidFindBy(xpath = "//android.widget.ImageView[@text=\"Tate\"]")
	    private WebElement nameEdit;

	    @AndroidFindBy(accessibility = "Update")
	    private WebElement updateName;
	    
	    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	    private WebElement emailEdit;
	    
	    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Update\"])[2]")
	    private WebElement emailUpdate;
	    
	    
	    public MyAccountPage() {
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }
     
	    public void clickOnMyAccountButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(myAccountImage));
	        myAccountImage.click();
	    }
	    
	   public void  check() {
		   
	   }
}
