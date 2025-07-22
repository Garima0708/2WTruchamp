package com.tvs.pgm.twoW.mobile.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashboardPage extends BasePage {
//location access
    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement allowNotificationAccessText;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement clickAllow;
//scan 
    @AndroidFindBy(accessibility = "Scan For Rewards")
    private WebElement scanForRewardsText;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private WebElement cameraAccessPermissionText;
    

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private WebElement whileUsingTheAppText;

    @AndroidFindBy(accessibility = "Redeem")
    private WebElement redeemModule;
    
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement enterAmountField;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Redeem\"]")
    private WebElement redeemAmount;
    
    @AndroidFindBy(accessibility = "Enter OTP sent to")
    private WebElement verifyRedeemOtp;
    
    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement redeemOtpField;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Submit\"]")
    private WebElement redeemOtpSubmitButton;
    
    @AndroidFindBy(accessibility = "Your transaction with reference ID MRNDEV0000654 has been initiated. You will receive a status update shortly. ")
    private WebElement transactionInitiatPopup;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    private WebElement mrnNumberPopupOkText;

	/*
	 * @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]") private WebElement
	 * redeemBackArrow;
	 */

    @AndroidFindBy(accessibility = "Find Parts")
    private WebElement findPartsModule;

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement startForWhatsappBot;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View")
    private WebElement cancelFindPartsOnWhatsApp;
    
    @AndroidFindBy(accessibility = "Help")
    private WebElement help;
    
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Query / Request\"]")
    private WebElement createOrRequestQuery;
    
    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement queryTitle;
    
    @AndroidFindBy(accessibility = "Select Category")
    private WebElement selectCategory;
    
    @AndroidFindBy(accessibility = "Support Related")
    private WebElement chooseCategory;
    
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement addDescription;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Create Query / Request\"]")
    private WebElement createQuery;
    
 
    public DashboardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public String getNotificationAccessText() {
        wait.until(ExpectedConditions.visibilityOf(allowNotificationAccessText));
        return allowNotificationAccessText.getText();
    }

    public String getAllowButtonText() {
        wait.until(ExpectedConditions.visibilityOf(clickAllow));
        return clickAllow.getText();
    }

    public void clickAllowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickAllow));
        clickAllow.click();
    }

    public String getScanForRewardsText() {
        wait.until(ExpectedConditions.visibilityOf(scanForRewardsText));
        return scanForRewardsText.getAttribute("contentDescription");
    }

    public void clickOnScanForRewards() {
        wait.until(ExpectedConditions.elementToBeClickable(scanForRewardsText));
        scanForRewardsText.click();
    }

    public String getCameraAccessPermissionText() {
        wait.until(ExpectedConditions.visibilityOf(cameraAccessPermissionText));
        return cameraAccessPermissionText.getText();
    }

    public String getWhileUsingTheAppText() {
        wait.until(ExpectedConditions.visibilityOf(whileUsingTheAppText));
        return whileUsingTheAppText.getText();
    }

    public void clickOnWhileUsingTheAppPopUpText() {
        wait.until(ExpectedConditions.elementToBeClickable(whileUsingTheAppText));
        whileUsingTheAppText.click();
    }
    
    public String getRedeemText() {
        wait.until(ExpectedConditions.visibilityOf(redeemModule));
        return redeemModule.getAttribute("contentDescription");
    }
    
    public void clickOnRedeemText() {
        wait.until(ExpectedConditions.elementToBeClickable(redeemModule));
        redeemModule.click();
    }
    
    public String getEnterAmountText() {
        wait.until(ExpectedConditions.visibilityOf(enterAmountField));
        return enterAmountField.getAttribute("contentDescription");
    }

    public void clickAndEnterAmount() {
        wait.until(ExpectedConditions.elementToBeClickable(enterAmountField));
        enterAmountField.click();
        enterAmountField.clear();
        enterAmountField.sendKeys("4");
        driver.hideKeyboard();
    }
    
    public String getRedeemAmountText() {
        wait.until(ExpectedConditions.visibilityOf(redeemAmount));
        return redeemAmount.getAttribute("contentDescription");
    }

    public void clickOnRedeemAmount() {
        wait.until(ExpectedConditions.elementToBeClickable(redeemAmount));
        redeemAmount.click();
    }
    
    public boolean isRedeemOtpScreenDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(verifyRedeemOtp));
        return verifyRedeemOtp.isDisplayed();
    }

    public void clickOtpField() {
        wait.until(ExpectedConditions.visibilityOf(redeemOtpField));
        redeemOtpField.click();
		
    }

    public void enterRedeemOtp(String otp) {
        wait.until(ExpectedConditions.elementToBeClickable(redeemOtpField));
        redeemOtpField.click();
        redeemOtpField.clear();
        redeemOtpField.sendKeys(otp);
    }
    
    public boolean isSubmitButtonEnable() {
        wait.until(ExpectedConditions.visibilityOf(redeemOtpSubmitButton)); // Wait until visible
        return redeemOtpSubmitButton.isEnabled(); // Then check if it's enabled
    }

    public void clickOnRedeemOtpSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(redeemOtpSubmitButton)); // Wait until clickable
        redeemOtpSubmitButton.click(); // Then click
    }
    
    public String generateUniqueMRN() {
    	
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String mrn = ("MRNDEV" + timestamp).substring(0, 20); // Force 20 chars
        return mrn;
    }
    
    public String getTransactionInitiatPopupText(String mrn) {
        
    	 System.out.println("Your transaction with reference ID\n" +
                 mrn + " has been initiated.\n" +
                 "You will receive a status update\nshortly");
		return mrn;
    }
    
    public void clickOnMrmNumberOkText()
    {
        wait.until(ExpectedConditions.elementToBeClickable(mrnNumberPopupOkText));
        mrnNumberPopupOkText.click();
    }
    
	/*
	 * public void clickOnBackToDashboardRedeemSign() {
	 * wait.until(ExpectedConditions.elementToBeClickable(redeemBackArrow));
	 * redeemBackArrow.click(); }
	 */

    public String getFindPartsText() {
        wait.until(ExpectedConditions.visibilityOf(findPartsModule));
        return findPartsModule.getAttribute("contentDescription");
    }

    public void clickOnFindParts() {
        wait.until(ExpectedConditions.elementToBeClickable(findPartsModule));
        findPartsModule.click();
    }

    public String getStartForWhatsappBot() {
        wait.until(ExpectedConditions.visibilityOf(startForWhatsappBot));
        return startForWhatsappBot.getText();
    }

    public void clickOnStartForWhatsappBot() {
        wait.until(ExpectedConditions.elementToBeClickable(startForWhatsappBot));
        startForWhatsappBot.click();
    }

    public void clickOnCancelFindPartsOnWhatsApp() {
        wait.until(ExpectedConditions.visibilityOf(cancelFindPartsOnWhatsApp));
        wait.until(ExpectedConditions.elementToBeClickable(cancelFindPartsOnWhatsApp));
        cancelFindPartsOnWhatsApp.click();
    }
    
    public String getHelpText() {
        wait.until(ExpectedConditions.visibilityOf(help));
        return help.getAttribute("contentDescription");
    }

    public void clickOnHelp() {
        wait.until(ExpectedConditions.elementToBeClickable(help));
        help.click();
    }
    
    public String getCreateOrRequestQueryText() {
        wait.until(ExpectedConditions.visibilityOf(createOrRequestQuery));
        return createOrRequestQuery.getAttribute("contentDescription");
    }

    public void clickOnCreateOrRequestQuery() {
        wait.until(ExpectedConditions.elementToBeClickable(createOrRequestQuery));
        createOrRequestQuery.click();
    }
    
    public String getQueryTitleText() {
        wait.until(ExpectedConditions.visibilityOf(queryTitle));
        return queryTitle.getAttribute("contentDescription");
    }

    public void clickOnAndAddQueryTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(queryTitle));
        queryTitle.click();
        queryTitle.clear();
        queryTitle.sendKeys("Automation Query Request Title : hi");
    }
    
    public String getSelectCategoryText() {
        wait.until(ExpectedConditions.visibilityOf(selectCategory));
        return selectCategory.getAttribute("contentDescription");
    }

    public void clickOnSelectCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(selectCategory));
        selectCategory.click();
    }
    
    public String getChooseCategoryText() {
        wait.until(ExpectedConditions.visibilityOf(chooseCategory));
        return chooseCategory.getAttribute("contentDescription");
    }

    public void clickOnChooseCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseCategory));
        chooseCategory.click();
    }
    
    public String getAddDescriptionText() {
        wait.until(ExpectedConditions.visibilityOf(addDescription));
        return addDescription.getAttribute("contentDescription");
    }

    public void clickOnAndAddDescription() {
        wait.until(ExpectedConditions.elementToBeClickable(addDescription));
        addDescription.click();
        addDescription.clear();
        addDescription.sendKeys("Automation Query Request Description : support Related");
        driver.hideKeyboard();
    }
	/*
	 * public String getCreateQueryText() { scrollUntilVisible(By.
	 * xpath("//android.widget.Button[@content-desc='Create Query / Request']"));
	 * wait.until(ExpectedConditions.visibilityOf(createQuery)); return
	 * createQuery.getAttribute("contentDescription"); }
	 */
    
    public String getCreateQueryText() {
        WebElement element = scrollToElementByDescription("Create Query / Request");
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("contentDescription");
    }

    public void clickOnCreateQuery() {
        wait.until(ExpectedConditions.elementToBeClickable(createQuery));
        createQuery.click();
    }
    
    public List<String[]> printAllQueryIdsAndStatuses() {
        Set<String> seenContent = new HashSet<>();
        List<String[]> queryData = new ArrayList<>();

        boolean canScroll = true;
        int scrollCount = 0;
        int maxScroll = 10;

        while (canScroll && scrollCount < maxScroll) {
            List<WebElement> queries = driver.findElements(By.xpath("//android.view.View[contains(@content-desc, '#')]"));

            for (WebElement query : queries) {
                String content = query.getAttribute("content-desc");
                if (content == null || seenContent.contains(content)) continue;

                seenContent.add(content);
                String[] lines = content.split("\n");

                try {
                    String queryId = lines[0].trim();              // e.g., #101828
                    String title = lines.length > 2 ? lines[2].trim() : "Unknown";
                    String status = lines.length > 3 ? lines[3].trim() : "Unknown"; // try to fetch 4th line

                    System.out.println("Query ID: " + queryId + " | Title: " + title + " | Status: " + status);
                    queryData.add(new String[]{queryId, title, status});

                } catch (Exception e) {
                    System.out.println("❌ Failed to parse: " + content);
                }
            }

            scrollCount++;
            canScroll = scrollDown();
        }

        return queryData;

    }
    public boolean scrollDown() {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "down");
            params.put("percent", 0.8); // Scroll 80% of the screen
            params.put("left", 100);    // Optional: Adjust as per screen layout
            params.put("top", 200);     // Optional
            params.put("width", 800);   // Optional
            params.put("height", 1000); // Optional

            ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", params);
            return true;
        } catch (Exception e) {
            System.out.println("No more scroll possible.");
            return false;
        }
    }
}
