package com.tvs.pgm.twoW.mobile.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tvs.pgm.twoW.mobile.base.DriverManager;
import com.tvs.pgm.twoW.mobile.listeners.TestListener;
import com.tvs.pgm.twoW.mobile.pages.MyAccountPage;

@Listeners(TestListener.class)
public class MyAccountTest extends BaseTest{
	
	private MyAccountPage myAccountPage;
	
	@BeforeClass(alwaysRun = true)
    public void classSetup() throws MalformedURLException {
        DriverManager.initializeDriver();
        myAccountPage = new MyAccountPage();
        System.out.println("Driver initialized: " + DriverManager.getDriver());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
    
    @Test(priority = 1)
    public void clickMyAccountButton() {
        myAccountPage.clickOnMyAccountButton();
    }


}
