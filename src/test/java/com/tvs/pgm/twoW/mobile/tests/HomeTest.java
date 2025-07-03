package com.tvs.pgm.twoW.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tvs.pgm.twoW.mobile.pages.HomePage;

public class HomeTest extends BaseTest{
	
	private HomePage homePage;

    @BeforeClass
    public void setup(){
        homePage = new HomePage();
    }
    
    @Test(priority = 1, description = "Verify that the setting Icon is present on the Homepage")
    public void settingIconpresent(){
        Assert.assertEquals(homePage.verifySettingPresent(), true);
    }

    @Test(priority = 2, description = "Verify that the profile Icon is present on the Homepage")
    public void profileIconePresent(){
        Assert.assertEquals(homePage.verifyProfilePresent(), true);
    }

    @Test(priority = 3, description = "Verify that the Need Any Help tile is present on the screen")
    public void verifyNeedAnyHelpTileVisible(){
        homePage.checkHelpTile();
    }

    @Test(priority = 4,description = "Verify that the Find a Dealer tile is present on the screen")
    public void verifyFindDealerTileVisible(){
        homePage.checkFindDealerTile();
    }

    @Test(priority = 5, description = "Verify that the Vehicle_Services tile is present on the screen")
    public void verifyVehicleServicesTileVisible(){
        homePage.vehicleServiesTile();
    }

    @Test(priority = 6, description = "Verify that the Traingin and Troubleshooting tile is present on the screen")
    public void verifyTrainingTileVisible(){
        homePage.checkTraingTile();
    }

    @Test(priority = 7, description = "Verify that the Referral tile is present on the screen")
    public void verifyReferralTileVisible(){
        homePage.checkRefferalTile();
    }


}
