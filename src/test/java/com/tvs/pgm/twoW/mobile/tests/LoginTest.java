package com.tvs.pgm.twoW.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tvs.pgm.twoW.mobile.pages.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginPage;

    @BeforeClass
    public void setup(){
       loginPage = new LoginPage();
    }

    // @Test(priority = 1)
    // public void verifyLangauge(){
    //     Assert.assertEquals(loginPage.verifyLaungaugeText(), "English");
    // }
    @Test(priority = 1, description = "Verify that Location permission is present on the Login Page")
    	public void locationPermissionText() {
    	test.info("Checking Location permission text......");
    	 try{
             Assert.assertTrue(loginPage.isLocationPermissionTextDisplayed(), "Locations Permission text is NOT present on the screen!");
             test.pass("Verify that text found successfully");
         }catch(Exception e){
             test.fail("Location Permission text not found" + e.getMessage());
             throw e;
         }
    	}
    @Test(priority =2, description = "Verify that user can see Enter Mobile Number Text on the Login screen")
    public void testTextField() {
        test.info("Checking Login page Text........");
        try{
            Assert.assertTrue(loginPage.isEnterMobileNumberDisplayed(), "Enter Mobile Number text is NOT present on the screen!");
            test.pass("Verify that text found successfully");
        }catch(Exception e){
            test.fail("Enter Mobile Number text not found" + e.getMessage());
            throw e;
        }
    }


    @Test(priority=3, description = "Verify that the system not able to move forward with less than 10 digit")
    public void wrongMobileNumber(){
        loginPage.enterMobileNumber("1223334");        
        Assert.assertFalse(loginPage.isverifyNumberButtonNotClickable());

    }

    
    @Test(priority = 4, description = "Verify that the user can enter 10 digit mobile number in the Mobile Number field")
    public void enterMob(){
        loginPage.enterMobileNumber("6100000000");
        
    }

    @Test(priority = 5, description= "Verify that the user is able to land on the OTP Screen")
    public void clickVerifyNumberButton(){
        System.out.println(loginPage.isverifyNumberButtonClickable());
        loginPage.clickVerifyNumber();
    }
}
