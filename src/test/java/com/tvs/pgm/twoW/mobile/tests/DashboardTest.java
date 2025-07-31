package com.tvs.pgm.twoW.mobile.tests;
import java.util.List;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tvs.pgm.twoW.mobile.pages.DashboardPage;
import com.tvs.pgm.twoW.mobile.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tvs.pgm.twoW.mobile.listeners.SkipAfterFailRetryAnalyzer;
import com.tvs.pgm.twoW.mobile.listeners.TestListener;

@Listeners(TestListener.class)
public class DashboardTest extends BaseTest {

    private DashboardPage dashboardPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass(alwaysRun = true)
    public void setupPage() {
        extent = ExtentReportManager.getInstance();
        test = extent.createTest("Login Test Suite");
        dashboardPage = new DashboardPage(test);  // Pass ExtentTest to page
    }
   
    @Test(priority = 1, description = "Verify that the notification access text is correct")
    public void verifyNotificationAccessText() {
        test.info("✅ Checking if notification access popup is displayed");
        Assert.assertEquals(dashboardPage.getNotificationAccessText(),
            "Allow TRUCHAMP to send you notifications?", 
            "❌ Notification access text is incorrect.");
    }

    @Test(priority = 2, description = "Verify that the Allow button is displayed")
    public void verifyAllowButtonDisplayed() {
        test.info("✅ Checking if Allow button is displayed on notification popup");
        Assert.assertEquals(
            dashboardPage.getAllowButtonText(),
            "Allow",
            "❌ Allow button text is incorrect or not displayed."
        );
    }

    @Test(priority = 3, description = "Click the Allow button on notification permission")
    public void clickAllowButton() {
        test.info("✅ Clicking on the Allow button in notification popup");
        dashboardPage.clickAllowButton();
    }

    @Test(priority = 4, description = "Verify Scan for Rewards text is visible")
    public void verifyScanForRewardsText() {
        test.info("✅ Verifying if 'Scan For Rewards' text is displayed on dashboard");
        Assert.assertEquals(
            dashboardPage.getScanForRewardsText(),
            "Scan For Rewards",
            "❌ 'Scan For Rewards' text is incorrect or missing."
        );
    }
    @Test(priority = 5, description = "Click on Scan for Rewards button")
    public void clickScanForRewardsButton() {
        test.info("✅ Clicking on 'Scan For Rewards' button");
        dashboardPage.clickOnScanForRewards();
    }

    @Test(priority = 6, description = "Verify camera permission text")
    public void verifyCameraPermissionText() {
        test.info("✅ Verifying camera permission text");
        Assert.assertEquals(
            dashboardPage.getCameraAccessPermissionText(),
            "Allow TRUCHAMP to take pictures and record video?",
            "❌ Camera permission text is incorrect."
        );
    }

    @Test(priority = 7, description = "Verify 'While using the app' permission text")
    public void verifyWhileUsingTheAppText() {
        test.info("✅ Verifying 'While using the app' text on camera permission popup");
        Assert.assertEquals(
            dashboardPage.getWhileUsingTheAppText(),
            "While using the app",
            "❌ 'While using the app' text is incorrect or not found."
        );
    }

    @Test(priority = 8, description = "Click on 'While using the app' option")
    public void clickWhileUsingTheApp() {
        test.info("✅ Clicking on 'While using the app' option in camera permission popup");
        dashboardPage.clickOnWhileUsingTheAppPopUpText();
    }

    @Test(priority = 9, description = "Verify 'Redeem' text is visible", groups = {"Redeem"}, retryAnalyzer = SkipAfterFailRetryAnalyzer.class)
    public void verifyRedeemText() {
        test.info("✅ Verifying if 'Redeem' module is visible on Dashboard");

        if (SkipAfterFailRetryAnalyzer.hasPreviouslyFailed()) {
            test.skip("⏭ Skipping 'verifyRedeemText' as it previously failed.");
            throw new SkipException("Skipping test because it previously failed.");
        }

        Assert.assertEquals(
            dashboardPage.getRedeemText(),
            "Redeem",
            "❌ 'Redeem' text not found on the dashboard."
        );
    }

    @Test(priority = 10, description = "Click on 'Redeem' button", groups = {"Redeem"})
    public void clickRedeem() {
        test.info("✅ Clicking on 'Redeem' module on Dashboard");
        dashboardPage.clickOnRedeemText();
    }

    @Test(priority = 11, description = "Verify 'Enter Amount' field is displayed", groups = {"Redeem"})
    public void verifyEnterAmountTextDisplayed() {
        test.info("✅ Verifying if 'Enter Amount' field is displayed");
        String actualHint = dashboardPage.getEnterAmountText();
        Assert.assertNotNull(actualHint, "❌ 'Enter Amount' hint text is null.");
        Assert.assertEquals(actualHint.trim(), "Enter Amount", "❌ 'Enter Amount' text mismatch.");
    }

