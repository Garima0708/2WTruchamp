package com.tvs.pgm.twoW.mobile.tests;

import java.net.MalformedURLException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tvs.pgm.twoW.mobile.pages.DashboardPage;
import com.tvs.pgm.twoW.mobile.base.DriverManager;
import com.tvs.pgm.twoW.mobile.listeners.TestListener;

@Listeners(TestListener.class)
public class DashboardTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeClass(alwaysRun = true)
    public void classSetup() throws MalformedURLException {
        DriverManager.initializeDriver();
        dashboardPage = new DashboardPage();
        System.out.println("Driver initialized: " + DriverManager.getDriver());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test(priority = 1)
    public void verifyNotificationAccessText() {
        String actualText = dashboardPage.getNotificationAccessText();
        Assert.assertEquals(actualText, "Allow TRUCHAMP to send you notifications?");
    }

    @Test(priority = 2)
    public void verifyAllowButtonDisplayed() {
        String actualText = dashboardPage.getAllowButtonText();
        Assert.assertEquals(actualText, "Allow");
    }

    @Test(priority = 3)
    public void clickAllowButton() {
        dashboardPage.clickAllowButton();
    }

    @Test(priority = 4)
    public void verifyScanForRewardsText() {
        String actualText = dashboardPage.getScanForRewardsText();
        Assert.assertEquals(actualText, "Scan For Rewards");
    }

    @Test(priority = 5)
    public void clickScanForRewardsButton() {
        dashboardPage.clickOnScanForRewards();
    }

    @Test(priority = 6)
    public void verifyCameraPermissionText() {
        String actualText = dashboardPage.getCameraAccessPermissionText();
        Assert.assertEquals(actualText, "Allow TRUCHAMP to take pictures and record video?");
    }

    @Test(priority = 7)
    public void verifyWhileUsingTheAppText() {
        String actualText = dashboardPage.getWhileUsingTheAppText();
        Assert.assertEquals(actualText, "While using the app");
    }

    @Test(priority = 8)
    public void clickWhileUsingTheApp() {
        dashboardPage.clickOnWhileUsingTheAppPopUpText();
    }

    // Redeem flow tests
    @Test(priority = 9, groups = {"Redeem"})
    public void verifyRedeemText() {
        String actualText = dashboardPage.getRedeemText();
        Assert.assertEquals(actualText, "Redeem");
    }
 // Redeem flow tests
    @Test(priority = 10, groups = {"Redeem"})
    public void clickRedeem() {
        dashboardPage.clickOnRedeemText();
    }
 // Redeem flow tests
    @Test(priority = 11,  groups = {"Redeem"})
    public void verifyEnterAmountTextDisplayed() {
        String actualHint = dashboardPage.getEnterAmountText();
        Assert.assertNotNull(actualHint, "Hint text should not be null");
        Assert.assertEquals(actualHint.trim(), "Enter Amount", "Placeholder text mismatch");
    }
 // Redeem flow tests
    @Test(priority = 12, groups = {"Redeem"})
    public void clickAndEnterAmountRedeem() {
        dashboardPage.clickAndEnterAmount();
    }
 // Redeem flow tests
    @Test(priority = 13, groups = {"Redeem"})
    public void verifyRedeemAmountText() {
        String actualText = dashboardPage.getRedeemAmountText();
        Assert.assertNotNull(actualText, "Redeem Amount text should not be null");
        Assert.assertEquals(actualText, "Redeem"); // Replace with actual expected text
    }
 // Redeem flow tests
    @Test(priority = 14,  groups = {"Redeem"})
    public void clickOnRedeemAmountText() {
        dashboardPage.getRedeemAmountText();
    }
 // Redeem flow tests
    @Test(priority = 15,  groups = {"Redeem"})
    public void clickOnRedeemAmount() {
    	dashboardPage.clickOnRedeemAmount();
    }
 // Redeem flow tests
    @Test(priority = 16,  groups = {"Redeem"})
    public  void verifyIsRedeemOtpScreenDisplayed() {
        Assert.assertTrue(dashboardPage.isRedeemOtpScreenDisplayed(), "OTP screen is not displayed.");
    }
 // Redeem flow tests
    @Test(priority = 17,  groups = {"Redeem"})
    public void clickOtpField() {
    	dashboardPage.clickOtpField();
    }
 // Redeem flow tests
    @Test(priority = 18,  groups = {"Redeem"})
    public void enterRedeemOtp() {
    	dashboardPage.enterRedeemOtp("54321");
    }
 // Redeem flow tests
    @Test(priority = 19, groups = {"Redeem"})
    public void verifyIsRedeemSubmitButtonEnable() {
        Assert.assertTrue(dashboardPage.isSubmitButtonEnable(), "OTP Submit button is not enabled or visible.");
    }
 // Redeem flow tests
    @Test(priority = 20, groups = {"Redeem"})
    public void clickOnOtpSubmitButton() {
        dashboardPage.clickOnRedeemOtpSubmitButton();
    }
 // Redeem flow tests 
    @Test(priority = 21, groups = {"Redeem"})
    public void verifyUniqueMRNGeneration() {
        String mrn = dashboardPage.generateUniqueMRN();// Call MRN method
        dashboardPage.getTransactionInitiatPopupText(mrn);     // Print transaction message

        // Optional: Add assertion to check MRN pattern
        Assert.assertTrue(mrn.startsWith("MRNDEV"), "MRN format is incorrect");
        Assert.assertEquals(mrn.length(), 20, "MRN length should be 20 characters");
    }
 // Redeem flow tests 
    @Test(priority = 22, groups = {"Redeem"})
    public void clickOnMrmNumberOkText() {
        dashboardPage.clickOnMrmNumberOkText();
    }
    

	/*
	 * @Test(priority = 22, groups = {"Redeem"}) public void
	 * clickBackArrowOnRedeem() { dashboardPage.clickOnBackToDashboardRedeemSign();
	 * }
	 */

    // Find Parts Flow
    @Test(priority = 23)
    public void verifyFindPartsText() {
        String actualText = dashboardPage.getFindPartsText();
        Assert.assertEquals(actualText, "Find Parts");
    }
 // Find Parts Flow
    @Test(priority = 24)
    public void clickFindParts() {
        dashboardPage.clickOnFindParts();
    }
 // Find Parts Flow
    @Test(priority = 25)
    public void clickCancelOnWhatsAppBot() {
        dashboardPage.clickOnCancelFindPartsOnWhatsApp();
    }

    // Query Flow
    @Test(priority = 26, groups = {"Query"})
    public void verifyHelpText() {
        String actualText = dashboardPage.getHelpText();
        Assert.assertEquals(actualText, "Help");
    }
 // Query Flow
    @Test(priority = 27, groups = {"Query"})
    public void clickOnHelp() {
        dashboardPage.clickOnHelp();
    }
 // Query Flow
    @Test(priority = 28, groups = {"Query"})
    public void verifyCreateOrRequestQueryText() {
        String actualText = dashboardPage.getCreateOrRequestQueryText();
        Assert.assertEquals(actualText, "Create Query / Request");
    }
 // Query Flow
    @Test(priority = 29, groups = {"Query"})
    public void clickCreateOrRequestQuery() {
        dashboardPage.clickOnCreateOrRequestQuery();
    }
 // Query Flow
    @Test(priority = 30, groups = {"Query"})
    public void verifyQueryTitleText() {
        String actualText = dashboardPage.getQueryTitleText();
        Assert.assertEquals(actualText, "Enter Here");
    }
 // Query Flow
    @Test(priority = 31, groups = {"Query"})
    public void clickAndEnterQueryTitle() {
        dashboardPage.clickOnAndAddQueryTitle();
    }
 // Query Flow
    @Test(priority = 32, groups = {"Query"})
    public void verifySelectCategoryText() {
        String actualText = dashboardPage.getSelectCategoryText();
        Assert.assertEquals(actualText, "Select Category");
    }
 // Query Flow
    @Test(priority = 33, groups = {"Query"})
    public void clickOnSelectCategory() {
        dashboardPage.clickOnSelectCategory();
    }
 // Query Flow
    @Test(priority = 34, groups = {"Query"})
    public void verifyChooseCategoryText() {
        String actualText = dashboardPage.getChooseCategoryText();
        Assert.assertEquals(actualText, "Support Related");
    }
 // Query Flow
    @Test(priority = 35, groups = {"Query"})
    public void clickChooseCategory() {
        dashboardPage.clickOnChooseCategory();
    }
 // Query Flow
    @Test(priority = 36, groups = {"Query"})
    public void verifyAddDescriptionText() {
        String actualText = dashboardPage.getAddDescriptionText();
        Assert.assertEquals(actualText, "Enter Description Here");
    }
 // Query Flow
    @Test(priority = 37, groups = {"Query"})
    public void clickAndEnterAddDescription() {
        dashboardPage.clickOnAndAddDescription();
    }
 // Query Flow
    @Test(priority = 38, groups = {"Query"})
    public void verifyCreateQueryText() {
        String actualText = dashboardPage.getCreateQueryText();
        Assert.assertEquals(actualText, "Create Query / Request");
    }
 // Query Flow
    @Test(priority = 39, groups = {"Query"})
    public void clickOnCreateQuery() {
        dashboardPage.clickOnCreateQuery(); // Ensure this method exists in DashboardPage
    }
    @Test(priority = 40, groups = {"Query"})
    public void clickOnHelpQuery() {
        dashboardPage.clickOnHelp();
    }
    
    @Test(priority = 41, groups = {"Query"})
    public void verifyAllQueryStatus() {
        // This already prints each query internally
        List<String[]> allQueryData = dashboardPage.printAllQueryIdsAndStatuses();

        // Just print total count here
        System.out.println("Total queries found: " + allQueryData.size());

        System.out.println("✅ Test Passed: verifyAllQueryStatus");
    }
    
}
