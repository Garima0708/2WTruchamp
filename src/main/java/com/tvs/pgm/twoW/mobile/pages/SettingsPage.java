package com.tvs.pgm.twoW.mobile.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {
	  @FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")
	    private WebElement settingIcon;

	    @FindBy(xpath="//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]")
	    private WebElement profileIcon;

	    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Need Any Help\"]")
	    private WebElement needAnyHelp;

	    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Find A Dealer\"]")
	    private WebElement findDealer;

	    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Vehicle Services\"]")
	    private WebElement vehicleServies;

	    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Training & Troubleshooting\"]")
	    private WebElement trainingTroublshooting;

	    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Refer a Customer\"]")
	    private WebElement referCustomer;

	    public HomePage() {        
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	    }

	    public boolean verifySettingPresent(){
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(settingIcon));
	    System.out.println("setting icon found!");
	    return element.isDisplayed();
	    }

	    public boolean verifyProfilePresent() {
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(profileIcon));
	        System.out.println("Profile icon found!");
	        return element.isDisplayed();
	    }


	    public void clickOnSetting(){
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(settingIcon));
	        element.click();
	    }

	    public void clickOnProfie(){
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(profileIcon));
	        element.click();
	    }

	    public boolean checkHelpTile(){
	        try {
	            WebElement helpTile = wait.until(ExpectedConditions.visibilityOf(needAnyHelp));
	            return helpTile.isDisplayed();
	        } catch (TimeoutException e) {
	            System.out.println("Need Any Help tile did not appear in time!");
	            return false;
	        }   

	    }

	    public boolean checkRefferalTile(){
	        try {
	            WebElement referCustomers = wait.until(ExpectedConditions.visibilityOf(referCustomer));
	            return referCustomers.isDisplayed();
	        } catch (TimeoutException e) {
	            System.out.println("Refer tile did not appear in time!");
	            return false;
	        }   
	    }

	    public boolean checkTraingTile(){
	        try {
	            WebElement traningTile = wait.until(ExpectedConditions.visibilityOf(trainingTroublshooting));
	            return traningTile.isDisplayed();
	        } catch (TimeoutException e) {
	            System.out.println("Trainging and Troubleshooting tile did not appear in time!");
	            return false;
	        }   
	    }

	    public boolean checkFindDealerTile(){
	        try {
	            WebElement findDealerTile = wait.until(ExpectedConditions.visibilityOf(findDealer));
	            return findDealerTile.isDisplayed();
	        } catch (TimeoutException e) {
	            System.out.println("Find A Dealer tile did not appear in time!");
	            return false;
	        }   
	    }

	    public boolean vehicleServiesTile(){
	        try {
	            WebElement findDealerTile = wait.until(ExpectedConditions.visibilityOf(vehicleServies));
	            return findDealerTile.isDisplayed();
	        } catch (TimeoutException e) {
	            System.out.println("Vehicle Services tile did not appear in time!");
	            return false;
	        }   
	    }

	    public void  clickonHelpTile(){
	        needAnyHelp.click();
	    }

	    public void clickOnFindDealer(){
	        findDealer.click();
	    }

	    public void clickOnVehicleServices(){
	        vehicleServies.click();
	    }

	    public void clickOnTraining(){
	        trainingTroublshooting.click();
	    }

	    public void clickOnReferCustomer() throws InterruptedException{
	        Thread.sleep(1000);
	        referCustomer.click();
	    }

	    public void scrollUp() {
	        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 500, 1500));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        
	        // Move to (500, 500) over 1 second
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 500, 500));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        
	        driver.perform(Collections.singletonList(swipe));
	    }
	    public void scrollDown() {
	        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 500, 500));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        
	        // Move to (500, 500) over 1 second
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 500, 1500));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        
	        driver.perform(Collections.singletonList(swipe));
	    }
}