    @Test(priority = 12, description = "Click and enter amount for redeem", groups = {"Redeem"})
    public void clickAndEnterAmountRedeem() {
        test.info("✅ Clicking on 'Enter Amount' field and entering redeem value");
        dashboardPage.clickAndEnterAmount();
    }

    @Test(priority = 13, description = "Verify 'Redeem Amount' text is displayed", groups = {"Redeem"})
    public void verifyRedeemAmountText() {
        test.info("✅ Verifying 'Redeem Amount' button text");
        Assert.assertEquals(
            dashboardPage.getRedeemAmountText(),
            "Redeem",
            "❌ 'Redeem' button text is incorrect."
        );
    }

    @Test(priority = 14, description = "Get Redeem Amount text", groups = {"Redeem"})
    public void getRedeemAmountTextAgain() {
        test.info("ℹ️ Fetching 'Redeem Amount' button text again (for logging/debugging)");
        dashboardPage.getRedeemAmountText(); // no assertion, just a logging step
    }

    @Test(priority = 15, description = "Click on Redeem Amount", groups = {"Redeem"})
    public void clickOnRedeemAmount() {
        test.info("✅ Clicking on 'Redeem Amount' button to submit");
        dashboardPage.clickOnRedeemAmount();
    }

    @Test(priority = 16, description = "Verify OTP screen is displayed", groups = {"Redeem"})
    public void verifyIsRedeemOtpScreenDisplayed() {
        test.info("✅ Checking if the OTP screen is displayed after redeem initiation");
        Assert.assertTrue(
            dashboardPage.isRedeemOtpScreenDisplayed(),
            "❌ OTP screen is not displayed."
        );
    }

    @Test(priority = 17, description = "Click on OTP field", groups = {"Redeem"})
    public void clickOtpField() {
        test.info("✅ Clicking on the OTP input field");
        dashboardPage.clickOtpField();
    }

    @Test(priority = 18, description = "Enter OTP for redeem", groups = {"Redeem"})
    public void enterRedeemOtp() {
        test.info("✅ Entering redeem OTP: 54321");
        dashboardPage.enterRedeemOtp("54321");
    }

    @Test(priority = 19, description = "Verify OTP submit button is enabled", groups = {"Redeem"})
    public void verifyIsRedeemSubmitButtonEnable() {
        test.info("✅ Verifying if the OTP Submit button is enabled");
        Assert.assertTrue(
            dashboardPage.isSubmitButtonEnable(),
            "❌ OTP Submit button is not enabled or visible."
        );
    }

    @Test(priority = 20, description = "Click on OTP Submit Button", groups = {"Redeem"})
    public void clickOnOtpSubmitButton() {
        test.info("✅ Clicking on the OTP Submit button to complete redeem");
        dashboardPage.clickOnRedeemOtpSubmitButton();
    }


    @Test(priority = 21, description = "Verify MRN is generated correctly", groups = {"Redeem"})
    public void verifyUniqueMRNGeneration() {
        test.info("✅ Generating unique MRN after redeem");
        String mrn = dashboardPage.generateUniqueMRN();

        test.info("✅ Verifying transaction initiation popup using MRN: " + mrn);
        dashboardPage.getTransactionInitiatPopupText(mrn);

        Assert.assertTrue(mrn.startsWith("MRNDEV"), "❌ MRN format is incorrect");
        Assert.assertEquals(mrn.length(), 20, "❌ MRN length should be 20 characters");
    }

    @Test(priority = 22, description = "Click OK on MRN success popup", groups = {"Redeem"})
    public void clickOnMrmNumberOkText() {
        test.info("✅ Clicking on OK button in MRN success popup");
        dashboardPage.clickOnMrmNumberOkText();
    }

    // -------- Find Parts --------

    @Test(priority = 23, description = "Verify 'Find Parts' module text")
    public void verifyFindPartsText() {
        test.info("✅ Verifying 'Find Parts' module text is displayed correctly");
        Assert.assertEquals(dashboardPage.getFindPartsText(), "Find Parts", "❌ 'Find Parts' text is incorrect");
    }

    @Test(priority = 24, description = "Click on 'Find Parts'")
    public void clickFindParts() {
        test.info("✅ Clicking on 'Find Parts' button");
        dashboardPage.clickOnFindParts();
    }

    @Test(priority = 25, description = "Click cancel on WhatsApp bot popup")
    public void clickCancelOnWhatsAppBot() {
        test.info("✅ Cancelling WhatsApp bot popup for 'Find Parts'");
        dashboardPage.clickOnCancelFindPartsOnWhatsApp();
    }
    // -------- Help & Query Flow --------
    @Test(priority = 26, description = "Verify 'Help' text", groups = {"Query"})
    public void verifyHelpText() {
        test.info("✅ Verifying 'Help' module text is displayed correctly");
        Assert.assertEquals(dashboardPage.getHelpText(), "Help", "❌ 'Help' text is incorrect");
    }

    @Test(priority = 27, description = "Click on 'Help'", groups = {"Query"})
    public void clickOnHelp() {
        test.info("✅ Clicking on 'Help' module");
        dashboardPage.clickOnHelp();
    }

    @Test(priority = 28, description = "Verify 'Create Query / Request' text", groups = {"Query"})
    public void verifyCreateOrRequestQueryText() {
        test.info("✅ Verifying 'Create Query / Request' text is visible");
        Assert.assertEquals(dashboardPage.getCreateOrRequestQueryText(), "Create Query / Request", "❌ 'Create Query / Request' text is incorrect");
    }

    @Test(priority = 29, description = "Click on 'Create Query / Request'", groups = {"Query"})
    public void clickCreateOrRequestQuery() {
        test.info("✅ Clicking on 'Create Query / Request'");
        dashboardPage.clickOnCreateOrRequestQuery();
    }

    @Test(priority = 30, description = "Verify query title placeholder", groups = {"Query"})
    public void verifyQueryTitleText() {
        test.info("✅ Verifying placeholder text for query title field");
        Assert.assertEquals(dashboardPage.getQueryTitleText(), "Enter Here", "❌ Query title placeholder is incorrect");
    }

    @Test(priority = 31, description = "Click and enter query title", groups = {"Query"})
    public void clickAndEnterQueryTitle() {
        test.info("✅ Clicking and entering query title");
        dashboardPage.clickOnAndAddQueryTitle();
    }
    @Test(priority = 32, description = "Verify 'Select Category' placeholder", groups = {"Query"})
    public void verifySelectCategoryText() {
        test.info("✅ Verifying placeholder for 'Select Category'");
        Assert.assertEquals(dashboardPage.getSelectCategoryText(), "Select Category", "❌ Placeholder text for 'Select Category' is incorrect");
    }

    @Test(priority = 33, description = "Click on 'Select Category'", groups = {"Query"})
    public void clickOnSelectCategory() {
        test.info("✅ Clicking on 'Select Category'");
        dashboardPage.clickOnSelectCategory();
    }

    @Test(priority = 34, description = "Verify 'Support Related' is chosen", groups = {"Query"})
    public void verifyChooseCategoryText() {
        test.info("✅ Verifying selected category is 'Support Related'");
        Assert.assertEquals(dashboardPage.getChooseCategoryText(), "Support Related", "❌ Selected category is not 'Support Related'");
    }

    @Test(priority = 35, description = "Click on 'Support Related'", groups = {"Query"})
    public void clickChooseCategory() {
        test.info("✅ Clicking on 'Support Related' category");
        dashboardPage.clickOnChooseCategory();
    }

    @Test(priority = 36, description = "Verify add description placeholder", groups = {"Query"})
    public void verifyAddDescriptionText() {
        test.info("✅ Verifying description placeholder");
        Assert.assertEquals(dashboardPage.getAddDescriptionText(), "Enter Description Here", "❌ Description placeholder text is incorrect");
    }

    @Test(priority = 37, description = "Click and add description", groups = {"Query"})
    public void clickAndEnterAddDescription() {
        test.info("✅ Clicking and entering description");
        dashboardPage.clickOnAndAddDescription();
    }

    @Test(priority = 38, description = "Verify 'Create Query / Request' final button", groups = {"Query"})
    public void verifyCreateQueryText() {
        test.info("✅ Verifying final 'Create Query / Request' button text");
        Assert.assertEquals(dashboardPage.getCreateQueryText(), "Create Query / Request", "❌ Final create button text is incorrect");
    }

    @Test(priority = 39, description = "Click on Create Query", groups = {"Query"})
    public void clickOnCreateQuery() {
        test.info("✅ Clicking on 'Create Query / Request' to submit the query");
        dashboardPage.clickOnCreateQuery();
    }

    @Test(priority = 40, description = "Click on Help again from dashboard", groups = {"Query"})
    public void clickOnHelpQuery() {
        test.info("✅ Clicking 'Help' again from dashboard to check submitted queries");
        dashboardPage.clickOnHelp();
    }
    
    

    @Test(priority = 41, description = "Verify all query IDs and statuses", groups = {"Query"})
    public void verifyAllQueryStatus() {
        test.info("✅ Verifying query IDs and their statuses");
        List<String[]> allQueryData = dashboardPage.printAllQueryIdsAndStatuses();
        test.info("Total queries found: " + allQueryData.size());
        Assert.assertTrue(allQueryData.size() > 0, "❌ No queries found in the list");
        System.out.println("Total queries found: " + allQueryData.size());

    }
    
    @Test(priority = 42, description = "Click back to dashboard from Query", groups = {"Query"})
    public void clickBackToDashboard() {
        test.info("✅ Clicking back to Dashboard from Query section");
        dashboardPage.backToDashboard();
    }
    
} 